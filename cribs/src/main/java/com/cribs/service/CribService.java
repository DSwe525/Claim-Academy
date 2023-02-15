package com.cribs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cribs.entity.Address;
import com.cribs.entity.Crib;
import com.cribs.repo.CribRepo;

@Service
public class CribService {
    
    @Autowired
    CribRepo cribRepo;

    public Crib saveCrib(Crib crib, Address address) {

        crib.setAddress(address);
        return cribRepo.save(crib);
    }
    public List<Crib> getCribsAvailable() {
        return cribRepo.getCribsAvailable();
    }
    public Crib findCribById(Crib crib) throws Exception {

        if(crib.getId() != null) {

                return cribRepo.save(crib);
            }
            throw new Exception("must have id or an existing id");
    }
    public Crib updateCrib(Crib crib) throws Exception {

        if(crib.getId() != null) {

                return cribRepo.save(crib);
            }
            throw new Exception("must have id or an existing id");
    }
    public void deleteCribById(Integer id) {

        cribRepo.deleteById(id);
    }
    
}
