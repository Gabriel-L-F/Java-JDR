package com.example.demo.model;

public interface Personnage {

    boolean estVivant();
    String getNom();
    int getClassArmure();
    int getModificateur(int caracteristique);

}