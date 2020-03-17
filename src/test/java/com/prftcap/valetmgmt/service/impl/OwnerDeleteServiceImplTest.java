package com.prftcap.valetmgmt.service.impl;

import com.prftcap.valetmgmt.entity.Owner;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.OwnerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerDeleteServiceImplTest {

    @Mock
    private OwnerRepository ownerRepositoryMock;

    @Mock
    private Mapper mapperMock;

    @InjectMocks
    private OwnerServiceImpl ownerServiceImpl;

    @Test
    public void deleteOwnerById() {

        Owner owner = Owner.builder().id(14L).firstName("Allan").build();
        when(ownerRepositoryMock.findById((long) 14)).thenReturn(Optional.ofNullable(owner));

        // call method under test
        ownerServiceImpl.deleteOwnerById((long) 14);

        verify(ownerRepositoryMock).findById((long) 14);
        verify(ownerRepositoryMock).deleteById((long) 14);

    }
}
