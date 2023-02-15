package com.cribs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cribs.entity.Address;
import com.cribs.entity.Crib;
import com.cribs.service.AddressService;
import com.cribs.service.CribService;

@RestController
public class CribController {
    
    @Autowired
    CribService cribService;
    @Autowired
    AddressService addressService;

    @RequestMapping(
        value="/getListOfCribs/",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> getListOfCribs() {
        
        try {
            List<Crib> loggedInCustomer = cribService.getCribsAvailable();

            return new ResponseEntity<>(loggedInCustomer, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Error e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }  
    }
    @RequestMapping(
        value="/addCrib",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> addCrib(@RequestBody Crib crib) {
        try {
            Address address = addressService.saveAddress(new Address());
            crib = cribService.saveCrib(crib, address);

            return new ResponseEntity<>(crib, HttpStatus.CREATED);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } 
        catch(Error e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(
        value="/getCribByAddress/{street_number}/{street_name}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> getCribById(@PathVariable Integer id) {
        
        try {
            Address address = addressService.lookupById(id);

            return new ResponseEntity<>(address, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Error e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }  
    }
}