package com.vuclip.graphqltalk.sampleapp.service;

import com.vuclip.graphqltalk.sampleapp.model.subscription.Subscription;
import com.vuclip.graphqltalk.sampleapp.repo.SubscriptionRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class SubscriptionService {

    private final SubscriptionRepository repository;

    public SubscriptionService(final SubscriptionRepository repository) {
        this.repository = repository;
    }

    @GraphQLQuery
    public List<Subscription> findAllSubscription() {
        return repository.findAll();
    }

    @GraphQLQuery
    public Subscription findAllSubscriptionById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
