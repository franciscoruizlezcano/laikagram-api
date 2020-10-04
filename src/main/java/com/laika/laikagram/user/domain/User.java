package com.laika.laikagram.user.domain;

import java.util.Objects;

public final class User {
    private final UserId id;
    private final String username;
    private final String password;
    private final String urlPhoto;

    public User(UserId id, String username, String password, String urlPhoto) {
        this.id       = id;
        this.username = username;
        this.password = password;
        this.urlPhoto = urlPhoto;
    }

    public User() {
        this.id       = null;
        this.username = null;
        this.password = null;
        this.urlPhoto = null;
    }

    public UserId id() {
        return id;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String urlPhoto() {
        return urlPhoto;
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
