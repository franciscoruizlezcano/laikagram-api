package com.laika.laikagram.post.infrastructure.web;

import com.laika.laikagram.shared.infrastructure.JavaUuidGenerator;
import com.laika.laikagram.post.application.CreatePost;
import com.laika.laikagram.post.application.PostCreator;
import com.laika.laikagram.post.infrastructure.persistence.HibernatePostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class PostPutController {
    private final PostCreator creator;

    public PostPutController() {
        this.creator = new PostCreator(
                new HibernatePostRepository(),
                new JavaUuidGenerator()
        );
    }

    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<String> index(
            @PathVariable String id,
            @RequestBody HashMap<String, Serializable> request
    ) {
        this.creator.create(
                new CreatePost(
                        id,
                        (String) request.get("url_media"),
                        (String) request.get("caption"),
                        (String) request.get("user_id")
                )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}


