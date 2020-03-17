package com.prftcap.valetmgmt.controllers;

import com.prftcap.valetmgmt.dto.ValetDTO;
import com.prftcap.valetmgmt.service.ValetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("valets")
public class ValetController {

    private ValetService valetService;

    @Autowired
    public ValetController(ValetService valetService) {
        this.valetService = valetService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ValetDTO> findAll() {
        return valetService.findAllValets();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ValetDTO createValet(@RequestBody ValetDTO valetDTO) {

        return valetService.saveValet(valetDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ValetDTO findValetById(@PathVariable Long id) {

        return valetService.findValetByID(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateValet(@RequestBody ValetDTO valetDTO) {
        valetService.updateValet(valetDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteValetById(@PathVariable Long id) {

        valetService.deleteValetById(id);
    }
}
