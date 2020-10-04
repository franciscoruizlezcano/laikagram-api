package com.laika.laikagram.follow.infrastructure.web;

import com.laika.laikagram.follow.application.FollowResponse;
import com.laika.laikagram.follow.application.search_by_criteria.FollowByQuerySearcher;
import com.laika.laikagram.follow.infrastructure.persistence.HibernateFollowRepository;
import com.laika.laikagram.shared.domain.util.JsonUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class FollowGetController {
    private final FollowByQuerySearcher searcher;

    public FollowGetController() {
        this.searcher = new FollowByQuerySearcher(new HibernateFollowRepository());
    }

    @GetMapping("/follows/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) {

        FollowResponse follow = this.searcher.search(id);

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", follow.id());
            put("followed", new HashMap<String, Serializable>(){{
                put("id", follow.followed().id());
                put("username", follow.followed().username());
                put("url_photo", follow.followed().urlPhoto());
            }});
            put("follower", new HashMap<String, Serializable>(){{
                put("id", follow.follower().id());
                put("username", follow.follower().username());
                put("url_photo", follow.follower().urlPhoto());
            }});
        }});
    }
}
