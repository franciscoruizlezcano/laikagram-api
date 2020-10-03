package com.laika.laikagram.user.infrastructure.web;

import com.laika.laikagram.shared.domain.criteria.ParseFiltersUtil;
import com.laika.laikagram.user.application.UsersResponse;
import com.laika.laikagram.user.application.search_by_criteria.UsersByCriteriaSearcher;
import com.laika.laikagram.user.infrastructure.persistence.HibernateUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class UsersGetController {
    private final UsersByCriteriaSearcher searcher;

    public UsersGetController() {
        this.searcher = new UsersByCriteriaSearcher(new HibernateUserRepository());
    }

    @GetMapping("/users")
    public ResponseEntity<List<HashMap<String, String>>> index(
            @RequestBody HashMap<String, Serializable> params
    ) {
        List<HashMap<String, Serializable>> filters = params.get("filters") == null ? Collections.EMPTY_LIST : (List<HashMap<String, Serializable>>) params.get("filters");

        UsersResponse users = this.searcher.search(
                ParseFiltersUtil.parse(filters),
                Optional.ofNullable((String) params.get("order_by")),
                Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable((Integer) params.get("limit")),
                Optional.ofNullable((Integer) params.get("offset"))
        );

        return ResponseEntity.ok().body(
            users.users().stream().map(response -> new HashMap<String, String>(){{
                put("id", response.id());
                put("username", response.username());
            }}).collect(Collectors.toList())
        );
    }
}