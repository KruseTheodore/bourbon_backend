package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.repositories.BourbonRepository;
import com.maven.bourbon_backend.model.Bourbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BourbonService {

    private final BourbonRepository bourbonRepository;

    @Autowired
    public BourbonService(@Qualifier("MongoBourbon") BourbonRepository bourbonRepository){
        this.bourbonRepository = bourbonRepository;
    }

    public void addBourbon(Bourbon bourbon ) {
        bourbonRepository.save(bourbon);
    }

    public List<Bourbon> getAllBourbons(){
        return bourbonRepository.findAll();
    }

    public Optional<Bourbon> getBourbonByName(String name){
        return bourbonRepository.findById(name);
    }

    public void deleteBourbonByName(String name){
        bourbonRepository.deleteById(name);
    }

    public void updateBourbonById(String name, Bourbon bourbon){
        bourbonRepository.deleteById(name);
        bourbonRepository.save(bourbon);
    }



}
