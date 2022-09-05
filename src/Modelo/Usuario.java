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
public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private int idTipoUsuario;
    private int idTrabajador;
    private String password_usuario;
    private int estadoUsuario;

    public Usuario(int idUsuario, String nombreUsuario, int idTipoUsuario, int idTrabajador, String password_usuario, int estadoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.idTrabajador = idTrabajador;
        this.password_usuario = password_usuario;
        this.estadoUsuario = estadoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(byte estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", idTipoUsuario=" + idTipoUsuario + ", idTrabajador=" + idTrabajador + ", password_usuario=" + password_usuario + ", estadoUsuario=" + estadoUsuario + '}';
    }
    
    
    
}
