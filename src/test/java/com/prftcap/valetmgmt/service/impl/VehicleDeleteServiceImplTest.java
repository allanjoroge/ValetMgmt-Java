package com.prftcap.valetmgmt.service.impl;


import com.prftcap.valetmgmt.entity.Vehicle;
import com.prftcap.valetmgmt.repository.VehicleRepository;
import com.prftcap.valetmgmt.service.impl.VehicleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleDeleteServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepositoryMock;

    @InjectMocks
    private VehicleServiceImpl vehicleServiceImplMock;

    @Test
    public void deleteVehicleById() {

        Vehicle vehicle = Vehicle.builder().id((long) 14).model("lancer").build();
        when(vehicleRepositoryMock.findById((long) 14)).thenReturn(Optional.ofNullable(vehicle));

        // call method under test
        vehicleServiceImplMock.deleteVehicleById((long) 14);

        verify(vehicleRepositoryMock).findById((long) 14);
        verify(vehicleRepositoryMock).deleteById((long) 14);
    }
}
