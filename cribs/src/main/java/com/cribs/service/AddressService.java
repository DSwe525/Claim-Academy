package com.cribs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cribs.entity.Address;
import com.cribs.repo.AddressRepo;

@Service
public class AddressService {
    
    @Autowired
    AddressRepo addressRepo;
    
    public Address saveAddress(Address address) {

        return addressRepo.save(address);
    }

    public Address lookupById(Integer id) throws Exception {
        
        Address address = addressRepo.lookupById(id);

        if(address != null) {
            return address;
    }
        throw new Exception("Address provided does not exist");
    }
    public Address updateCustomer(Address address) throws Exception {

        if(address.getId() != null) {

                return addressRepo.save(address);
            }
            throw new Exception("must have id or an existing id");
    }
    public void deleteById(Integer id) {

        addressRepo.deleteById(id);
     }

}
