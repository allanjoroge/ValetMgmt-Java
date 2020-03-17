package com.prftcap.valetmgmt.controller;

import com.prftcap.valetmgmt.controllers.OwnerController;
import com.prftcap.valetmgmt.dto.OwnerDTO;
import com.prftcap.valetmgmt.dto.ValetDTO;
import com.prftcap.valetmgmt.entity.Owner;
import com.prftcap.valetmgmt.service.OwnerService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OwnerController.class)
public class OwnerGetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @Test
    public void findAll() throws Exception{

        // Setup fake data, and tell our mocked service class how to behave.
        List<OwnerDTO> oDTOs = new ArrayList<>();
        oDTOs.add(OwnerDTO.builder().firstName("Allan").lastName("Njau").build());
        when(ownerService.findAll(null)).thenReturn(oDTOs);

        // Build a request for /owners, execute it using MockMvc.
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners");
        mockMvc.perform(requestBuilder).andExpect((status().isOk()));

        // Verify our interactions with the mocked OwnerController
        verify(ownerService, times(1)).findAll(null);
        verifyNoMoreInteractions(ownerService);
    }

    @Test
    public void findByLastNameStartsWithIgnoreCase() throws Exception{

        // Setup fake data, and tell our mocked service class how to behave.
        List<OwnerDTO> oDTOs = new ArrayList<>();
        oDTOs.add(OwnerDTO.builder().firstName("Allan").lastName("Njau").build());
        when(ownerService.findAll("Njau")).thenReturn(oDTOs);

        // Build a request for /owners, execute it using MockMvc.
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/owners?lastName=Njau");
        mockMvc.perform(requestBuilder).andExpect((status().isOk()));

        // Verify our interactions with the mocked OwnerController
        verify(ownerService, times(1)).findAll("Njau");
        verifyNoMoreInteractions(ownerService);
    }
}
