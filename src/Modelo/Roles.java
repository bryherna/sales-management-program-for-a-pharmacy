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
public class Roles {
    private int idRoles;
    private String nomRol;

    public Roles(int idRoles, String nomRol) {
        this.idRoles = idRoles;
        this.nomRol = nomRol;
    }

    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    @Override
    public String toString() {
        return nomRol;
    }
    
    
    
}
