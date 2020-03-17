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
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;



@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleController.class)
public class VehiclePostControllerTest {

    @Autowired
    private MockMvc mockMvcMock;

    @MockBean
    private VehicleService vehicleServiceMock;

    @Test
    public void verifyPostVehicleSuccess() throws Exception{

        // create a VehicleDTO
        VehicleDTO vehicleDTO = VehicleDTO.builder().id(14l).model("lancer").build();

        // teach the parrot how to talk
        when(vehicleServiceMock.saveVehicle(vehicleDTO)).thenReturn(vehicleDTO);

        // turn DTO into a string
        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writeValueAsString(vehicleDTO);

        // build a post request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/vehicles").content(dtoAsString).contentType("application/json");
        MvcResult result = mockMvcMock.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // verify interaction with the mocked vehiclePostServiceMock
        verify(vehicleServiceMock, times(1)).saveVehicle(vehicleDTO);
        verifyNoMoreInteractions(vehicleServiceMock);
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }
}
