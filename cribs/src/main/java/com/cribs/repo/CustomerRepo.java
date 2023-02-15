package com.cribs.repo;

import org.springframework.stereotype.Repository;

import com.cribs.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
    
    @Query(value="select * from customer where email = ?1 && password = ?2", nativeQuery = true)
    public Customer login(String email, String password);

    @Query(value="select * from customer where email = ?1", nativeQuery = true)
    public Customer getByEmail(String email);

    @Query(value="select * from customer where id = ?1", nativeQuery = true)
    public Customer getById(Integer id);
}
