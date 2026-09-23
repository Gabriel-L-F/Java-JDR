package com.example.demo.service;

import com.example.demo.model.Espece;
import com.example.demo.model.Guerrier;
import org.springframework.stereotype.Service;

@Service
public class GuerrierService {

    public Guerrier create(String nom, Espece espece){
        return new Guerrier(nom, espece);
    }
}
