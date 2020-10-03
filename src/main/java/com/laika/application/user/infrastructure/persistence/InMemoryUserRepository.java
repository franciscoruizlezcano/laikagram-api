package com.laika.application.user.infrastructure.persistence;

import com.laika.application.shared.domain.criteria.Criteria;
import com.laika.application.shared.infrastructure.persistence.memory.InMemoryRepository;
import com.laika.application.user.domain.User;
import com.laika.application.user.domain.UserId;
import com.laika.application.user.domain.UserRepository;

import java.util.List;
import java.util.Optional;

public final class InMemoryUserRepository extends InMemoryRepository<User> implements UserRepository {
    public InMemoryUserRepository() {
        super();
    }

    @Override
    public List<User> search() {
        return super.all();
    }

    @Override
    public Optional<User> search(UserId id) {
        return super.matching(id);
    }

    @Override
    public List<User> matching(Criteria criteria) {
        return super.all();
    }

    @Override
    public void save(User user) {
        super.add(user.id(), user);
    }
}
