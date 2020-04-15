package com.prftcap.valetmgmt.repository;


import com.prftcap.valetmgmt.dto.SearchRequest;
import com.prftcap.valetmgmt.entity.QVehicle;
import com.prftcap.valetmgmt.entity.Vehicle;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long>, QuerydslPredicateExecutor<Vehicle> {

    static BooleanBuilder createSearchPredicate(SearchRequest request) {

        BooleanBuilder predicate = new BooleanBuilder();

        if (request.getLocation() != null) {
            predicate.and(QVehicle.vehicle.location.id.in(request.getLocation()));
        }
        if (request.getTicketNumber() != null) {
            predicate.and(QVehicle.vehicle.ticketNumber.in(request.getTicketNumber()));
        }
        if (request.getArrivalDate() != null) {
            predicate.and(QVehicle.vehicle.arrivalDate.after((Date) request.getArrivalDate()));
        }
        if (request.getOwner() != null) {
            predicate.and(QVehicle.vehicle.owner.id.in(request.getOwner()));
        }
        if (request.getValet() != null) {
            predicate.and(QVehicle.vehicle.valet.id.in(request.getValet()));
        }
        return predicate;
    }
}
