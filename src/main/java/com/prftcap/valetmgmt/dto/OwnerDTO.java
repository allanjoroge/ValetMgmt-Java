package com.prftcap.valetmgmt.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
