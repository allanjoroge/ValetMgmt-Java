package com.prftcap.valetmgmt.service.impl;

import com.prftcap.valetmgmt.entity.Valet;
import com.prftcap.valetmgmt.repository.ValetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValetDeleteServiceImplTest {

    @Mock
    private ValetRepository valetRepositoryMock;

    @InjectMocks
    private ValetServiceImpl valetServiceImpl;

    @Test
    public void deleteValetById() {

        Valet valet = Valet.builder().id(14L).firstName("Allan").build();
        when(valetRepositoryMock.findById((long) 14)).thenReturn(Optional.ofNullable(valet));

        // call method under test
        valetServiceImpl.deleteValetById((long) 14);

        verify(valetRepositoryMock).findById((long) 14);
        verify(valetRepositoryMock).deleteById((long) 14);
    }
}
