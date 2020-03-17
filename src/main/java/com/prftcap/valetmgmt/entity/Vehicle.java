package com.prftcap.valetmgmt.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nullable
    @ManyToOne
    private Owner owner;

    @Nullable
    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Nullable
    @Column(name = "ticket_number")
    private Integer ticketNumber;

    @Nullable
    @Column(name = "make")
    private String make;

    @Nullable
    @Column(name = "model")
    private String model;

    @Nullable
    @Column(name = "color")
    private String color;

    @Nullable
    @Column(name = "license_plate")
    private String licensePlate;

    @Nullable
    @ManyToOne
    private Valet valet;

    @Nullable
    @Column(name = "parked_location")
    private Integer parkedLocation;

    @Nullable
    @ManyToOne
    private Location location;

    @Nullable
    @Column(name = "departure_date")
    private Date departureDate;
}
