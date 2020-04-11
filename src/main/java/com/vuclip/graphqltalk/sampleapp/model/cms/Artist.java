package com.vuclip.graphqltalk.sampleapp.model.cms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Date dateOfBirth;
    private String gender;
    private String awardWon;

    @ManyToMany(mappedBy="artists")
    private List<Content> contents = new ArrayList<>();
}
