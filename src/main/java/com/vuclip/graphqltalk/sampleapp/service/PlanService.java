package com.vuclip.graphqltalk.sampleapp.service;

import com.vuclip.graphqltalk.sampleapp.model.subscription.Plan;
import com.vuclip.graphqltalk.sampleapp.repo.PlanRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class PlanService {

    private final PlanRepository repository;

    public PlanService(final PlanRepository repository) {
        this.repository = repository;
    }

    @GraphQLQuery
    public List<Plan> findAllPlans() {
        return repository.findAll();
    }

    @GraphQLQuery
    public Plan findPlanById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
