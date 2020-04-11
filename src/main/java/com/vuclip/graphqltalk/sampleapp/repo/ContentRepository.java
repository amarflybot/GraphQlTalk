package com.vuclip.graphqltalk.sampleapp.repo;

import com.vuclip.graphqltalk.sampleapp.model.cms.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContentRepository extends JpaRepository<Content, Long> {
}
