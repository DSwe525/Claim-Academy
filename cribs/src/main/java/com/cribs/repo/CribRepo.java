package com.cribs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cribs.entity.Crib;

@Repository
public interface CribRepo extends JpaRepository<Crib, Integer> {
    
    @Query(value="select * from crib where id = ?1", nativeQuery = true)
    public Crib findCribById(Integer id);

    @Query(value="select * from crib where size = ?1", nativeQuery = true)
    public Crib lookupBySize(String size);

    @Query(value="select * from crib where price = ?1", nativeQuery = true)
    public Crib lookupByPrice(String price);
    
    @Query(value="select * from crib where date_posted = ?1", nativeQuery = true)
    public Crib lookupByDatePosted(String datePosted);
    
    @Query(value = "select * from crib where customer_id is null", nativeQuery = true)
    public List<Crib> getCribsAvailable();

    @Query(value = "select * from crib where customer_id is null order by date_posted asc limit 3", nativeQuery = true)
    public List<Crib> getCribsSpecials();
    
}
