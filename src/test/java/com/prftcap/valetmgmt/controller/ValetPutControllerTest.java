

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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ValetController.class)
public class ValetPutControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValetService valetService;

    @Test
    public void verifyPutValetSuccess() throws Exception {

        ValetDTO valetDTO = ValetDTO.builder().id(14L).firstName("Allan").build();
//        when(valetService.updateValet(valetDTO)).thenReturn(valetDTO);

        ObjectMapper mapper = new ObjectMapper();
        String dtoAsString = mapper.writeValueAsString(valetDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/valets/14").content(dtoAsString).contentType("application/json");
        mockMvc.perform(requestBuilder).andExpect((status().isNoContent()));

        verify(valetService, times(1)).updateValet(valetDTO);
        verifyNoMoreInteractions(valetService);
    }
}
