package com.prftcap.valetmgmt.controllers;


import com.prftcap.valetmgmt.dto.OwnerDTO;
import com.prftcap.valetmgmt.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OwnerDTO> findAll(@RequestParam @Nullable String lastName) {
        return ownerService.findAll(lastName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerDTO createOwner(@RequestBody OwnerDTO ownerDTO) {

        return ownerService.saveOwner(ownerDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOwner(@RequestBody OwnerDTO ownerDTO) {
        ownerService.updateOwner(ownerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOwnerById(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
    }
}
