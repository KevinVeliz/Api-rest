package com.kevin.apirest.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.apirest.apirest.model.Matriz;
import com.kevin.apirest.apirest.repository.MatrizRepository;

@Service
public class MatrizService {
    
    @Autowired
    private MatrizRepository repository;

    public List<Matriz> findAll(){
        return repository.findAll();
    }

    public Optional<Matriz> findById(Integer id){
        return repository.findById(id);
    }
}
