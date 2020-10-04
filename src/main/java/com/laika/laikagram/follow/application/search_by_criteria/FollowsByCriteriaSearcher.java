package com.laika.laikagram.follow.application.search_by_criteria;

import com.laika.laikagram.follow.application.FollowResponse;
import com.laika.laikagram.follow.application.FollowsResponse;
import com.laika.laikagram.follow.domain.FollowRepository;
import com.laika.laikagram.shared.domain.criteria.Criteria;
import com.laika.laikagram.shared.domain.criteria.Filters;
import com.laika.laikagram.shared.domain.criteria.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class FollowsByCriteriaSearcher {
    private final FollowRepository repository;

    public FollowsByCriteriaSearcher(FollowRepository repository) {
        this.repository = repository;
    }

    public FollowsResponse search(
            List<HashMap<String, String>> filters,
            Optional<String> orderBy,
            Optional<String> orderType,
            Optional<Integer> limit,
            Optional<Integer> offset
    ) {

        Criteria criteria = new Criteria(Filters.fromValues(filters), Order.fromValues(orderBy, orderType), limit, offset);

        return new FollowsResponse(
                repository
                        .matching(criteria)
                        .stream()
                        .map(FollowResponse::fromAggregate)
                        .collect(Collectors.toList())
        );
    }
}
