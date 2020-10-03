package com.laika.application.user.application.search_by_criteria;

import com.laika.application.shared.domain.criteria.Criteria;
import com.laika.application.shared.domain.criteria.Filters;
import com.laika.application.shared.domain.criteria.Order;
import com.laika.application.user.application.UserResponse;
import com.laika.application.user.application.UsersResponse;
import com.laika.application.user.domain.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class UsersByCriteriaSearcher {
    private final UserRepository repository;

    public UsersByCriteriaSearcher(UserRepository repository) {
        this.repository = repository;
    }

    public UsersResponse search(
            List<HashMap<String, String>> filters,
            Optional<String> orderBy,
            Optional<String> orderType,
            Optional<Integer> limit,
            Optional<Integer> offset
    ) {

        Criteria criteria = new Criteria(Filters.fromValues(filters), Order.fromValues(orderBy, orderType), limit, offset);

        return new UsersResponse(
                repository
                        .matching(criteria)
                        .stream()
                        .map(UserResponse::fromAggregate)
                        .collect(Collectors.toList())
        );
    }
}
