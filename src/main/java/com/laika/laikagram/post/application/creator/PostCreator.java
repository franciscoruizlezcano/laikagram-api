package com.laika.laikagram.post.application.creator;

import com.laika.laikagram.post.application.CreatePost;
import com.laika.laikagram.shared.domain.UuidGenerator;
import com.laika.laikagram.post.domain.Post;
import com.laika.laikagram.post.domain.PostId;
import com.laika.laikagram.post.domain.PostRepository;
import com.laika.laikagram.user.domain.User;
import com.laika.laikagram.user.domain.UserId;

public final class PostCreator {
    private final PostRepository repository;
    private final UuidGenerator  uuidGenerator;

    public PostCreator(PostRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void create(CreatePost post) {
        this.repository.save(new Post(
                post.id() == null || post.id().equals("") ? new PostId(this.uuidGenerator.generate()) : new PostId(post.id()),
                post.urlMedia(),
                post.caption(),
                new User(new UserId(post.userId()), "", "", "")
        ));
    }
}
