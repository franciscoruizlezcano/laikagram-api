package com.laika.laikagram.post.application.search_by_criteria;

import com.laika.laikagram.post.application.PostResponse;
import com.laika.laikagram.post.application.PostsResponse;
import com.laika.laikagram.shared.domain.criteria.Criteria;
import com.laika.laikagram.shared.domain.criteria.Filters;
import com.laika.laikagram.shared.domain.criteria.Order;
import com.laika.laikagram.post.domain.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class PostsByCriteriaSearcher {
    private final PostRepository repository;

    public PostsByCriteriaSearcher(PostRepository repository) {
        this.repository = repository;
    }

    public PostsResponse search(
            List<HashMap<String, String>> filters,
            Optional<String> orderBy,
            Optional<String> orderType,
            Optional<Integer> limit,
            Optional<Integer> offset
    ) {

        Criteria criteria = new Criteria(Filters.fromValues(filters), Order.fromValues(orderBy, orderType), limit, offset);

        return new PostsResponse(
                repository
                        .matching(criteria)
                        .stream()
                        .map(PostResponse::fromAggregate)
                        .collect(Collectors.toList())
        );
    }
}
