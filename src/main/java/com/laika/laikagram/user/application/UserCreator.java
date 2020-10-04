package com.laika.laikagram.user.application;

import com.laika.laikagram.shared.domain.UuidGenerator;
import com.laika.laikagram.user.domain.User;
import com.laika.laikagram.user.domain.UserId;
import com.laika.laikagram.user.domain.UserRepository;

public final class UserCreator {
    private final UserRepository repository;
    private final UuidGenerator  uuidGenerator;

    public UserCreator(UserRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void create(CreateUser user) {
        this.repository.save(new User(
                user.id() == null || user.id().equals("") ? new UserId(this.uuidGenerator.generate()) : new UserId(user.id()),
                user.username(),
                user.password(),
                user.urlPhoto()
        ));
    }
}
