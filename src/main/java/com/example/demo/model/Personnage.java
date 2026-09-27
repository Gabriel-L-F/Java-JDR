package com.example.demo.model;

import java.util.Map;

public interface Personnage {

    boolean estVivant();
    String getNom();
    int getClassArmure();
    int getModificateur(int caracteristique);
    Map getCaracteristiques();

}