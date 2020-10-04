package com.laika.laikagram.post.application.search_all;

import com.laika.laikagram.post.application.PostResponse;
import com.laika.laikagram.post.application.PostsResponse;
import com.laika.laikagram.post.domain.PostRepository;

import java.util.stream.Collectors;

public final class PostsSearcher {
    private final PostRepository repository;

    public PostsSearcher(PostRepository repository) {
        this.repository = repository;
    }

    public PostsResponse search() {
        return new PostsResponse(
                this.repository
                        .search()
                        .stream()
                        .map(PostResponse::fromAggregate)
                        .collect(Collectors.toList())
        );
    }
}
