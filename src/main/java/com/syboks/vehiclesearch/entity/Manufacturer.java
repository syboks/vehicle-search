package com.syboks.vehiclesearch.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="manufacturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Manufacturer name is required")
    @Column(name="manufacturer_name")
    private String manufacturerName;
    @Column(name="country_of_origin")
    private String countryOfOrigin;

}
