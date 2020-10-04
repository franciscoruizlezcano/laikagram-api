package com.laika.laikagram.follow.application.search_by_criteria;

import com.laika.laikagram.follow.application.FollowResponse;
import com.laika.laikagram.follow.domain.FollowId;
import com.laika.laikagram.follow.domain.FollowNotExist;
import com.laika.laikagram.follow.domain.FollowRepository;

public final class FollowByQuerySearcher {
    private final FollowRepository repository;

    public FollowByQuerySearcher(FollowRepository repository) {
        this.repository = repository;
    }

    public FollowResponse search(String id) {
        FollowId followId = new FollowId(id);

        return FollowResponse.fromAggregate(
                this.repository
                        .search(followId)
                        .orElseThrow(() -> new FollowNotExist(followId))
        );
    }
}
