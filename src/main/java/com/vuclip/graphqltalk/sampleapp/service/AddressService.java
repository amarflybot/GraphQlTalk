package com.vuclip.graphqltalk.sampleapp.service;

import com.vuclip.graphqltalk.sampleapp.model.um.Address;
import com.vuclip.graphqltalk.sampleapp.repo.AddressRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class AddressService {

    private final AddressRepository repository;

    public AddressService(final AddressRepository repository) {
        this.repository = repository;
    }

    @GraphQLQuery
    public List<Address> findAllAddresses() {
        return repository.findAll();
    }

    @GraphQLQuery
    public Address findAddressById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
