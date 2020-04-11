package com.vuclip.graphqltalk.sampleapp.model.subscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Plan {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double planPrice;
    private String type;

    @OneToOne(mappedBy="plan")
    private Subscription subscription;
}
