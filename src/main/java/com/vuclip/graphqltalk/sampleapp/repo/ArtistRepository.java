package com.vuclip.graphqltalk.sampleapp.repo;

import com.vuclip.graphqltalk.sampleapp.model.cms.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
