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
public class Cargo {
    private int idCargoTrabajador;
    private String nomCargoTrabajador;

    public Cargo(int idCargoTrabajador, String nomCargoTrabajador) {
        this.idCargoTrabajador = idCargoTrabajador;
        this.nomCargoTrabajador = nomCargoTrabajador;
    }

    public Cargo() {
    }

    public int getIdCargoTrabajador() {
        return idCargoTrabajador;
    }

    public void setIdCargoTrabajador(int idCargoTrabajador) {
        this.idCargoTrabajador = idCargoTrabajador;
    }

    public String getNomCargoTrabajador() {
        return nomCargoTrabajador;
    }

    public void setNomCargoTrabajador(String nomCargoTrabajador) {
        this.nomCargoTrabajador = nomCargoTrabajador;
    }
    
    

    @Override
    public String toString() {
        return nomCargoTrabajador;
    }
    
    
    
    
}
