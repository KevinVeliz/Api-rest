package com.kevin.apirest.apirest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "MATRIZ_TB")
public class Matriz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mainProvince;
    private String mainCity;
    private String mainAddress;

    @OneToMany(mappedBy = "matrizId")
    private List<Clients> clients;
    
    // @OneToMany(mappedBy = "mainProvince")
    // private List<Clients> clientsProvince;

    // @OneToMany(mappedBy = "mainCity")
    // private List<Clients> clientsCity;

    // @OneToMany(mappedBy = "mainAddress")
    // private List<Clients> clientsAddress;


    public Matriz(Integer id, String mainProvince, String mainCity, String mainAddress, List<Clients> clients,
            List<Clients> clientsProvince, List<Clients> clientsCity, List<Clients> clientsAddress) {
        this.id = id;
        this.mainProvince = mainProvince;
        this.mainCity = mainCity;
        this.mainAddress = mainAddress;
        this.clients = clients;

    }

    public Matriz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    // public List<Clients> getClientsProvince() {
    //     return clientsProvince;
    // }

    // public void setClientsProvince(List<Clients> clientsProvince) {
    //     this.clientsProvince = clientsProvince;
    // }

    // public List<Clients> getClientsCity() {
    //     return clientsCity;
    // }

    // public void setClientsCity(List<Clients> clientsCity) {
    //     this.clientsCity = clientsCity;
    // }

    // public List<Clients> getClientsAddress() {
    //     return clientsAddress;
    // }

    // public void setClientsAddress(List<Clients> clientsAddress) {
    //     this.clientsAddress = clientsAddress;
    // }

    

   

}
