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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValetPostServiceImplTest {

    @Mock
    private ValetRepository valetRepositoryMock;

    @Mock
    private Mapper mapperMock;

    @InjectMocks
    private ValetServiceImpl valetServiceImpl;

    @Test
    public void saveValet() {

        //setup
        Valet valet = Valet.builder().id(14L).firstName("Allan").build();
        ValetDTO valetDTO = ValetDTO.builder().id(14L).firstName("Allan").build();
        when(valetRepositoryMock.save(valet)).thenReturn(valet);
        when(mapperMock.reverseTransform(valetDTO)).thenReturn(valet);

        //call method under test
        valetServiceImpl.saveValet(valetDTO);

        verify(valetRepositoryMock).save(valet);
        verify(mapperMock).reverseTransform(valetDTO);
    }
}
