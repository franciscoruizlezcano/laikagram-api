package com.laika.laikagram.user.application;

import java.util.List;

public final class UsersResponse {
    private final List<UserResponse> users;

    public UsersResponse(List<UserResponse> users) {
        this.users = users;
    }

    public List<UserResponse> users() {
        return users;
    }
}
