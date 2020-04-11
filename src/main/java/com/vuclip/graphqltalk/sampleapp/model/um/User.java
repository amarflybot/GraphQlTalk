package com.vuclip.graphqltalk.sampleapp.model.um;

import com.vuclip.graphqltalk.sampleapp.model.cms.Content;
import com.vuclip.graphqltalk.sampleapp.model.subscription.Subscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String gender;

    @ManyToMany
    @JoinTable(name = "user_address",
            joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_address") })
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_content",
            joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_content") })
    private List<Content> recentlyWatched = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_subscription",
            joinColumns = { @JoinColumn(name = "fk_user") },
            inverseJoinColumns = { @JoinColumn(name = "fk_subscription") })
    private List<Subscription> subscription;
}
