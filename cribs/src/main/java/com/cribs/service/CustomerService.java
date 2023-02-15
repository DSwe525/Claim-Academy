package com.cribs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cribs.entity.Customer;
import com.cribs.repo.CustomerRepo;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepo customerRepo;

    public Customer save(Customer customer) {

        return customerRepo.save(customer);
    }

    public Customer findUserById(Integer id) {

        return customerRepo.findById(id).get();
    }
    
    public void deleteById(Integer id) {

       customerRepo.deleteById(id);
    }
    
    public Customer login(Customer customer) throws Exception {

        customer = customerRepo.login(customer.getEmail(), customer.getPassword());

        if(customer != null) {
            return customer;
        }
        throw new Exception("You Email/Password combo does not exist, try again");
    }
    
    public Customer getByEmail(String email) throws Exception {
        
        Customer customer = customerRepo.getByEmail(email);

        if(customer != null) {
            return customer;
    }
        throw new Exception(" Email did not exist, please try again or sign up");
    }

    public Customer updateCustomer(Customer customer) throws Exception {

        if(customer.getId() != null || 
            findUserById(customer.getId()) != null) {

                return save(customer);
            }
            throw new Exception("must have id or an existing id");
    }
}
