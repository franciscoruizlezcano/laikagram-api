package com.laika.laikagram.follow.application;

import java.util.List;

public final class FollowsResponse {
    private final List<FollowResponse> follows;

    public FollowsResponse(List<FollowResponse> follows) {
        this.follows = follows;
    }

    public List<FollowResponse> follows() {
        return follows;
    }
}
