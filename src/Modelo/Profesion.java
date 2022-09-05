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
public class Profesion {
    private int idProfesion;
    private String nomProfesion;

    public Profesion(int idProfesion, String nomProfesion) {
        this.idProfesion = idProfesion;
        this.nomProfesion = nomProfesion;
    }

    public Profesion() {
    }

    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }

    public String getNomProfesion() {
        return nomProfesion;
    }

    public void setNomProfesion(String nomProfesion) {
        this.nomProfesion = nomProfesion;
    }

    @Override
    public String toString() {
        return nomProfesion;
    }
    
    
    
    
}
