package com.prftcap.valetmgmt.service.impl;

import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.entity.Vehicle;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.VehicleRepository;
import com.prftcap.valetmgmt.service.impl.VehicleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehiclePutServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepositoryMock;

    @Mock
    private Mapper mapperMock;

    @InjectMocks
    private VehicleServiceImpl vehicleServiceImplMock;

    @Test
    public void verifyUpdateVehicle(){

        //setup
        Vehicle vehicle = Vehicle.builder().id((long) 14).model("lancer").build();
        VehicleDTO vehicleDTO = VehicleDTO.builder().id((long) 14).model("lancer").build();

        when(vehicleRepositoryMock.save(vehicle)).thenReturn(vehicle);
        when(mapperMock.reverseTransform(vehicleDTO)).thenReturn(vehicle);

        // call method under test
        vehicleServiceImplMock.updateVehicle(vehicleDTO);

        // assertions
        verify(vehicleRepositoryMock).save(vehicle);
        verify(mapperMock).reverseTransform(vehicleDTO);
    }
}
