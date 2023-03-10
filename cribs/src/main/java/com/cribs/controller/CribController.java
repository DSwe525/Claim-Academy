package com.cribs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cribs.entity.Address;
import com.cribs.entity.Crib;
import com.cribs.entity.Customer;
import com.cribs.service.AddressService;
import com.cribs.service.CribService;
import com.cribs.service.CustomerService;

@RestController
@RequestMapping("/crib")
@CrossOrigin("*")
public class CribController {
    
    @Autowired
    CribService cribService;
    @Autowired
    CustomerService customerService;
    @Autowired
    AddressService addressService;

    @RequestMapping(
        value="/create",
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
        value="/getlist",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> getListOfCribs() {
        
        try {
            List<Crib> allAvailableCribs = cribService.getCribsAvailable();

            return new ResponseEntity<>(allAvailableCribs, HttpStatus.OK);
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
        value="/getlistofspecials",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> getListOfSpecials() {
        
        try {
            List<Crib> allAvailableCribs = cribService.getCribsSpecials();

            return new ResponseEntity<>(allAvailableCribs, HttpStatus.OK);
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
        value="/buycrib/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> buyCrib(@RequestBody Customer customer, @PathVariable Integer id) {
        try {

            Crib crib = cribService.getCribById(id);

            customer = customerService.buyCrib(customer, crib);

            return new ResponseEntity<>(customer, HttpStatus.OK);
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
        value="/update",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> updateCrib(@RequestBody Crib crib) {
        try {

            crib = cribService.updateCrib(crib);

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
        value="/delete",
        method = RequestMethod.DELETE
    )
    public ResponseEntity<Object> deleteCrib(@PathVariable Integer id) {
        try {

            cribService.deleteCribById(id);

            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
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


}
