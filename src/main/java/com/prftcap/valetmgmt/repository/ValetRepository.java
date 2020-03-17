package com.prftcap.valetmgmt.repository;

import com.prftcap.valetmgmt.entity.Valet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValetRepository  extends CrudRepository<Valet, Long> {
}
