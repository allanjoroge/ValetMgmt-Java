package com.prftcap.valetmgmt.service.impl;


import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.dto.VehicleSearchRequest;
import com.prftcap.valetmgmt.entity.Vehicle;
import com.prftcap.valetmgmt.exception.NotFoundException;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.VehicleRepository;
import com.prftcap.valetmgmt.service.VehicleService;
import com.querydsl.core.BooleanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    private Mapper mapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, Mapper mapper) {
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
    }

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {

        Vehicle vehicle = mapper.reverseTransform(vehicleDTO);
        vehicle = vehicleRepository.save(vehicle);
        return mapper.transform(vehicle);
    }

    @Override
    public VehicleDTO findVehicleByID(Long id) {

        Vehicle v = vehicleRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.transform(v);
    }

    @Override
    public void deleteVehicleById(Long id) {

        vehicleRepository.findById(id).orElseThrow(NotFoundException::new);
        vehicleRepository.deleteById(id);
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {

        Vehicle vehicle = mapper.reverseTransform(vehicleDTO);
        vehicle = vehicleRepository.save(vehicle);
        mapper.transform(vehicle);
    }

    @Override
    public Page<VehicleDTO> search(VehicleSearchRequest searchRequest) {

        log.debug("vehicle search request {}", searchRequest);

        Sort sortOrder = createSortOrder(searchRequest);

        PageRequest paging = PageRequest.of(searchRequest.getPageNo(), searchRequest.getPageSize(), sortOrder);

        BooleanBuilder predicate = VehicleRepository.createSearchPredicate(searchRequest);

        Page<Vehicle> pageVehicles = vehicleRepository.findAll(predicate, paging);

        List<VehicleDTO> vDTOs = new ArrayList<>();

        for (Vehicle v : pageVehicles) {
            vDTOs.add(mapper.transform(v));
        }

        return new PageImpl<>(vDTOs, paging, pageVehicles.getTotalElements());
    }

    protected Sort createSortOrder(VehicleSearchRequest request) {

        List<Sort.Order> orderList = new ArrayList<>();

        if ((request == null) || (request.getSortColumns() == null)) {
            //return the default sort
            orderList.add(createSortOrder(null, null));
        } else {

            for (int i = 0; i < request.getSortColumns().length; i++) {
                String col = request.getSortColumns()[i];
                String dir = request.getSortDirections()[i];
                orderList.add(createSortOrder(col, dir));
            }
        }

        log.debug("sort by list is {}", orderList.toString());

        return Sort.by(orderList);
    }

    private Sort.Order createSortOrder(String column, String direction) {

        log.debug("BEFORE column is {} and direction is {}", column, direction);

        if (StringUtils.isEmpty(column)) {
            column = "ticketNumber";
        }
        if (StringUtils.isEmpty(direction)) {
            direction = "ASC";
        }

        log.debug("AFTER column is {} and direction is {}", column, direction);

        if ("DESC".equalsIgnoreCase(direction)) {
            return Sort.Order.desc(column);
        }

        return Sort.Order.asc(column);
    }
}