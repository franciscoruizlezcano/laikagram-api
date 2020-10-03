package com.laika.application.user.domain;

import com.laika.application.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> search();

    Optional<User> search(UserId id);

    List<User> matching(Criteria criteria);

    void save(User user);
}
