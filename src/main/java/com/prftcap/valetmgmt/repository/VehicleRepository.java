package com.prftcap.valetmgmt.repository;


import com.prftcap.valetmgmt.dto.VehicleSearchRequest;
import com.prftcap.valetmgmt.entity.QVehicle;
import com.prftcap.valetmgmt.entity.Vehicle;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long>, QuerydslPredicateExecutor<Vehicle> {

    static BooleanBuilder createSearchPredicate(VehicleSearchRequest searchRequest) {

        BooleanBuilder predicate = new BooleanBuilder();

        if (searchRequest.getLocation() != null) {
            predicate.and(QVehicle.vehicle.location.id.in(searchRequest.getLocation()));
        }
        if (searchRequest.getTicketNumber() != null) {
            predicate.and(QVehicle.vehicle.ticketNumber.in(searchRequest.getTicketNumber()));
        }
//        if (searchRequest.getArrivalDate() != null) {
//            predicate.and(QVehicle.vehicle.arrivalDate.(searchRequest.getArrivalDate()));
//        }
//        if (searchRequest.getOwnerId() != null) {
//            predicate.and(QVehicle.vehicle.owner.id.in(searchRequest.getOwnerId()));
//        }
//        if (searchRequest.getValetId() != null) {
//            predicate.and(QVehicle.vehicle.valet.id.in(searchRequest.getValetId()));
//        }
        return predicate;
    }
}
