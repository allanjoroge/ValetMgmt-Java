package com.prftcap.valetmgmt.service.impl;

import com.prftcap.valetmgmt.dto.OwnerDTO;
import com.prftcap.valetmgmt.entity.Owner;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.OwnerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerPostServiceImplTest {

    @Mock
    private OwnerRepository ownerRepositoryMock;

    @Mock
    private Mapper mapperMock;

    @InjectMocks
    private OwnerServiceImpl ownerServiceImpl;

    @Test
    public void saveValet() {

        Owner owner = Owner.builder().id(14L).firstName("Allan").build();
        OwnerDTO ownerDTO = OwnerDTO.builder().id(14L).firstName("Allan").build();

        when(ownerRepositoryMock.save(owner)).thenReturn(owner);
        when(mapperMock.reverseTransform(ownerDTO)).thenReturn(owner);

        ownerServiceImpl.saveOwner(ownerDTO);

        verify(ownerRepositoryMock).save(owner);
        verify(mapperMock).reverseTransform(ownerDTO);
    }
}
