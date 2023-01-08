package com.kevin.apirest.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.apirest.apirest.model.Clients;

public interface ClientRepository extends JpaRepository<Clients, Integer>{
    List<Clients> findByMatrizId(Integer matrizId);
    Optional<Clients> findByIdentificacionNumber(int identificacionNumber);
}
