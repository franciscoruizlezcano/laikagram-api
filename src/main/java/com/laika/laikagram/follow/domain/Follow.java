package com.laika.laikagram.follow.domain;

import com.laika.laikagram.user.domain.User;

import java.util.Objects;

public final class Follow {
    private final FollowId id;
    private final User followed;
    private final User follower;

    public Follow(FollowId id, User followed, User follower) {
        this.id       = id;
        this.followed = followed;
        this.follower = follower;
    }

    public Follow() {
        this.id       = null;
        this.followed = null;
        this.follower = null;
    }

    public FollowId id() {
        return id;
    }

    public User followed() {
        return followed;
    }

    public User follower() {
        return follower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(id, follow.id) &&
                Objects.equals(followed, follow.followed) &&
                Objects.equals(follower, follow.follower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, followed, follower);
    }
}
