package com.laika.application.user.application;

import com.laika.application.user.domain.User;

public final class UserResponse {
    private final String id;
    private final String username;

    public UserResponse(String id, String username) {
        this.id       = id;
        this.username = username;
    }

    public static UserResponse fromAggregate(User user) {
        return new UserResponse(user.id().value(), user.username());
    }

    public String id() {
        return id;
    }

    public String username() {
        return username;
    }
}
