package com.laika.laikagram.follow.application;

public final class CreateFollow {
    private final String id;
    private final String followed;
    private final String follower;

    public CreateFollow(String id, String followed, String follower) {
        this.id       = id;
        this.followed = followed;
        this.follower = follower;
    }

    public String id() {
        return id;
    }

    public String followed() {
        return followed;
    }

    public String follower() {
        return follower;
    }
}
