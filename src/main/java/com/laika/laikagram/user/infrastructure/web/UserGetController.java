package com.laika.laikagram.user.infrastructure.web;

import com.laika.laikagram.user.application.UserResponse;
import com.laika.laikagram.user.application.search_by_criteria.CourseByQuerySearcher;
import com.laika.laikagram.user.infrastructure.persistence.HibernateUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class UserGetController {
    private final CourseByQuerySearcher searcher;

    public UserGetController() {
        this.searcher = new CourseByQuerySearcher(new HibernateUserRepository());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) {

        UserResponse user = this.searcher.search(id);

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", user.id());
            put("username", user.username());
        }});
    }
}
