package com.kevin.apirest.apirest.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.kevin.apirest.apirest.model.Clients;
import com.kevin.apirest.apirest.model.Sucursal;
import com.kevin.apirest.apirest.repository.ClientRepository;
import com.kevin.apirest.apirest.repository.SucursalRepository;

import ch.qos.logback.core.net.server.Client;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;

    @Autowired 
    private SucursalRepository repositorySucursal;

    public List<Clients> findAll(){
        return repository.findAll();
    }

    public Optional<Sucursal> findAllSucursall(Integer id){
        return repositorySucursal.findById(id);
    }

    public Clients save(Clients entity){
        return repository.save(entity);
    }

    public Optional<Clients> findById(Integer id){
        return repository.findById(id);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Clients updateProductByFields(Integer id, Map<String, Object> fields) {
        Optional<Clients> existingClients = repository.findById(id);
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findRequiredField(Clients.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingClients.get(), value);
            });
            return repository.save(existingClients.get());
    }

}
