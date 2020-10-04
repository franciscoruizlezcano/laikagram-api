package com.laika.laikagram.follow.domain;

import com.laika.laikagram.shared.domain.repository.Repository;

public interface FollowRepository extends Repository<Follow, FollowId> {
    void delete(Follow follow);

    int count(FollowId followed);
}
