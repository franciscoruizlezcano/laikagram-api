package com.laika.laikagram.user.application.search_by_criteria;

import com.laika.laikagram.user.application.UserResponse;
import com.laika.laikagram.user.domain.UserId;
import com.laika.laikagram.user.domain.UserNotExist;
import com.laika.laikagram.user.domain.UserRepository;

public final class UserByQuerySearcher {
    private final UserRepository repository;

    public UserByQuerySearcher(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse search(String id) {
        UserId userId = new UserId(id);

        return UserResponse.fromAggregate(
                this.repository
                        .search(userId)
                        .orElseThrow(() -> new UserNotExist(userId))
        );
    }
}
