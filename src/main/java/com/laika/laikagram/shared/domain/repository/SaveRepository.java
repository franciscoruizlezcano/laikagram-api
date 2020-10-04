package com.laika.laikagram.shared.domain.repository;

public interface SaveRepository<T> {
    void save(T t);
}
