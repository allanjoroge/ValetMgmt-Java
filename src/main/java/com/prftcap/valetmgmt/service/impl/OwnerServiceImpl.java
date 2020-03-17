package com.prftcap.valetmgmt.service.impl;

import com.prftcap.valetmgmt.dto.OwnerDTO;
import com.prftcap.valetmgmt.entity.Owner;
import com.prftcap.valetmgmt.exception.NotFoundException;
import com.prftcap.valetmgmt.mapper.Mapper;
import com.prftcap.valetmgmt.repository.OwnerRepository;
import com.prftcap.valetmgmt.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;
    private Mapper mapper;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, Mapper mapper) {
        this.ownerRepository = ownerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<OwnerDTO> findAll(String lastName) {

        List<Owner> owners;

        if (lastName == null) {
            owners = (List<Owner>) ownerRepository.findAll();
        } else {
            owners = ownerRepository.findByLastNameStartsWithIgnoreCase(lastName);
        }

        List<OwnerDTO> results = new ArrayList<>();

        for (Owner ownrs : owners) {

            results.add(mapper.transform(ownrs));
        }
        return results;
    }

    @Override
    public OwnerDTO saveOwner(OwnerDTO ownerDTO) {
        Owner owner = mapper.reverseTransform(ownerDTO);
        owner = ownerRepository.save(owner);
        return mapper.transform(owner);
    }

    @Override
    public void updateOwner(OwnerDTO ownerDTO) {
        Owner owner = mapper.reverseTransform(ownerDTO);
        owner = ownerRepository.save(owner);
        mapper.transform(owner);
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.findById(id).orElseThrow(NotFoundException::new);
        ownerRepository.deleteById(id);
    }
}
