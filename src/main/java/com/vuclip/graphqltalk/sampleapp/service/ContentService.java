package com.vuclip.graphqltalk.sampleapp.service;

import com.vuclip.graphqltalk.sampleapp.model.cms.Content;
import com.vuclip.graphqltalk.sampleapp.repo.ContentRepository;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class ContentService {

    private final ContentRepository repository;

    public ContentService(final ContentRepository repository) {
        this.repository = repository;
    }

    @GraphQLQuery
    public List<Content> findAllContents() {
        return repository.findAll();
    }

    @GraphQLQuery
    public Content findContentById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
