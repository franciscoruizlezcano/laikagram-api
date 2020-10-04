package com.laika.laikagram.shared.domain.repository;

public interface Repository<T, ID> extends SaveRepository<T>, SearchRepository<T, ID>, MatchingRepository<T>{
}
