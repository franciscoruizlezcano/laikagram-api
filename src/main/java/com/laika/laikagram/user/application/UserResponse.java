package com.laika.laikagram.user.application;

import com.laika.laikagram.user.domain.User;

public final class UserResponse {
    private final String id;
    private final String username;
    private final String urlPhoto;

    public UserResponse(String id, String username, String urlPhoto) {
        this.id       = id;
        this.username = username;
        this.urlPhoto = urlPhoto;
    }

    public static UserResponse fromAggregate(User user) {
        return new UserResponse(user.id().value(), user.username(), user.urlPhoto());
    }

    public String id() {
        return id;
    }

    public String username() {
        return username;
    }

    public String urlPhoto() {
        return urlPhoto;
    }
}
