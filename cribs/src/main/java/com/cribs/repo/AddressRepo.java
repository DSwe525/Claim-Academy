package com.cribs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cribs.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    
    @Query(value="select * from address where id = ?1", nativeQuery = true)
    public Address lookupById(Integer id);

    @Query(value="select * from address where street_number = ?1 && street_name = ?2", nativeQuery = true)
    public Address lookupByStreetNumberAndStreetName(Integer streetNumber, String streetName);

    @Query(value="select * from address where city = ?1", nativeQuery = true)
    public Address lookupByCity(String city);

    @Query(value="select * from address where state = ?1", nativeQuery = true)
    public Address lookupByState(String state);
    
    @Query(value="select * from user where city = ?1 && state = ?2", nativeQuery = true)
    public Address lookupByCityAndState(String city, String state);
}
