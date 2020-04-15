package com.prftcap.valetmgmt.controllers;

import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.dto.SearchRequest;
import com.prftcap.valetmgmt.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<VehicleDTO> search(
            SearchRequest searchRequest) {

        return vehicleService.search(searchRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehicleDTO findVehicleById(@PathVariable Long id) {

        return vehicleService.findVehicleByID(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleDTO createVehicle(@RequestBody VehicleDTO vehicleDTO) {

        return vehicleService.saveVehicle(vehicleDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateVehicleById(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.updateVehicle(vehicleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVehicleById(@PathVariable Long id) {

        vehicleService.deleteVehicleById(id);
    }
}
