package com.vuclip.graphqltalk.sampleapp.model.um;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String streetName;
    private String streetAddress;
    private String streetAddressNumber;
    private String zipCode;
    private String city;
    private String country;

    @ManyToMany(mappedBy="addresses")
    private List<User> users = new ArrayList<>();
}
