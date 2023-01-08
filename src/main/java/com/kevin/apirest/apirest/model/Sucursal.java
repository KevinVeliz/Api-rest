package com.kevin.apirest.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String provincia;
    private String cuidad;
    private String direccion;

    @Column(name = "client_id")
    private Integer clientId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getClienteId() {
        return clientId;
    }

    public void setClienteId(Integer clienteId) {
        this.clientId = clienteId;
    }

    public Sucursal() {
    }

    public Sucursal(Integer id, String provincia, String cuidad, String direccion, Integer clientId) {
        this.id = id;
        this.provincia = provincia;
        this.cuidad = cuidad;
        this.direccion = direccion;
        this.clientId = clientId;
    }


    
    
}
