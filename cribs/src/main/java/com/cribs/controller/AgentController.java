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

import com.cribs.entity.Agent;
import com.cribs.service.AddressService;
import com.cribs.service.AgentService;
import com.cribs.service.CribService;

@RestController
@RequestMapping("/agent")
@CrossOrigin("*")
public class AgentController {
    
    @Autowired
    AgentService agentService;
    @Autowired 
    CribService cribService;
    @Autowired 
    AddressService addressService;

    @RequestMapping(
        value="/create",
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
        value="/findById",
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
    @RequestMapping(
        value="/findByEmail",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findAgentByEmail(@PathVariable String email) {
                
    try {
        
        agentService.findAgentByEmail(email);
        
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
    @RequestMapping(
        value="/login",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> login(@RequestBody Agent agent) {
        
        try {
            Agent loggedInAgent = agentService.login(agent);

            return new ResponseEntity<>(loggedInAgent, HttpStatus.OK);
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
        value="/delete",
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

}
