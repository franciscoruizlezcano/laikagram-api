package com.laika.laikagram.post.domain;

import com.laika.laikagram.shared.domain.DomainError;

public final class PostNotExist extends DomainError {
    public PostNotExist(PostId id) {
        super("post_not_exist", String.format("The post <%s> doesn't exist", id.value()));
    }
}
