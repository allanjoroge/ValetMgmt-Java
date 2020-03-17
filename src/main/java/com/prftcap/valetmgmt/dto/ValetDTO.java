package com.prftcap.valetmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValetDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String initials;
    private String carsIn;
    private String carsOut;
}
