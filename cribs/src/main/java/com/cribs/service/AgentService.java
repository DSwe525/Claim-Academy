package com.cribs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cribs.entity.Agent;
import com.cribs.repo.AgentRepo;

@Service
public class AgentService {
    
    @Autowired
    AgentRepo agentRepo;

    public Agent saveAgent(Agent agent) {

        return agentRepo.save(agent);
    }
    public void deleteAgentById(Integer id) {

        agentRepo.deleteById(id);
    }
    public Agent findAgentById(Integer id) {

        return agentRepo.findAgentById(id);
    }
    public Agent updateCustomer(Agent agent) throws Exception {

        if(agent.getId() != null) {

                return agentRepo.save(agent);
            }
            throw new Exception("must have id or an existing id");
    }
}
