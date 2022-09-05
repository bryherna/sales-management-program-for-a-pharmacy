/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import Modelo.TipoUsuario;
import Modelo.TipoUsuarioDAO;
import Modelo.Trabajador;
import Modelo.TrabajadorDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.Login;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryam
 */
public class ControladorLogin implements ActionListener {

    UsuarioDAO udao = new UsuarioDAO();
    PersonaDAO pedao = new PersonaDAO();
    TipoUsuarioDAO tudao = new TipoUsuarioDAO();
    Persona p = null;
    Usuario u = null;
    TipoUsuario tp = null;
    Trabajador tra = null;
    Login vista = new Login();

    public ControladorLogin(Login l) {
        this.vista = l;
        this.vista.btnIngresar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
        this.vista.btnVerificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        char[] pass = this.vista.txtContrasenia.getPassword();
        String contrasenia = String.valueOf(pass);

        if (ae.getSource() == vista.btnVerificar) {
            if (this.vista.txtUsuario.getText().isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "INGRESE USUARIO Y CONTRASEÑA PARA VERIFICAR");
            } else {
                verificarUsuario();
            }

        } else if (ae.getSource() == vista.btnIngresar) {

            if (this.vista.txtUsuario.getText().isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "INGRESE USUARIO - CONTRASEÑA Y PRESIONE VERIFICAR");
            } else {
                if (this.vista.txtIdentificacion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(vista, " PRESIONE VERIFICAR");
                } else {
                    ingresarMenuPrincipal();
                }

            }

        } else if (ae.getSource() == vista.btnSalir) {

            vista.dispose();
        }

    }

    private void ingresarMenuPrincipal() {
        TrabajadorDAO tradao = new TrabajadorDAO();
        MenuPrincipal mp = new MenuPrincipal();
        this.tra = tradao.getTrabajadorID(this.u.getIdTrabajador());
        ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(mp, this.u, this.tra);
        mp.setVisible(true);
        this.vista.dispose();

    }

    private void verificarUsuario() {
        char[] pass = this.vista.txtContrasenia.getPassword();
        String contrasenia = String.valueOf(pass);
        if (!(vista.txtUsuario.getText().isEmpty() && contrasenia.isEmpty())) {
            this.u = udao.logearse(vista.txtUsuario.getText(), contrasenia);

            if (this.u != null) {
                this.p = this.pedao.getPersonaIDTrabajador(this.u.getIdTrabajador());
                vista.txtIdentificacion.setText(this.p.getPerApellidosNombres().toUpperCase());
                this.tp = this.tudao.getTipoUsuarioID(this.u.getIdTipoUsuario());
                if (tp != null) {
                    vista.txtTipoDeAcceso.setText(tp.getNombreTipoUsuario());
                }

            }

        } else {
            JOptionPane.showMessageDialog(vista, "INGRESE SU USUARIO Y CONTRASEÑIA");
        }
    }

}
