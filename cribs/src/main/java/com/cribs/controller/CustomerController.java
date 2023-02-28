package com.cribs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cribs.entity.Customer;
import com.cribs.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    @RequestMapping(
        value="/signup",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> signup(@RequestBody Customer customer) {
        try {
            customer = customerService.save(customer);

            return new ResponseEntity<>(customer, HttpStatus.CREATED);
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
        value="/login",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> login(@RequestBody Customer customer) {
        
        try {
            Customer loggedInCustomer = customerService.login(customer);

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
        value="/getCustomerByEmail/{email}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> getCustomerByEmail(@PathVariable String email) {
        
        try {
            Customer loggedInCustomer = customerService.getByEmail(email);

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
        value="/update",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
            
        try {
    
            customer = customerService.updateCustomer(customer);
    
            return new ResponseEntity<>(customer,HttpStatus.OK);
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
        value="/delete",
        method = RequestMethod.DELETE
        )
        public ResponseEntity<Object> deleteCustomer(@PathVariable Integer id) {
            
        try {
    
            customerService.deleteById(id);
    
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
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
