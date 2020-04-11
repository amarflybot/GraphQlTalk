package com.vuclip.graphqltalk.sampleapp.service;

import com.vuclip.graphqltalk.sampleapp.model.um.User;
import com.vuclip.graphqltalk.sampleapp.repo.UserRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class UserService {

    private final UserRepository repository;

    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    @GraphQLQuery
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @GraphQLQuery
    public User findUserById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
