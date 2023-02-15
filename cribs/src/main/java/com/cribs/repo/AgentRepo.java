package com.cribs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cribs.entity.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {
    
    @Query(value="select * from agent where id = ?1", nativeQuery = true)
    public Agent lookupAgentbyId(Integer id);

}
