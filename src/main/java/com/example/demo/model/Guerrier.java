package com.example.demo.model;
import java.util.Arrays;
import java.util.Random;

public class Guerrier implements Personnage {


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
    private Espece espece;


    public Guerrier(String nom, Espece espece) {
        this.nom = nom;
        this.espece = espece;
        this.niveau = 1;
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

}
