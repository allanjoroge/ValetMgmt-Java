package com.prftcap.valetmgmt.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "valet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Valet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column (name = "initials")
    private String initials;

    @Column(name = "cars_in")
    private String carsIn;

    @Column(name = "cars_out")
    private String carsOut;
}
