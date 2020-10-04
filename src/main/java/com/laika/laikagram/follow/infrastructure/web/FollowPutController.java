package com.laika.laikagram.follow.infrastructure.web;

import com.laika.laikagram.shared.infrastructure.JavaUuidGenerator;
import com.laika.laikagram.follow.application.CreateFollow;
import com.laika.laikagram.follow.application.creator.FollowCreator;
import com.laika.laikagram.follow.infrastructure.persistence.HibernateFollowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class FollowPutController {
    private final FollowCreator creator;

    public FollowPutController() {
        this.creator = new FollowCreator(
                new HibernateFollowRepository(),
                new JavaUuidGenerator()
        );
    }

    @PutMapping(value = "/follows/{id}")
    public ResponseEntity<String> index(
            @PathVariable String id,
            @RequestBody HashMap<String, Serializable> request
    ) {
        this.creator.create(
                new CreateFollow(
                        id,
                        (String) request.get("followed_id"),
                        (String) request.get("follower_id")
                )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}


