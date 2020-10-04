package com.laika.laikagram.shared.domain.repository;

import com.laika.laikagram.shared.domain.criteria.Criteria;

import java.util.List;

public interface MatchingRepository<T> {
    List<T> matching(Criteria criteria);
}
