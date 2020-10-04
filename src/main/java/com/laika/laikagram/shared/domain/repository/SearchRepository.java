package com.laika.laikagram.shared.domain.repository;

import java.util.List;
import java.util.Optional;

public interface SearchRepository<T, ID> {
    List<T> search();

    Optional<T> search(ID id);
}
