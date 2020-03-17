package com.prftcap.valetmgmt.service.impl;


import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.dto.VehicleSearchRequest;
import com.prftcap.valetmgmt.entity.Vehicle;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.VehicleRepository;
import com.prftcap.valetmgmt.service.impl.VehicleServiceImpl;
import com.querydsl.core.types.Predicate;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class VehicleGetServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepositoryMock;

    @Mock
    private Mapper mapperMock;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @InjectMocks
    private VehicleSearchRequest searchRequest;

    @Test
    public void searchVehicles() {

        //setup the repoMock to return back an array list
        List<Vehicle> vehicles = new ArrayList<>();
        Page<Vehicle> pagedVehicles = new PageImpl<>(vehicles);
        Vehicle v = Vehicle.builder().id((long) 14).model("evolution").build();
        vehicles.add(v);

        // teach the parrot mockito
        when(vehicleRepositoryMock.findAll(any(Predicate.class), any(AbstractPageRequest.class))).thenReturn(pagedVehicles);

        //setup the mapper to return back a VehicleDTO
        VehicleDTO vDTO = VehicleDTO.builder().id((long) 14).model("evolution").build();
        when(mapperMock.transform(v)).thenReturn(vDTO);

        //call method under test
        Page<VehicleDTO> pVehicleDTO = vehicleService.search(searchRequest);

        //assertions
        assertNotNull(pVehicleDTO);
        verify(vehicleRepositoryMock).findAll((any(Predicate.class)), any(AbstractPageRequest.class));
        verify(mapperMock).transform(v);
//        assertThat(pagedVehicles.getSize(), is(1));
//        assertThat(out.get(0).getId(), is((long)14));
    }

    @Test
    public void verifyFindVehicleById() {

        Vehicle vehicle = Vehicle.builder().id((long) 14).model("lancer").build();
        VehicleDTO vDTO = VehicleDTO.builder().id((long) 14).model("lancer").build();

        Optional<Vehicle> oV = Optional.of(vehicle);
        when(vehicleRepositoryMock.findById((long) 14)).thenReturn(oV);
        when(mapperMock.transform(vehicle)).thenReturn(vDTO);

        vehicleService.findVehicleByID((long) 14);

        verify(vehicleRepositoryMock).findById((long) 14);
        verify(mapperMock).transform(vehicle);
    }

    @Test
    public void sortOrderWithNullSearchRequest() {

        Sort sortOrder = vehicleService.createSortOrder(null);

        MatcherAssert.assertThat(sortOrder.isEmpty(), is(false));
        List<Sort.Order> orderList = sortOrder.toList();
        MatcherAssert.assertThat(orderList.size(), is(1));
        Sort.Order order = orderList.get(0);
        MatcherAssert.assertThat(order.isAscending(), is(true));
        MatcherAssert.assertThat(order.getProperty(), is("ticketNumber"));
    }

    @Test
    public void sortOrderDefaultByColumnAndDirection() {

        Sort sortOrder = vehicleService.createSortOrder(new VehicleSearchRequest());

        MatcherAssert.assertThat(sortOrder.isEmpty(), is(false));
        List<Sort.Order> orderList = sortOrder.toList();
        MatcherAssert.assertThat(orderList.size(), is(1));
        Sort.Order order = orderList.get(0);
        MatcherAssert.assertThat(order.isAscending(), is(true));
        MatcherAssert.assertThat(order.getProperty(), is("ticketNumber"));
    }

    @Test
    public void sortOrderByColumnAndDirection() {

        Sort sortOrder = vehicleService.createSortOrder(VehicleSearchRequest.builder().sortColumns(new String[]{"locationId", "ticketNumber"}).sortDirections(new String[]{"DESC", "ASC"}).build());

        MatcherAssert.assertThat(sortOrder.isEmpty(), is(false));

        List<Sort.Order> orderList = sortOrder.toList();
        MatcherAssert.assertThat(orderList.size(), is(2));

        Sort.Order order = orderList.get(0);
        MatcherAssert.assertThat(order.isAscending(), is(false));
        MatcherAssert.assertThat(order.isDescending(), is(true));
        MatcherAssert.assertThat(order.getProperty(), is("locationId"));

        Sort.Order order1 = orderList.get(1);
        MatcherAssert.assertThat(order1.isAscending(), is(true));
        MatcherAssert.assertThat(order1.isDescending(), is(false));
        MatcherAssert.assertThat(order1.getProperty(), is("ticketNumber"));
    }
}
