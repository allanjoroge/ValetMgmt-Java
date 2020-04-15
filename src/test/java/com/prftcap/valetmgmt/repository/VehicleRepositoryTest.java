package com.prftcap.valetmgmt.repository;


import com.prftcap.valetmgmt.dto.SearchRequest;
import com.prftcap.valetmgmt.entity.Vehicle;
import com.querydsl.core.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
@Sql(scripts = "/vehicle-search.sql")
@Sql(scripts = "/vehicle-clean-up-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void whenSearchingForVehiclesByValet_thenVehiclesIsReturned() {

        Long location = 1L;
        SearchRequest vsr = SearchRequest.builder().location(location).build();

        Predicate pred = VehicleRepository.createSearchPredicate(vsr);
        List<Vehicle> vehicleList = (List<Vehicle>) vehicleRepository.findAll(pred);

        assertEquals(vehicleList.size(),5);

        Vehicle v = vehicleList.get(0);
        assertThat(v.getValet().getId(), is(101L));

    }
}
