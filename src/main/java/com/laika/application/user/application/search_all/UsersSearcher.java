package com.laika.application.user.application.search_all;

import com.laika.application.user.application.UserResponse;
import com.laika.application.user.application.UsersResponse;
import com.laika.application.user.domain.UserRepository;

import java.util.stream.Collectors;

public final class UsersSearcher {
    private final UserRepository repository;

    public UsersSearcher(UserRepository repository) {
        this.repository = repository;
    }

    public UsersResponse search() {
        return new UsersResponse(
                this.repository
                        .search()
                        .stream()
                        .map(UserResponse::fromAggregate)
                        .collect(Collectors.toList())
        );
    }
}
