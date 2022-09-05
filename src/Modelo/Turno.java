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
public class Turno {
    
    private int idTurno;
    private String nombreTurno;

    public Turno(int idTurno, String nombreTurno) {
        this.idTurno = idTurno;
        this.nombreTurno = nombreTurno;
    }

    public Turno() {
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombreTurno() {
        return nombreTurno;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
    }

    @Override
    public String toString() {
        return nombreTurno;
    }
    
    
    
}
