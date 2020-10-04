package com.laika.laikagram.post.application;

public final class CreatePost {
    private final String id;
    private final String urlMedia;
    private final String caption;
    private final String userId;

    public CreatePost(String id, String urlMedia, String caption, String userId) {
        this.id       = id;
        this.urlMedia = urlMedia;
        this.caption  = caption;
        this.userId   = userId;
    }

    public String id() {
        return id;
    }

    public String urlMedia() {
        return urlMedia;
    }

    public String caption() {
        return caption;
    }

    public String userId() {
        return userId;
    }
}
