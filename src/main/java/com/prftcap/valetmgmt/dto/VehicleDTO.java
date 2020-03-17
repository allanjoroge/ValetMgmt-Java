package com.prftcap.valetmgmt.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.prftcap.valetmgmt.entity.Location;
import com.prftcap.valetmgmt.entity.Owner;
import com.prftcap.valetmgmt.entity.Valet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

    private Long id;
    private Owner owner;
    private Date arrivalDate;
    private Integer ticketNumber;
    private String make;
    private String model;
    private String color;
    private String licensePlate;
    private Valet valet;
    private Integer parkedLocation;
    private Location location;
    private Date departureDate;
}
