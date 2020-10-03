package com.laika.application.shared.infrastructure.persistence.memory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class InMemoryRepository<T> {
    private final HashMap<Serializable, T> entities;

    public InMemoryRepository() {
        this.entities = new HashMap<>();
    }

    protected void add(Serializable key, T t) {
        this.entities.put(key, t);
    }

    protected List<T> all() {
        return (List<T>) entities.values();
    }

    protected Optional<T> matching(Serializable key) {
        return entities.containsKey(key)
                ? Optional.ofNullable(entities.get(key))
                : Optional.empty();
    }
}