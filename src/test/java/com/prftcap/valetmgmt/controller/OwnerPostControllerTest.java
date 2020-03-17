package com.prftcap.valetmgmt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prftcap.valetmgmt.controllers.OwnerController;
import com.prftcap.valetmgmt.dto.OwnerDTO;
import com.prftcap.valetmgmt.dto.ValetDTO;
import com.prftcap.valetmgmt.service.OwnerService;
import com.prftcap.valetmgmt.service.ValetService;
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
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OwnerController.class)
public class OwnerPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @Test
    public void verifyPostOwnerSuccess() throws Exception{

        OwnerDTO ownerDTO = OwnerDTO.builder().firstName("Allan").lastName("Njau").build();
        when(ownerService.saveOwner(ownerDTO)).thenReturn(ownerDTO);

        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writeValueAsString(ownerDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/owners").content(dtoAsString).contentType("application/json");
        mockMvc.perform(requestBuilder).andExpect((status().isCreated()));

        verify(ownerService, times(1)).saveOwner(ownerDTO);
        verifyNoMoreInteractions(ownerService);
    }
}
