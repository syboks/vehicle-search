package com.syboks.vehiclesearch.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="manufacturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="manufacturer_name")
    private String manufacturerName;
    @Column(name="country_of_origin")
    private String countryOfOrigin;

}
