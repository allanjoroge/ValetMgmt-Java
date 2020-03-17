package com.prftcap.valetmgmt.service.impl;

import com.prftcap.valetmgmt.dto.ValetDTO;
import com.prftcap.valetmgmt.entity.Valet;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.ValetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValetGetServiceImplTest {

    @Mock
    private ValetRepository valetRepositoryMock;

    @Mock
    private Mapper mapperMock;

    @InjectMocks
    private ValetServiceImpl valetServiceImpl;

    @Test
    public void findAllValets() {

        List<Valet> valets = new ArrayList<>();
        Valet v = Valet.builder().initials("AN").firstName("Allan").build();
        valets.add(v);

        when(valetRepositoryMock.findAll()).thenReturn(valets);

        ValetDTO vDTOs = ValetDTO.builder().initials("AN").firstName("Allan").build();
        when(mapperMock.transform(v)).thenReturn(vDTOs);

        List<ValetDTO> out = valetServiceImpl.findAllValets();

        assertNotNull(out);
        verify(valetRepositoryMock).findAll();
        verify(mapperMock).transform(v);
    }

    @Test
    public void verifyFindValetById() {

        Valet valet = Valet.builder().id(14L).firstName("Allan").build();
        ValetDTO vDTO = ValetDTO.builder().id(14L).firstName("Allan").build();

        Optional<Valet> oV = Optional.of(valet);
        when(valetRepositoryMock.findById(14L)).thenReturn(oV);
        when(mapperMock.transform(valet)).thenReturn(vDTO);

        valetServiceImpl.findValetByID(14L);

        verify(valetRepositoryMock).findById(14L);
        verify(mapperMock).transform(valet);
    }
}
