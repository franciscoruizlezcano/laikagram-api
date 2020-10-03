package com.laika.application.user.domain;

import com.laika.application.shared.domain.DomainError;

public final class UserNotExist extends DomainError {
    public UserNotExist(UserId id) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", id.value()));
    }

    public UserNotExist(String username) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", username));
    }
}
