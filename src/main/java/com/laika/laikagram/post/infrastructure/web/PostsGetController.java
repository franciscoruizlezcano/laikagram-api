package com.laika.laikagram.post.infrastructure.web;

import com.laika.laikagram.shared.domain.criteria.ParseFiltersUtil;
import com.laika.laikagram.post.application.PostsResponse;
import com.laika.laikagram.post.application.search_by_criteria.PostsByCriteriaSearcher;
import com.laika.laikagram.post.infrastructure.persistence.HibernatePostRepository;
import com.laika.laikagram.shared.domain.util.JsonUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class PostsGetController {
    private final PostsByCriteriaSearcher searcher;

    public PostsGetController() {
        this.searcher = new PostsByCriteriaSearcher(new HibernatePostRepository());
    }

    @GetMapping("/posts")
    public ResponseEntity<List<HashMap<String, String>>> index(
            @RequestBody HashMap<String, Serializable> params
    ) {
        List<HashMap<String, Serializable>> filters = params.get("filters") == null ? Collections.EMPTY_LIST : (List<HashMap<String, Serializable>>) params.get("filters");

        PostsResponse posts = this.searcher.search(
                ParseFiltersUtil.parse(filters),
                Optional.ofNullable((String) params.get("order_by")),
                Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable((Integer) params.get("limit")),
                Optional.ofNullable((Integer) params.get("offset"))
        );

        return ResponseEntity.ok().body(
                posts.posts().stream().map(response -> new HashMap<String, String>() {{
                    put("id", response.id());
                    put("caption", response.caption());
                    put("url_media", response.urlMedia());
                    put("user", String.valueOf(new HashMap<String, Serializable>(){{
                        put("id", response.user().id());
                        put("username", response.user().username());
                        put("url_photo", response.user().urlPhoto());
                    }}));
                }}).collect(Collectors.toList())
        );
    }
}