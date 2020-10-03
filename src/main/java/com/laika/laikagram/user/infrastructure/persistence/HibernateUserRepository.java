package com.laika.laikagram.user.infrastructure.persistence;

import com.laika.laikagram.shared.domain.criteria.Criteria;
import com.laika.laikagram.shared.infrastructure.persistence.hibernate.HibernateConfigurationFactory;
import com.laika.laikagram.shared.infrastructure.persistence.hibernate.HibernateRepository;
import com.laika.laikagram.user.domain.User;
import com.laika.laikagram.user.domain.UserId;
import com.laika.laikagram.user.domain.UserRepository;

import java.util.List;
import java.util.Optional;

public final class HibernateUserRepository extends HibernateRepository<User> implements UserRepository {
    public HibernateUserRepository() {
        super(
                new HibernateConfigurationFactory()
                        .create()
                        .buildSessionFactory(),
                User.class
        );
    }

    @Override
    public List<User> search() {
        return super.all();
    }

    @Override
    public Optional<User> search(UserId id) {
        return super.byId(id);
    }

    @Override
    public List<User> matching(Criteria criteria) {
        return this.byCriteria(criteria);
    }

    @Override
    public void save(User user) {
        super.persist(user);
    }
}
