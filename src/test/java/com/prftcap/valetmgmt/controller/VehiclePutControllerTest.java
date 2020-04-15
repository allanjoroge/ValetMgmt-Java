package com.prftcap.valetmgmt.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.prftcap.valetmgmt.controllers.VehicleController;
import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.service.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleController.class)
public class VehiclePutControllerTest {

    @Autowired
    private MockMvc mockMvcMock;

    @MockBean
    private VehicleService vehicleServiceMock;

    @Test
    public void verifyPutVehicleSuccess() throws Exception {

        VehicleDTO vehicleDTO = VehicleDTO.builder().id(14L).model("lancer").build();
//        when(vehicleServiceMock.updateVehicle(vehicleDTO)).thenReturn(vehicleDTO);

        // transform dto to string
        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writeValueAsString(vehicleDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/vehicles").content(dtoAsString).contentType("application/json");
        mockMvcMock.perform(requestBuilder).andExpect((status().isNoContent()));

        verify(vehicleServiceMock, times(1)).updateVehicle(vehicleDTO);
        verifyNoMoreInteractions(vehicleServiceMock);
    }
}
