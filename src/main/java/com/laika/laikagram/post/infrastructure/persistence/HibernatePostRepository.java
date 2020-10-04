package com.laika.laikagram.post.infrastructure.persistence;

import com.laika.laikagram.post.domain.Post;
import com.laika.laikagram.post.domain.PostId;
import com.laika.laikagram.post.domain.PostRepository;
import com.laika.laikagram.shared.domain.criteria.Criteria;
import com.laika.laikagram.shared.infrastructure.persistence.hibernate.HibernateConfigurationFactory;
import com.laika.laikagram.shared.infrastructure.persistence.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

public final class HibernatePostRepository extends HibernateRepository<Post> implements PostRepository {
    public HibernatePostRepository() {
        super(
                new HibernateConfigurationFactory()
                        .create()
                        .buildSessionFactory(),
                Post.class
        );
    }

    @Override
    public List<Post> search() {
        return super.all();
    }

    @Override
    public Optional<Post> search(PostId id) {
        return super.byId(id);
    }

    @Override
    public List<Post> matching(Criteria criteria) {
        return this.byCriteria(criteria);
    }

    @Override
    public void save(Post Post) {
        super.persist(Post);
    }
}
