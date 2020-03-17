package com.prftcap.valetmgmt.service;

import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.dto.VehicleSearchRequest;
import org.springframework.data.domain.Page;

public interface VehicleService {

    Page<VehicleDTO> search(VehicleSearchRequest searchRequest);

    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    VehicleDTO findVehicleByID(Long id);

    void deleteVehicleById(Long id);
}
