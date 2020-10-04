package com.laika.laikagram.follow.infrastructure.persistence;

import com.laika.laikagram.follow.domain.Follow;
import com.laika.laikagram.follow.domain.FollowId;
import com.laika.laikagram.follow.domain.FollowRepository;
import com.laika.laikagram.shared.domain.criteria.Criteria;
import com.laika.laikagram.shared.domain.criteria.Filters;
import com.laika.laikagram.shared.domain.criteria.Order;
import com.laika.laikagram.shared.infrastructure.persistence.hibernate.HibernateConfigurationFactory;
import com.laika.laikagram.shared.infrastructure.persistence.hibernate.HibernateRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public final class HibernateFollowRepository extends HibernateRepository<Follow> implements FollowRepository {
    public HibernateFollowRepository() {
        super(
                new HibernateConfigurationFactory()
                        .create()
                        .buildSessionFactory(),
                Follow.class
        );
    }

    @Override
    public List<Follow> search() {
        return super.all();
    }

    @Override
    public Optional<Follow> search(FollowId id) {
        return super.byId(id);
    }

    @Override
    public List<Follow> matching(Criteria criteria) {
        return this.byCriteria(criteria);
    }

    @Override
    public int count(FollowId followed) {
        Filters filters = Filters.fromValues(new ArrayList<>(){{
            add(new HashMap<>(){{
                put("field", "followed");
                put("operator", "=");
                put("value", followed.value());
            }});
        }});

        return this.matching(
                new Criteria(filters, Order.none(), Optional.empty(), Optional.empty())
        ).size();
    }

    @Override
    public void save(Follow Follow) {
        super.persist(Follow);
    }

    @Override
    public void delete(Follow follow) {
        this.delete(follow);
    }
}
