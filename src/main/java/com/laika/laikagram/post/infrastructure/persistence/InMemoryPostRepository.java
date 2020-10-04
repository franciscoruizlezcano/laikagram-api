package com.laika.laikagram.post.infrastructure.persistence;

import com.laika.laikagram.shared.domain.criteria.Criteria;
import com.laika.laikagram.shared.infrastructure.persistence.memory.InMemoryRepository;
import com.laika.laikagram.post.domain.Post;
import com.laika.laikagram.post.domain.PostId;
import com.laika.laikagram.post.domain.PostRepository;

import java.util.List;
import java.util.Optional;

public final class InMemoryPostRepository extends InMemoryRepository<Post> implements PostRepository {
    public InMemoryPostRepository() {
        super();
    }

    @Override
    public List<Post> search() {
        return super.all();
    }

    @Override
    public Optional<Post> search(PostId id) {
        return super.matching(id);
    }

    @Override
    public List<Post> matching(Criteria criteria) {
        return super.all();
    }

    @Override
    public void save(Post Post) {
        super.add(Post.id(), Post);
    }
}
