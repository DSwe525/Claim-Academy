package com.cribs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cribs.entity.Agent;
import com.cribs.service.AddressService;
import com.cribs.service.AgentService;
import com.cribs.service.CribService;

@RestController
public class AgentController {
    
    @Autowired
    AgentService agentService;
    @Autowired 
    CribService cribService;
    @Autowired 
    AddressService addressService;

    @RequestMapping(
        value="/addAgent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> addAgent(@RequestBody Agent agent) {
        try {
            agent = agentService.saveAgent(agent);

            return new ResponseEntity<>(agent, HttpStatus.CREATED);
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
        value="/deleteAgent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.DELETE
        )
        public ResponseEntity<Object> deleteAgent(@PathVariable Integer id) {
            
        try {
    
            agentService.deleteAgentById(id);
    
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
    @RequestMapping(
        value="/updateAgent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> updateAgent(@RequestBody Agent agent) {
        try {
            agent = agentService.saveAgent(agent);
    
            return new ResponseEntity<>(agent, HttpStatus.OK);
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
        value="/findAgentById",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findAgentById(@PathVariable Integer id) {
                
    try {
        
        agentService.findAgentById(id);
        
        return new ResponseEntity<>(null,HttpStatus.OK);
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
