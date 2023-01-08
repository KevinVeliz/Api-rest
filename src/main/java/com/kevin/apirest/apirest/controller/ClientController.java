package com.kevin.apirest.apirest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration.EnableTransactionManagementConfiguration.CglibAutoProxyConfiguration;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.kevin.apirest.apirest.model.*;

import com.kevin.apirest.apirest.model.Clients;
import com.kevin.apirest.apirest.model.Matriz;
import com.kevin.apirest.apirest.model.Sucursal;
import com.kevin.apirest.apirest.repository.ClientRepository;
import com.kevin.apirest.apirest.repository.MatrizRepository;
import com.kevin.apirest.apirest.repository.SucursalRepository;
import com.kevin.apirest.apirest.service.ClientService;
import com.kevin.apirest.apirest.service.MatrizService;
import com.kevin.apirest.apirest.service.SucursalService;

@RestController
@RequestMapping("/clients")
public class ClientController {
    
    @Autowired
    private ClientService serviceClient;

    @Autowired
    private ClientRepository repository;

    @Autowired
    private SucursalRepository repository2;

    @Autowired
    private SucursalService serviceSucursal;



     // -----------------------------------------------------------------------------------------------------------------------------------\\
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clients> findAll(){
        return serviceClient.findAll();
    }

     // -----------------------------------------------------------------------------------------------------------------------------------\\

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/save")
        public ResponseEntity<?> save(@RequestBody Clients entity){
            Optional<Clients> otherClient = repository.findByIdentificacionNumber(entity.getIdentificacionNumber());
            if(otherClient.isPresent()){
                return conflict();
            }
            Clients updateClients = serviceClient.save(entity);
            return ResponseEntity.ok(updateClients);
        }

     // -----------------------------------------------------------------------------------------------------------------------------------\\

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clients> findById(@PathVariable Integer id){
        Optional<Clients> opt = serviceClient.findById(id);
        if (!opt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(opt.get());
    }

     // -----------------------------------------------------------------------------------------------------------------------------------\\

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id") Integer id, @RequestBody Clients entity){
        try{
            Optional<Clients> otherClient = repository.findByIdentificacionNumber(entity.getIdentificacionNumber());
            if(otherClient.isPresent()){
                return conflict();
            }
            Optional<Clients> opt = serviceClient.findById(id);
            if(opt.isPresent()){
                Clients updatedClients = serviceClient.findById(id).get();
                updatedClients.setIdentificacionNumber(entity.getIdentificacionNumber());
                updatedClients.setIdentificacionType(entity.getIdentificacionType());
                updatedClients.setEmail(entity.getEmail());
                updatedClients.setPhone(entity.getPhone());
                return ResponseEntity.ok(serviceClient.save(updatedClients));
            }else {
                return notFound();
            }
        }catch (Exception exp) {
			return badRequest(exp);
		}
    }

    // @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update/{id}")
    // public ResponseEntity<?> updateProductFields(@PathVariable Integer id,@RequestBody Clients entity){
    //     // Optional<Clients> otherClient = repository.findByIdentificacionNumber(entity.getIdentificacionNumber());
    //     // if(otherClient.isPresent()){
    //     //     return conflict();
    //     // }
    //     // Clients update = serviceClient.updateProductByFields(id,fields);
    //     // return  ResponseEntity.ok(update);
    //     Optional<Clients> otherClient = serviceClient.findById(id);
    //     otherClient.get().setIdentificacionNumber(entity.getIdentificacionNumber());
    //     otherClient.get().setIdentificacionType(entity.getIdentificacionType());
    //     otherClient.get().setName(entity.getName());
    //     otherClient.get().setEmail(entity.getEmail());
    //     otherClient.get().setPhone(entity.getPhone());
    //     Clients clientRepon = serviceClient.save(otherClient.get());
    //     return  ResponseEntity.ok(clientRepon);
    // }

    // -----------------------------------------------------------------------------------------------------------------------------------\\
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable Integer id){
        serviceClient.deleteById(id);
        return "Delete successfully";
    }

    // -----------------------------------------------------------------------------------------------------------------------------------\\

    @RequestMapping(value="/{id}/sucursal",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sucursal> findAllSucursall(@PathVariable Integer id){
        return repository2.findByClientId(id);
    }

    // -----------------------------------------------------------------------------------------------------------------------------------\\

    

    // -----------------------------------------------------------------------------------------------------------------------------------\\

    private ResponseEntity<?> notFound() {
		return new ResponseEntity<>(
				new ErrorResponse(HttpStatus.NOT_FOUND.toString(), "Player not found"),
				HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<?> badRequest(Throwable throwable) {
		return new ResponseEntity<>(
				new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), "Bad request"),
				HttpStatus.BAD_REQUEST);
	}

    private ResponseEntity<?> conflict() {
		return new ResponseEntity<>(
				new ErrorResponse(HttpStatus.CONFLICT.toString(), "User with identificacionNumber already exists"),
				HttpStatus.CONFLICT);
	}



}
