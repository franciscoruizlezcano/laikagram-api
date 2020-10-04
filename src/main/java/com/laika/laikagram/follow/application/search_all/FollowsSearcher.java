package com.laika.laikagram.follow.application.search_all;

import com.laika.laikagram.follow.application.FollowResponse;
import com.laika.laikagram.follow.application.FollowsResponse;
import com.laika.laikagram.follow.domain.FollowRepository;

import java.util.stream.Collectors;

public final class FollowsSearcher {
    private final FollowRepository repository;

    public FollowsSearcher(FollowRepository repository) {
        this.repository = repository;
    }

    public FollowsResponse search() {
        return new FollowsResponse(
                this.repository
                        .search()
                        .stream()
                        .map(FollowResponse::fromAggregate)
                        .collect(Collectors.toList())
        );
    }
}
