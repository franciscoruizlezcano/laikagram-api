package com.laika.application.user.application;

import com.laika.application.shared.domain.UuidGenerator;
import com.laika.application.user.domain.User;
import com.laika.application.user.domain.UserId;
import com.laika.application.user.domain.UserRepository;

public final class UserCreator {
    private final UserRepository repository;
    private final UuidGenerator uuidGenerator;

    public UserCreator(UserRepository repository, UuidGenerator uuidGenerator) {
        this.repository = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void create(CreateUser user){
        this.repository.save(new User(
                user.id() == null || user.id().equals("") ? new UserId(this.uuidGenerator.generate()) : new UserId(user.id()),
                user.username()
        ));
    }
}
