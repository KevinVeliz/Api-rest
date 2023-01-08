package com.kevin.apirest.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.apirest.apirest.model.Clients;
import com.kevin.apirest.apirest.model.Matriz;
import com.kevin.apirest.apirest.repository.ClientRepository;
import com.kevin.apirest.apirest.service.MatrizService;

@RestController
@RequestMapping("/")
public class MatrizController {
    
    @Autowired
    private MatrizService service;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Matriz> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Matriz> findById(@PathVariable Integer id){
        return service.findById(id);
    }

}
