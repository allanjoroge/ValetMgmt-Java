package com.prftcap.valetmgmt.controller;


import com.prftcap.valetmgmt.controllers.ValetController;
import com.prftcap.valetmgmt.service.ValetService;
import org.junit.jupiter.api.Test;
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
public class ValetDeleteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValetService valetService;

    @Test
    public void verifyDeleteValetSuccess() throws Exception {

        //Build a DELETE request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/valets/4");
        mockMvc.perform(requestBuilder).andExpect((status().isOk()));

        //Verify interaction with the mocked projectDeleteService
        verify(valetService, times(1)).deleteValetById(4L);
        verifyNoMoreInteractions(valetService);
    }
}
