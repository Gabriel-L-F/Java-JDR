package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
public class Magicien implements Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int niveau;
    private int pointsDeVieMax;
    private int pointsDeVieActuels;
    private int force;
    private int constitution;
    private int sagesse;
    private int inteligence;
    private int dexterite;
    private int charisme;
    private String espece;


    public Magicien() {}

    public Magicien(String nom, String espece) {
        this.nom = nom;
        this.espece = espece;
        this.niveau = 1;
        this.pointsDeVieMax = setPvMax();
        this.pointsDeVieActuels = this.pointsDeVieMax;
        this.force = tirerCaracteristiqueAleatoire();
        this.constitution = tirerCaracteristiqueAleatoire();
        this.charisme = tirerCaracteristiqueAleatoire();
        this.dexterite =tirerCaracteristiqueAleatoire();
        this.inteligence = tirerCaracteristiqueAleatoire();
        this.sagesse = tirerCaracteristiqueAleatoire();
    }

    @Override
    public boolean estVivant() {
        return this.pointsDeVieActuels > 0;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public int getClassArmure() {
        return (10 + getModificateur(this.constitution));
    }

    @Override
    public int getModificateur(int caracteristique) {
        return (caracteristique - 10) / 2;
    };

    @Override
    public Map<String,Integer> getCaracteristiques() {
        Map stats = new HashMap<>();
        stats.put("force", this.force);
        stats.put("dexterite", this.dexterite);
        stats.put("constitution", this.constitution);
        stats.put("inteligence", this.inteligence);
        stats.put("sagesse", this.sagesse);
        stats.put("charisme", this.charisme);
        return stats;
    }

    public int tirerCaracteristiqueAleatoire() {
        Random random = new Random();
        int[] des = new int[4];
        for (int i = 0; i < 4; i++) {
            des[i] = random.nextInt(6) + 1;
        }
        Arrays.sort(des);
        int somme = des[1] + des[2] + des[3];
        return somme;
    }

    public int setPvMax(){
        return (10+getModificateur(this.constitution));
    }

}
