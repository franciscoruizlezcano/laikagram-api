package com.laika.laikagram.user.application;

public final class CreateUser {
    private final String id;
    private final String username;

    public CreateUser(
            String id,
            String username
    ) {
        this.id       = id;
        this.username = username;
    }

    public String id() {
        return id;
    }

    public String username() {
        return username;
    }
}
