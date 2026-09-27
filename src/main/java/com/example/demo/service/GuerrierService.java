package com.example.demo.service;

import com.example.demo.model.Espece;
import com.example.demo.model.Guerrier;
import com.example.demo.repositori.GuerrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GuerrierService {

    private final GuerrierRepository guerrierRepository;
    @Autowired
    public GuerrierService(GuerrierRepository guerrierRepository){
        this.guerrierRepository = guerrierRepository;
    }
    public Guerrier create(String nom, String espece){
        Guerrier guerrier = new Guerrier(nom, espece);
        return guerrierRepository.save(guerrier);
    }

    public Map<String,Integer> getCaracteristiques(int id) {
        Guerrier guerrier = guerrierRepository.findById(id).get();
        return guerrier.getCaracteristiques();
    }
    public List<Guerrier> getAllGuerriers() {
        return guerrierRepository.findAll();
    }


}
