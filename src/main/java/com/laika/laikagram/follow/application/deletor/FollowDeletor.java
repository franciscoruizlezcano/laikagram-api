package com.laika.laikagram.follow.application.deletor;

import com.laika.laikagram.follow.domain.FollowId;
import com.laika.laikagram.follow.domain.FollowNotExist;
import com.laika.laikagram.follow.domain.FollowRepository;

public final class FollowDeletor {
    private final FollowRepository repository;

    public FollowDeletor(FollowRepository repository) {
        this.repository = repository;
    }

    public void delete(String id) {
        this.repository.delete(
                this.repository.search(new FollowId(id)).orElseThrow(() -> new FollowNotExist(new FollowId(id)))
        );
    }
}
