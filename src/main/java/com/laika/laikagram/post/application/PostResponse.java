package com.laika.laikagram.post.application;

import com.laika.laikagram.post.domain.Post;
import com.laika.laikagram.user.application.UserResponse;

public final class PostResponse {
    private final String       id;
    private final String       urlMedia;
    private final String       caption;
    private final UserResponse user;

    public PostResponse(String id, String urlMedia, String caption, UserResponse user) {
        this.id       = id;
        this.urlMedia = urlMedia;
        this.caption  = caption;
        this.user     = user;
    }

    public static PostResponse fromAggregate(Post post) {
        return new PostResponse(post.id().value(), post.urlMedia(), post.caption(), UserResponse.fromAggregate(post.user()));
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

    public UserResponse user() {
        return user;
    }
}
