package com.kevin.apirest.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.apirest.apirest.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal,Integer>{
    public List<Sucursal> findByClientId(Integer clientId);
}
