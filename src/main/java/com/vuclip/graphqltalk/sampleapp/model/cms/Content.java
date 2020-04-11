package com.vuclip.graphqltalk.sampleapp.model.cms;

import com.vuclip.graphqltalk.sampleapp.model.um.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Content {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String genre;
    private String description;
    private String thumbnail;

    @ManyToMany
    @JoinTable(name = "content_artist",
            joinColumns = { @JoinColumn(name = "fk_content") },
            inverseJoinColumns = { @JoinColumn(name = "fk_artist") })
    private List<Artist> artists = new ArrayList<>();

    @ManyToMany(mappedBy="recentlyWatched")
    private List<User> users = new ArrayList<>();
}
