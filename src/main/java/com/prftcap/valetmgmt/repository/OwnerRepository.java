package com.prftcap.valetmgmt.repository;

import com.prftcap.valetmgmt.entity.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    List<Owner> findByLastNameStartsWithIgnoreCase(String lastName);
}
