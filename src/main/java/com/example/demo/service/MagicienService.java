package com.example.demo.service;

import com.example.demo.model.Espece;
import com.example.demo.model.Guerrier;
import com.example.demo.repositori.GuerrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MagicienService {

    private final MagicienRepository magicienRepository;
    @Autowired
    public MagicienService(MagicienRepository magicienRepository){
        this.magicienRepository = magicienRepository;
    }
    public Magicien create(String nom, String espece){
        Magicien guerrier = new Magicien(nom, espece);
        return magicienRepository.save(guerrier);
    }

    public Map<String,Integer> getCaracteristiques(int id) {
        Magicien magicien = magicienRepository.findById(id).get();
        return magicien.getCaracteristiques();
    }
    public List<Magicien> getAllMagicien() {
        return guerrierRepository.findAll();
    }


}
