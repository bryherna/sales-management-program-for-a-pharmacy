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
public class Persona {
    private int idPersona;
    private int idPais;
    private String perApellidosNombres;
    private Date perFechaNac;
    private String perDni;
    private int perEstado;
    private String perTelefono;
    private String perDireccion;
    private String perSexo;
    private String perCorreo;

    public Persona() {
    }
    
    

    public Persona(int idPersona, int idPais, String perApellidosNombres, Date perFechaNac, String perDni, int perEstado, String perTelefono, String perDireccion, String perSexo, String perCorreo) {
        this.idPersona = idPersona;
        this.idPais = idPais;
        this.perApellidosNombres = perApellidosNombres;
        this.perFechaNac = perFechaNac;
        this.perDni = perDni;
        this.perEstado = perEstado;
        this.perTelefono = perTelefono;
        this.perDireccion = perDireccion;
        this.perSexo = perSexo;
        this.perCorreo = perCorreo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getPerApellidosNombres() {
        return perApellidosNombres;
    }

    public void setPerApellidosNombres(String perApellidosNombres) {
        this.perApellidosNombres = perApellidosNombres;
    }

    public Date getPerFechaNac() {
        return perFechaNac;
    }

    public void setPerFechaNac(Date perFechaNac) {
        this.perFechaNac = perFechaNac;
    }

    public String getPerDni() {
        return perDni;
    }

    public void setPerDni(String perDni) {
        this.perDni = perDni;
    }

    public int getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(byte perEstado) {
        this.perEstado = perEstado;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(String perSexo) {
        this.perSexo = perSexo;
    }

    public String getPerCorreo() {
        return perCorreo;
    }

    public void setPerCorreo(String perCorreo) {
        this.perCorreo = perCorreo;
    }
    
    
    
}
