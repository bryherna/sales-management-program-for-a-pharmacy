/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bryam
 */
public class Pais {
     private int id_pais;
    private String Nom_pais;

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getNom_pais() {
        return Nom_pais;
    }

    public void setNom_pais(String Nom_pais) {
        this.Nom_pais = Nom_pais;
    }

    public Pais(int id_pais, String Nom_pais) {
        this.id_pais = id_pais;
        this.Nom_pais = Nom_pais;
    }

    @Override
    public String toString() {
        return Nom_pais;
    }
    
}
