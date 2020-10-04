package com.laika.laikagram.follow.application.counter;

import com.laika.laikagram.follow.domain.FollowId;
import com.laika.laikagram.follow.domain.FollowRepository;

public final class FollowCounter {
    private final FollowRepository repository;

    public FollowCounter(FollowRepository repository) {
        this.repository = repository;
    }

    public int count(String id) {
        return this.repository.count(new FollowId(id));
    }
}
