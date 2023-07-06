package com.veterinaria.mascotas.controller;

import com.veterinaria.mascotas.service.VeterinariaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {
    private Logger logger = LoggerFactory.getLogger(VeterinariaController.class);

    private final VeterinariaService veterinariaService;
    public VeterinariaController(VeterinariaService veterinariaService)
    {this.veterinariaService = veterinariaService;}
    @RequestMapping(value = "/mascotas",method= RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity findAll(Pageable pageable) {
        return new ResponseEntity(this.veterinariaService.getAll(pageable), HttpStatus.OK);
    }
}
