package com.laika.laikagram.user.infrastructure.web;

import com.laika.laikagram.shared.infrastructure.JavaUuidGenerator;
import com.laika.laikagram.user.application.CreateUser;
import com.laika.laikagram.user.application.creator.UserCreator;
import com.laika.laikagram.user.infrastructure.persistence.HibernateUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class UserPutController {
    private final UserCreator creator;

    public UserPutController() {
        this.creator = new UserCreator(
                new HibernateUserRepository(),
                new JavaUuidGenerator()
        );
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<String> index(
            @PathVariable String id,
            @RequestBody HashMap<String, Serializable> request
    ) {
        this.creator.create(
                new CreateUser(
                        id,
                        request.get("username").toString(),
                        request.get("password").toString(),
                        request.get("url_photo").toString()
                )
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}


