package com.prftcap.valetmgmt.service;

import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.dto.SearchRequest;
import org.springframework.data.domain.Page;

public interface VehicleService {

    Page<VehicleDTO> search(SearchRequest searchRequest);

    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    VehicleDTO findVehicleByID(Long id);

    void deleteVehicleById(Long id);
}
