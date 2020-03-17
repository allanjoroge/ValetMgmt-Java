package com.prftcap.valetmgmt.controller;

import com.prftcap.valetmgmt.controllers.ValetController;
import com.prftcap.valetmgmt.dto.ValetDTO;
import com.prftcap.valetmgmt.service.ValetService;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ValetController.class)
public class ValetGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValetService valetService;

    @Test
    public void findAllValets() throws Exception {

        // Setup fake data, and tell our mocked service class how to behave.
        List<ValetDTO> vDTOs = new ArrayList<>();
        vDTOs.add(ValetDTO.builder().initials("AN").firstName("Allan").build());
        when(valetService.findAllValets()).thenReturn(vDTOs);

        // Build a request for /valets, execute it using MockMvc.
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/valets");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        // Verify our interactions with the mocked ValetController
        verify(valetService, times(1)).findAllValets();
        verifyNoMoreInteractions(valetService);
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
}
