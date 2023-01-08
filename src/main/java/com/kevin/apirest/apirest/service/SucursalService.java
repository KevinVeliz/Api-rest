package com.kevin.apirest.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.apirest.apirest.model.Sucursal;
import com.kevin.apirest.apirest.repository.SucursalRepository;

@Service
public class SucursalService {
    
    @Autowired
    private SucursalRepository repository;

    public Optional<Sucursal> findById(Integer id){
        return repository.findById(id);
    }

    public Sucursal save(Sucursal entity){
        return repository.save(entity);
    }

}
