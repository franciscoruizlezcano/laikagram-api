package com.laika.application.user.domain;

import java.util.Objects;

public final class User {
    private final UserId id;
    private final String username;

    public User(UserId id, String username) {
        this.id       = id;
        this.username = username;
    }

    private User() {
        this.id       = null;
        this.username = null;
    }

    public UserId id() {
        return id;
    }

    public String username() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
