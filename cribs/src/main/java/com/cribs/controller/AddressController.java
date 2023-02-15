package com.cribs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cribs.service.AddressService;

@RestController
public class AddressController {
    
    @Autowired
    AddressService addressService;

}
