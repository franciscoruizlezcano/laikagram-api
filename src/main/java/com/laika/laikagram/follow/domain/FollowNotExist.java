package com.laika.laikagram.follow.domain;

import com.laika.laikagram.shared.domain.DomainError;

public final class FollowNotExist extends DomainError {
    public FollowNotExist(FollowId id) {
        super("follow_not_exist", String.format("The follow <%s> doesn't exist", id.value()));
    }
}
