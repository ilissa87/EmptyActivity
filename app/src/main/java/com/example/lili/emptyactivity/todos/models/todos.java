package com.example.lili.emptyactivity.todos.models;

import android.graphics.Color;

/**
 * Created by lili on 02/11/2017.
 */

public class todos {
    private String description;
    private String nom;
    private int color;
    private Etat etat;

    public todos(String nom, String Description){
        this.nom=nom;
        this.description=Description;
        this.color= Color.BLUE;
        this.etat=Etat.Active;


    }
    public boolean isActive(){
        return this.etat==Etat.Active;
    }
    public void setCompleted(){
        this.etat=Etat.Completed;
    }

    public enum Etat{
      Active,
      Completed;
  }

    public String getDescription() {
        return description;
    }

    public String getNom() {
        return nom;
    }

    public int getColor() {
        return color;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "todos{" +
                "nom='" + nom + '\'' +
                ", etat=" + etat +
                '}';
    }
}
