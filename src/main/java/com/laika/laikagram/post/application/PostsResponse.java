package com.laika.laikagram.post.application;

import java.util.List;

public final class PostsResponse {
    private final List<PostResponse> posts;

    public PostsResponse(List<PostResponse> posts) {
        this.posts = posts;
    }

    public List<PostResponse> posts() {
        return posts;
    }
}
