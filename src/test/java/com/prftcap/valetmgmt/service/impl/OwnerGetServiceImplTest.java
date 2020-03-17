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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerGetServiceImplTest {

    @Mock
    private OwnerRepository ownerRepositoryMock;

    @Mock
    private Mapper mapperMock;

    @InjectMocks
    private OwnerServiceImpl ownerServiceImpl;

    @Test
    public void findAllOwners() {

        List<Owner> owners = new ArrayList<>();
        Owner o = Owner.builder().firstName("Allan").lastName("Njau").build();
        owners.add(o);

        when(ownerRepositoryMock.findAll()).thenReturn(owners);

        OwnerDTO oDTOs = OwnerDTO.builder().firstName("Allan").lastName("Njau").build();
        when(mapperMock.transform(o)).thenReturn(oDTOs);

        List<OwnerDTO> out = ownerServiceImpl.findAll(null);

        assertNotNull(out);
        verify(ownerRepositoryMock).findAll();
        verify(mapperMock).transform(o);
    }

    @Test
    public void findByLastNameStartsWithIgnoreCase() {

        List<Owner> owners = new ArrayList<>();
        Owner o = Owner.builder().firstName("Allan").lastName("Njau").build();
        owners.add(o);

        when(ownerRepositoryMock.findByLastNameStartsWithIgnoreCase("Njau")).thenReturn(owners);

        OwnerDTO oDTOs = OwnerDTO.builder().firstName("Allan").lastName("Njau").build();
        when(mapperMock.transform(o)).thenReturn(oDTOs);

        List<OwnerDTO> out = ownerServiceImpl.findAll("Njau");

        assertNotNull(out);
        verify(ownerRepositoryMock).findByLastNameStartsWithIgnoreCase("Njau");
        verify(mapperMock).transform(o);
    }
}
