package com.vuclip.graphqltalk.sampleapp.service;

import com.vuclip.graphqltalk.sampleapp.model.cms.Artist;
import com.vuclip.graphqltalk.sampleapp.repo.ArtistRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class ArtistService {
    private final ArtistRepository repository;

    public ArtistService(final ArtistRepository repository) {
        this.repository = repository;
    }

    @GraphQLQuery
    public List<Artist> findAllArtists() {
        return repository.findAll();
    }

    @GraphQLQuery
    public Artist findArtistById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
