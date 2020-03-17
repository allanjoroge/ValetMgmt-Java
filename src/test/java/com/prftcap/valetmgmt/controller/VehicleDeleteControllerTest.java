package com.prftcap.valetmgmt.controller;


import com.prftcap.valetmgmt.controllers.VehicleController;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleController.class)
public class VehicleDeleteControllerTest {

    @Autowired
    private MockMvc mockMvcMock;

    @MockBean
    private VehicleService vehicleServiceMock;

    @Test
    public void verifyDeleteVehicle() throws Exception{

        //build request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/vehicles/14");
        MvcResult result = mockMvcMock.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //verify
        verify(vehicleServiceMock, times(1)).deleteVehicleById((long) 14);
        verifyNoMoreInteractions(vehicleServiceMock);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}


