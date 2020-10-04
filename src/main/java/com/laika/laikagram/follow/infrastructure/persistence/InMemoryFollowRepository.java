package com.laika.laikagram.follow.infrastructure.persistence;

import com.laika.laikagram.shared.domain.criteria.Criteria;
import com.laika.laikagram.shared.infrastructure.persistence.memory.InMemoryRepository;
import com.laika.laikagram.follow.domain.Follow;
import com.laika.laikagram.follow.domain.FollowId;
import com.laika.laikagram.follow.domain.FollowRepository;

import java.util.List;
import java.util.Optional;

public final class InMemoryFollowRepository extends InMemoryRepository<Follow> implements FollowRepository {
    public InMemoryFollowRepository() {
        super();
    }

    @Override
    public List<Follow> search() {
        return super.all();
    }

    @Override
    public Optional<Follow> search(FollowId id) {
        return super.matching(id);
    }

    @Override
    public List<Follow> matching(Criteria criteria) {
        return super.all();
    }

    @Override
    public void save(Follow Follow) {
        super.add(Follow.id(), Follow);
    }

    @Override
    public void delete(Follow follow) {
        super.remove(follow.id().value());
    }

    @Override
    public int count(FollowId followed) {
        return this.count();
    }
}
