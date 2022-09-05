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
public class Trabajador {
    private int idTrabajador;
    private int idPersona;
    private int idCargoTrabajador;
    private int idProfesion;
    private int idRoles;
    private int idTurno;
    private Date fechaInicio;

    public Trabajador() {
    }

    public Trabajador(int idTrabajador, int idPersona, int idCargoTrabajador, int idProfesion, int idRoles, int idTurno, Date fechaInicio) {
        this.idTrabajador = idTrabajador;
        this.idPersona = idPersona;
        this.idCargoTrabajador = idCargoTrabajador;
        this.idProfesion = idProfesion;
        this.idRoles = idRoles;
        this.idTurno = idTurno;
        this.fechaInicio = fechaInicio;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdCargoTrabajador() {
        return idCargoTrabajador;
    }

    public void setIdCargoTrabajador(int idCargoTrabajador) {
        this.idCargoTrabajador = idCargoTrabajador;
    }

    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }

    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    
    
}
