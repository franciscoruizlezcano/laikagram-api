package com.laika.laikagram.follow.application.creator;

import com.laika.laikagram.follow.application.CreateFollow;
import com.laika.laikagram.follow.domain.Follow;
import com.laika.laikagram.follow.domain.FollowId;
import com.laika.laikagram.follow.domain.FollowRepository;
import com.laika.laikagram.shared.domain.UuidGenerator;
import com.laika.laikagram.user.domain.User;
import com.laika.laikagram.user.domain.UserId;

public final class FollowCreator {
    private final FollowRepository repository;
    private final UuidGenerator  uuidGenerator;

    public FollowCreator(FollowRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void create(CreateFollow post) {
        this.repository.save(new Follow(
                post.id() == null || post.id().equals("") ? new FollowId(this.uuidGenerator.generate()) : new FollowId(post.id()),
                new User(new UserId(post.followed()), "", "", ""),
                new User(new UserId(post.follower()), "", "", "")
        ));
    }
}
