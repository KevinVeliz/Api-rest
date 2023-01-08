package com.kevin.apirest.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.apirest.apirest.model.Sucursal;
import com.kevin.apirest.apirest.service.SucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    
    @Autowired
    private SucursalService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Sucursal> finbyId(@PathVariable Integer id){
        return service.findById(id);
    }

    @RequestMapping(value="/save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Sucursal save(@RequestBody Sucursal entity){
        return service.save(entity);
    }
    


}
