package com.example.demo.controller;


import com.example.demo.model.Espece;
import com.example.demo.model.Guerrier;
import com.example.demo.service.GuerrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guerrier")
public class GuerrierController {

    private final GuerrierService guerrierService;

    @Autowired
    public GuerrierController(GuerrierService guerrierService){
        this.guerrierService = guerrierService;
    }
    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

    @PostMapping
    public Guerrier create(@RequestParam String nom, @RequestParam Espece espece){
        return guerrierService.create(nom,espece);
    };
}
