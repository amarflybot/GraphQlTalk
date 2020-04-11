package com.vuclip.graphqltalk.sampleapp.repo;

import com.vuclip.graphqltalk.sampleapp.model.subscription.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
