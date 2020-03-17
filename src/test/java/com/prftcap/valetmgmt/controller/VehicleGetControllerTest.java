package com.prftcap.valetmgmt.controller;


import com.prftcap.valetmgmt.controllers.VehicleController;
import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.entity.Location;
import com.prftcap.valetmgmt.exception.NotFoundException;
import com.prftcap.valetmgmt.service.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleController.class)
public class VehicleGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleService vehicleGetService;

    @Test
    public void searchVehicles() throws Exception {

        List<VehicleDTO> vehicleDTOs = new ArrayList();
        Page<VehicleDTO> pDTOs = new PageImpl<>(vehicleDTOs);
        vehicleDTOs.add(VehicleDTO.builder().id((long) 12).location(Location.builder().id((long) 3).build()).model("lancer").build());

        when(vehicleGetService.search(any())).thenReturn(pDTOs);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicles?locationId=3");
        mockMvc.perform(requestBuilder).andExpect((status().isOk()));

        verify(vehicleGetService, times(1)).search(any());
        verifyNoMoreInteractions(vehicleGetService);
    }

    @Test
    public void findVehicleById() throws Exception {

        // Setup fake data, and tell our mocked service class how to behave
        VehicleDTO vDTO = VehicleDTO.builder().id((long) 14).model("lancer").build();
        when(vehicleGetService.findVehicleByID((long) 14)).thenReturn(vDTO);

        // Build a GET request for /vehicle/14 execute it using MockMvc
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicles/14");
        mockMvc.perform(requestBuilder).andExpect(status().isOk());

        verify(vehicleGetService, times(1)).findVehicleByID((long) 14);
        verifyNoMoreInteractions(vehicleGetService);
    }

    @Test
    public void findVehicleByIdNOT_FOUND() throws Exception {

        // Setup fake data, and tell our mocked service class how to behave
        when(vehicleGetService.findVehicleByID(14L)).thenThrow(NotFoundException.class);

        // Build a GET request for /vehicle/14 execute it using MockMvc
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicles/14");
        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());

        verify(vehicleGetService, times(1)).findVehicleByID((long) 14);
        verifyNoMoreInteractions(vehicleGetService);
    }

    @Test
    public void findVehicleByIdINTERNAL_SERVER_ERROR() throws Exception {

        // Setup fake data, and tell our mocked service class how to behave
        when(vehicleGetService.findVehicleByID(14L)).thenThrow(RuntimeException.class);

        // Build a GET request for /vehicle/14 execute it using MockMvc
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/vehicles/14");
        mockMvc.perform(requestBuilder).andExpect(status().isInternalServerError());

        verify(vehicleGetService, times(1)).findVehicleByID(14L);
        verifyNoMoreInteractions(vehicleGetService);
    }
}
