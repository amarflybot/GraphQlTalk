package com.vuclip.graphqltalk.sampleapp.repo;

import com.vuclip.graphqltalk.sampleapp.model.um.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Long> {
}
