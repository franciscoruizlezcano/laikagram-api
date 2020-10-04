package com.laika.laikagram.post.application.search_by_criteria;

import com.laika.laikagram.post.application.PostResponse;
import com.laika.laikagram.post.domain.PostId;
import com.laika.laikagram.post.domain.PostNotExist;
import com.laika.laikagram.post.domain.PostRepository;

public final class PostByQuerySearcher {
    private final PostRepository repository;

    public PostByQuerySearcher(PostRepository repository) {
        this.repository = repository;
    }

    public PostResponse search(String id) {
        PostId postId = new PostId(id);

        return PostResponse.fromAggregate(
                this.repository
                        .search(postId)
                        .orElseThrow(() -> new PostNotExist(postId))
        );
    }
}
