package com.laika.laikagram.user.application;

public final class CreateUser {
    private final String id;
    private final String username;
    private final String password;
    private final String urlPhoto;

    public CreateUser(String id, String username, String password, String urlPhoto) {
        this.id       = id;
        this.username = username;
        this.password = password;
        this.urlPhoto = urlPhoto;
    }

    public String id() {
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

}
