/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Bryam
 */
public class Cliente {
    private int idCliente;
    private int idPersona;
    private Date fechaInicio;

    public Cliente() {
    }
    
    

    public Cliente(int idCliente, int idPersona, Date fechaInicio) {
        this.idCliente = idCliente;
        this.idPersona = idPersona;
        this.fechaInicio = fechaInicio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    
    
    
    
}
