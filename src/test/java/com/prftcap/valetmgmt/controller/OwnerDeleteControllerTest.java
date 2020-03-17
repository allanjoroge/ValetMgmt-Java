package com.prftcap.valetmgmt.controller;

import com.prftcap.valetmgmt.controllers.OwnerController;
import com.prftcap.valetmgmt.service.OwnerService;
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
@WebMvcTest(value = OwnerController.class)
public class OwnerDeleteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @Test
    public void verifyDeleteOwnerSuccess() throws Exception {

        //Build a DELETE request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/owners/4");
        mockMvc.perform(requestBuilder).andExpect((status().isOk()));

        //Verify interaction with the mocked projectDeleteService
        verify(ownerService, times(1)).deleteOwnerById(4L);
        verifyNoMoreInteractions(ownerService);

    }
}
