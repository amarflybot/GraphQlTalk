package com.vuclip.graphqltalk.sampleapp.repo;

import com.vuclip.graphqltalk.sampleapp.model.um.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
}
