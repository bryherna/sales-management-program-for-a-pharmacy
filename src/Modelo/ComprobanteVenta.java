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
public class ComprobanteVenta {
    public int idComprobanteVenta;
    public String nomComprobanteVenta;

    public ComprobanteVenta(int idComprobanteVenta, String nomComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
        this.nomComprobanteVenta = nomComprobanteVenta;
    }

    public int getIdComprobanteVenta() {
        return idComprobanteVenta;
    }

    public void setIdComprobanteVenta(int idComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
    }

    public String getNomComprobanteVenta() {
        return nomComprobanteVenta;
    }

    public void setNomComprobanteVenta(String nomComprobanteVenta) {
        this.nomComprobanteVenta = nomComprobanteVenta;
    }

    @Override
    public String toString() {
        return nomComprobanteVenta;
    }
    
    
    
    
}
