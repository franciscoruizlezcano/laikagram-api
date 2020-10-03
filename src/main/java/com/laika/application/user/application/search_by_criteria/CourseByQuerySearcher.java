package com.laika.application.user.application.search_by_criteria;

import com.laika.application.user.application.UserResponse;
import com.laika.application.user.domain.UserId;
import com.laika.application.user.domain.UserNotExist;
import com.laika.application.user.domain.UserRepository;

public final class CourseByQuerySearcher {
    private final UserRepository repository;

    public CourseByQuerySearcher(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse search(String id){
        UserId userId = new UserId(id);

        return UserResponse.fromAggregate(
                this.repository
                        .search(userId)
                        .orElseThrow(() -> new UserNotExist(userId))
        );
    }
}
