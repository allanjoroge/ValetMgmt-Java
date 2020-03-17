package com.prftcap.valetmgmt.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.prftcap.valetmgmt.controllers.ValetController;
import com.prftcap.valetmgmt.dto.ValetDTO;
import com.prftcap.valetmgmt.service.ValetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ValetController.class)
public class ValetPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValetService valetService;

    @Test
    public void verifyPostValetSuccess() throws Exception{

        ValetDTO valetDTO = ValetDTO.builder().initials("AN").firstName("Allan").build();
        when(valetService.saveValet(valetDTO)).thenReturn(valetDTO);

        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writeValueAsString(valetDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/valets").content(dtoAsString).contentType("application/json");
        mockMvc.perform(requestBuilder).andExpect((status().isCreated()));

        verify(valetService, times(1)).saveValet(valetDTO);
        verifyNoMoreInteractions(valetService);
    }
}
