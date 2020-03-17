package com.prftcap.valetmgmt.service;

import com.prftcap.valetmgmt.dto.ValetDTO;

import java.util.List;

public interface ValetService {

    ValetDTO saveValet(ValetDTO valetDTO);

    void updateValet(ValetDTO valetDTO);

    ValetDTO findValetByID(Long id);

    List<ValetDTO> findAllValets();

    void deleteValetById(Long id);
}
