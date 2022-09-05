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
public class ModoPago {
    public int idModoPago;
    public String nomModoPago;

    public ModoPago(int idModoPago, String nomModoPago) {
        this.idModoPago = idModoPago;
        this.nomModoPago = nomModoPago;
    }

    public int getIdModoPago() {
        return idModoPago;
    }

    public void setIdModoPago(int idModoPago) {
        this.idModoPago = idModoPago;
    }

    public String getNomModoPago() {
        return nomModoPago;
    }

    public void setNomModoPago(String nomModoPago) {
        this.nomModoPago = nomModoPago;
    }

    @Override
    public String toString() {
        return nomModoPago;
    }
    
    
    
    
}
