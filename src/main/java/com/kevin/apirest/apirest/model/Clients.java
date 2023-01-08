package com.kevin.apirest.apirest.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clients {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identificacionType;
    private int identificacionNumber;
    private String name;
    private String email;
    private int phone;

    @Column(name = "matriz_id")
    private Integer matrizId;

    @Column(name = "main_Province")
    private String mainProvince;

    @Column(name = "main_City")
    private String mainCity;

    @Column(name = "main_Address")
    private String mainAddress;

    @OneToMany(mappedBy = "clientId")
    private List<Sucursal> sucursales;

    public Clients() {
    }

    public Clients(Integer id, String identificacionType, int identificacionNumber, String name, String email,
            int phone, Integer matrizId, String mainProvince, String mainCity, String mainAddress,
            List<Sucursal> sucursales) {
        this.id = id;
        this.identificacionType = identificacionType;
        this.identificacionNumber = identificacionNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.matrizId = matrizId;
        this.mainProvince = mainProvince;
        this.mainCity = mainCity;
        this.mainAddress = mainAddress;
        this.sucursales = sucursales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacionType() {
        return identificacionType;
    }

    public void setIdentificacionType(String identificacionType) {
        this.identificacionType = identificacionType;
    }

    public int getIdentificacionNumber() {
        return identificacionNumber;
    }

    public void setIdentificacionNumber(int identificacionNumber) {
        this.identificacionNumber = identificacionNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Integer getMatrizId() {
        return matrizId;
    }

    public void setMatrizId(Integer matrizId) {
        this.matrizId = matrizId;
    }

    public String getMainProvince() {
        return mainProvince;
    }

    public void setMainProvince(String mainProvince) {
        this.mainProvince = mainProvince;
    }

    public String getMainCity() {
        return mainCity;
    }

    public void setMainCity(String mainCity) {
        this.mainCity = mainCity;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    
   
    


}
