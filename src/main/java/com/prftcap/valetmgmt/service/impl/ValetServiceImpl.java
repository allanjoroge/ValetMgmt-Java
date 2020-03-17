package com.prftcap.valetmgmt.service.impl;

import com.prftcap.valetmgmt.dto.ValetDTO;
import com.prftcap.valetmgmt.entity.Valet;
import com.prftcap.valetmgmt.exception.NotFoundException;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.ValetRepository;
import com.prftcap.valetmgmt.service.ValetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValetServiceImpl implements ValetService {

    private ValetRepository valetRepository;
    private Mapper mapper;

    @Autowired
    public ValetServiceImpl(ValetRepository valetRepository, Mapper mapper) {
        this.valetRepository = valetRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ValetDTO> findAllValets() {

        List<Valet> valets = (List<Valet>) valetRepository.findAll();

        List<ValetDTO> results = new ArrayList<>();
        for (Valet vlts : valets) {

            results.add(mapper.transform(vlts));
        }
        return results;
    }

    @Override
    public ValetDTO findValetByID(Long id) {
        Valet v = valetRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.transform(v);
    }

    @Override
    public ValetDTO saveValet(ValetDTO valetDTO) {
        Valet valet = mapper.reverseTransform(valetDTO);
        valet = valetRepository.save(valet);
        return mapper.transform(valet);
    }

    @Override
    public void updateValet(ValetDTO valetDTO) {

        Valet valet = mapper.reverseTransform(valetDTO);
        valet = valetRepository.save(valet);
        mapper.transform(valet);
    }

    @Override
    public void deleteValetById(Long id) {

        valetRepository.findById(id).orElseThrow(NotFoundException::new);
        valetRepository.deleteById(id);
    }
}
