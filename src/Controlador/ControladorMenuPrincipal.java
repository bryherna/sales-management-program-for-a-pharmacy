/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Roles;
import Modelo.RolesDAO;
import Modelo.TipoUsuario;
import Modelo.TipoUsuarioDAO;
import Modelo.Trabajador;
import Modelo.Usuario;
import Vista.GestionEmpleados;
import Vista.GestionUsuarios;
import Vista.GestionVenta;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Bryam
 */
public class ControladorMenuPrincipal implements ActionListener {

    MenuPrincipal vista = new MenuPrincipal();
    Usuario u = null;
    Trabajador tra = null;
    Roles roles = null;

    public ControladorMenuPrincipal(MenuPrincipal vista, Usuario u, Trabajador tra) {
        this.vista = vista;
        this.u = u;
        this.tra = tra;
        this.vista.btnGestionVentas.addActionListener(this);
        this.vista.btnGestionEmpleados.addActionListener(this);
        this.vista.btnGestionUsuarios.addActionListener(this);
        inicializarDatosUsuarioVendedor();
        verificarRoles();

    }

    public void verificarRoles() {
        RolesDAO dao = new RolesDAO();
        roles = dao.getRolesTrabajador(this.tra.getIdRoles());
    }

    public void inicializarDatosUsuarioVendedor() {
        this.vista.lblNombreUsuario.setText(this.u.getNombreUsuario().toUpperCase());
        TipoUsuarioDAO tuDAO = new TipoUsuarioDAO();

        this.vista.lblTipoUsuario.setText(tuDAO.getTipoUsuarioID(u.getIdTipoUsuario()).getNombreTipoUsuario());

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        TipoUsuarioDAO dao = new TipoUsuarioDAO();
        TipoUsuario tu = null;
        tu = dao.getTipoUsuarioID(this.u.getIdTipoUsuario());

        if (ae.getSource() == vista.btnGestionVentas) {
            GestionVenta gv = new GestionVenta();
            ControladorGestionVenta controlador = new ControladorGestionVenta(gv, this.u, this.tra);
            gv.setVisible(true);
            this.vista.dispose();

        } else if (ae.getSource() == vista.btnGestionEmpleados) {

            if (roles.getNomRol().equalsIgnoreCase("VENDEDOR") || tu.getNombreTipoUsuario().equalsIgnoreCase("ADMINISTRADOR")) {

                if (tu.getNombreTipoUsuario().equalsIgnoreCase("ADMINISTRADOR")) {
                    JOptionPane.showMessageDialog(vista, "BIENVENIDO ADMINISTRADOR");
                    GestionEmpleados ge = new GestionEmpleados();
                    ControladorGestionEmpleados controladorEmple = new ControladorGestionEmpleados(ge);
                    ge.setVisible(true);
                } else if (roles.getNomRol().equalsIgnoreCase("VENDEDOR")) {
                    JOptionPane.showMessageDialog(vista, "NO TIENE ACCESO A ESTE BOTON");
                }
            }

        } else if (ae.getSource() == vista.btnGestionUsuarios) {
            if (roles.getNomRol().equalsIgnoreCase("VENDEDOR") || tu.getNombreTipoUsuario().equalsIgnoreCase("ADMINISTRADOR")) {

                if (tu.getNombreTipoUsuario().equalsIgnoreCase("ADMINISTRADOR")) {
                    JOptionPane.showMessageDialog(vista, "BIENVENIDO ADMINISTRADOR");
                    
                    GestionUsuarios gu = new GestionUsuarios();
                    ControladorGestionUsuarios controlador = new ControladorGestionUsuarios(gu);
                    gu.setVisible(true);
                    
                } else if (roles.getNomRol().equalsIgnoreCase("VENDEDOR")) {
                    JOptionPane.showMessageDialog(vista, "NO TIENE ACCESO A ESTE BOTON");
                }

            }

        }

    }

}
