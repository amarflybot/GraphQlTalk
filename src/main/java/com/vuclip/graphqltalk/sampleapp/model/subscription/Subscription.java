package com.vuclip.graphqltalk.sampleapp.model.subscription;

import com.vuclip.graphqltalk.sampleapp.model.um.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Subscription {

    @Id
    @GeneratedValue
    private long id;

    private Date startDate;
    private Date endDate;

    @OneToOne
    @JoinTable(name = "subscription_plan",
            joinColumns = { @JoinColumn(name = "fk_subscription") },
            inverseJoinColumns = { @JoinColumn(name = "fk_plan") })
    private Plan plan;

    @ManyToMany(mappedBy = "subscription")
    private List<User> users;
}
