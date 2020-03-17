package com.prftcap.valetmgmt.service;

import com.prftcap.valetmgmt.dto.OwnerDTO;
import com.prftcap.valetmgmt.dto.ValetDTO;

import java.util.List;

public interface OwnerService {

    OwnerDTO saveOwner(OwnerDTO ownerDTO);

    void updateOwner(OwnerDTO ownerDTO);

//    OwnerDTO findDistinctByLastName(String lastName);

    List<OwnerDTO> findAll(String lastName);

    void deleteOwnerById(Long id);}
