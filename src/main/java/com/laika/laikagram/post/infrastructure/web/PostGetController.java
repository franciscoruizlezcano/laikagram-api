package com.laika.laikagram.post.infrastructure.web;

import com.laika.laikagram.post.application.PostResponse;
import com.laika.laikagram.post.application.search_by_criteria.PostByQuerySearcher;
import com.laika.laikagram.post.infrastructure.persistence.HibernatePostRepository;
import com.laika.laikagram.shared.domain.util.JsonUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class PostGetController {
    private final PostByQuerySearcher searcher;

    public PostGetController() {
        this.searcher = new PostByQuerySearcher(new HibernatePostRepository());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) {

        PostResponse post = this.searcher.search(id);

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", post.id());
            put("caption", post.caption());
            put("url_media", post.urlMedia());
            put("user", new HashMap<String, Serializable>(){{
                put("id", post.user().id());
                put("username", post.user().username());
                put("url_photo", post.user().urlPhoto());
            }});
        }});
    }
}
