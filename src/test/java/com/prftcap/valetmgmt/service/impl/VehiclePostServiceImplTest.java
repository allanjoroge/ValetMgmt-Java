package com.prftcap.valetmgmt.service.impl;


import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.entity.Vehicle;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehiclePostServiceImplTest {


    @Mock
    private VehicleRepository vehicleRepositoryMock;

    @Mock
    private Mapper mapper;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    public void saveVehicle() {

        //setup
        Vehicle vehicle = Vehicle.builder().ticketNumber(14).color("silver").build();
        VehicleDTO vehicleDTO = VehicleDTO.builder().ticketNumber(14).color("silver").build();
        when(vehicleRepositoryMock.save(vehicle)).thenReturn(vehicle);
        when(mapper.reverseTransform(vehicleDTO)).thenReturn(vehicle);

        //call method under test
        vehicleService.saveVehicle(vehicleDTO);

        verify(vehicleRepositoryMock).save(vehicle);
        verify(mapper).reverseTransform(vehicleDTO);

    }
}
