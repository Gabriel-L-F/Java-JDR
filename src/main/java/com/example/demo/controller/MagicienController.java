package com.example.demo.controller;


import com.example.demo.model.Espece;
import com.example.demo.model.Guerrier;
import com.example.demo.service.GuerrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/magicien")
public class MagicienController {

    private final MagicienController magicienController;

    @Autowired
    public MagicienController(MagicienService magicienService){
        this.magicienService = magicienService;
    }

    @GetMapping
    public List<Magicien> getAllMagiciens() {
        return magicienService.getAllMagiciens();
    }

    @PostMapping
    public Magicien create(@RequestParam String nom, @RequestParam String espece){
        return magicienService.create(nom,espece);
    };

    @GetMapping("/caracteristiques")
    public Map<String,Integer> getCaracteristiques(@RequestParam int id) {
        return magicienService.getCaracteristiques(id);
    }
}
