package com.prftcap.valetmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleSearchRequest {

    //advanced search/filtering
    private Long location;
    private Date arrivalDate;
    //    private Long valet;
//    private Long owner;
    private Integer ticketNumber;
    //sorting
    private String[] sortColumns;
    private String[] sortDirections;
    //pagination
    private Integer pageNo = 0;
    private Integer pageSize = 10;
}