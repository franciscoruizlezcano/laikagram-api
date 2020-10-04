package com.laika.laikagram.follow.infrastructure.web;

import com.laika.laikagram.shared.domain.criteria.ParseFiltersUtil;
import com.laika.laikagram.follow.application.FollowsResponse;
import com.laika.laikagram.follow.application.search_by_criteria.FollowsByCriteriaSearcher;
import com.laika.laikagram.follow.infrastructure.persistence.HibernateFollowRepository;
import com.laika.laikagram.shared.domain.util.JsonUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class FollowsGetController {
    private final FollowsByCriteriaSearcher searcher;

    public FollowsGetController() {
        this.searcher = new FollowsByCriteriaSearcher(new HibernateFollowRepository());
    }

    @GetMapping("/follows")
    public ResponseEntity<List<HashMap<String, String>>> index(
            @RequestBody(required = false) HashMap<String, Serializable> params
    ) {
        if (params == null){
            params = new HashMap<>();
        }

        List<HashMap<String, Serializable>> filters = params.get("filters") == null ? Collections.EMPTY_LIST : (List<HashMap<String, Serializable>>) params.get("filters");

        FollowsResponse follows = this.searcher.search(
                ParseFiltersUtil.parse(filters),
                Optional.ofNullable((String) params.get("order_by")),
                Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable((Integer) params.get("limit")),
                Optional.ofNullable((Integer) params.get("offset"))
        );

        return ResponseEntity.ok().body(
                follows.follows().stream().map(response -> new HashMap<String, String>() {{
                    put("id", response.id());
                    put("followed", String.valueOf(new HashMap<String, Serializable>(){{
                        put("id", response.followed().id());
                        put("username", response.followed().username());
                        put("url_photo", response.followed().urlPhoto());
                    }}));
                    put("follower", String.valueOf(new HashMap<String, Serializable>(){{
                        put("id", response.follower().id());
                        put("username", response.follower().username());
                        put("url_photo", response.follower().urlPhoto());
                    }}));
                }}).collect(Collectors.toList())
        );
    }
}