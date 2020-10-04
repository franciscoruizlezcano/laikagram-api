package com.laika.laikagram.follow.application;

import com.laika.laikagram.follow.domain.Follow;
import com.laika.laikagram.post.domain.Post;
import com.laika.laikagram.user.application.UserResponse;

public final class FollowResponse {
    private final String id;
    private final UserResponse followed;
    private final UserResponse follower;

    public FollowResponse(String id, UserResponse followed, UserResponse follower) {
        this.id       = id;
        this.followed = followed;
        this.follower = follower;
    }

    public static FollowResponse fromAggregate(Follow follow) {
        return new FollowResponse(
                follow.id().value(),
                UserResponse.fromAggregate(follow.followed()),
                UserResponse.fromAggregate(follow.follower())
        );
    }

    public String id() {
        return id;
    }

    public UserResponse followed() {
        return followed;
    }

    public UserResponse follower() {
        return follower;
    }
}
