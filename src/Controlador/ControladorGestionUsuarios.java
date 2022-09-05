/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TipoUsuario;
import Modelo.TipoUsuarioDAO;
import Modelo.TrabajadorDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.GestionUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryam
 */
public class ControladorGestionUsuarios implements ActionListener {

    GestionUsuarios vista = null;
    DefaultTableModel modelo;
    VigilaTablaUsuarios vigila;
    UsuarioDAO dao = new UsuarioDAO();

    public ControladorGestionUsuarios(GestionUsuarios vista) {
        this.vista = vista;
        vigila = new VigilaTablaUsuarios();
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnAgregarUsuario.addActionListener(this);
        this.vista.btnModificarUsuario.addActionListener(this);
        this.vista.btnEliminarUsuario.addActionListener(this);
        this.vista.cbDniTrabajador.setName("cbDniTrabajador");
        this.vista.cbTipoUsuario.setName("cbTipoUsuario");
        this.vista.cbEstado.setName("cbEstado");
        inicializarTablaVenta();
        llenarCBTipoUsuario();
        llenarCBTrabajador();
        llenarEstado();
        this.vista.tablaUsuarios.addMouseListener(vigila);
        vigila.setModeloVista(vista, modelo);

    }

    private void llenarEstado() {
        String[] estado = {"ACTIVO", "INACTIVO"};
        for (String g : estado) {
            this.vista.cbEstado.addItem(g);
        }
    }

    public void llenarCBTrabajador() {
        TrabajadorDAO dao = new TrabajadorDAO();
        ArrayList<TrabajadorDAO> listado;
        try {
            listado = dao.listadoTrabajadores();
            for (TrabajadorDAO tra : listado) {
                this.vista.cbDniTrabajador.addItem(tra);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void llenarCBTipoUsuario() {
        TipoUsuarioDAO dao = new TipoUsuarioDAO();
        ArrayList<TipoUsuario> listado;

        try {
            listado = dao.listadoTipoUsuario();
            for (TipoUsuario tp : listado) {
                this.vista.cbTipoUsuario.addItem(tp);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void inicializarTablaVenta() {
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<UsuarioDAO> lista;

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String cabecera[] = {"ID USUARIO", "NOMBRE USUARIO", " TIPO USUARIO", "TRABAJADOR", "ESTADO"};
        for (int i = 0; i < cabecera.length; i++) {
            modelo.addColumn(cabecera[i]);
        }

        try {
            lista = dao.listadoUsuarios();
            UsuarioDAO cd;
            if (lista.size() > 0) {
                for (int i = 0; i < lista.size(); i++) {
                    Object fila[] = new Object[cabecera.length];
                    cd = lista.get(i);
                    fila[0] = cd.getIdUsuario();
                    fila[1] = cd.getNombreUsuario();
                    fila[2] = cd.getNombreTipoUsuario();
                    fila[3] = cd.getPerApellidosNombres();
                    fila[4] = cd.getEstadoUsuario();

                    modelo.addRow(fila);

                }
                this.vista.tablaUsuarios.setModel(modelo);
                this.vista.tablaUsuarios.setRowHeight(60);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class VigilaTablaUsuarios extends MouseAdapter {

        GestionUsuarios vista;
        DefaultTableModel modelo;

        public int idUsuario = -1;

        public void setModeloVista(GestionUsuarios vista, DefaultTableModel modelo) {
            this.vista = vista;
            this.modelo = modelo;
        }

        public int getIdUsuario() {
            return idUsuario;

        }

        public int getPosComboPos(JComboBox cb, String valor, int estado) {
            int pos = -1;
            /*
            this.vista.cbDniTrabajador.setName("cbDniTrabajador");
        this.vista.cbTipoUsuario.setName("cbTipoUsuario");
             */
            if (cb != null) {
                switch (cb.getName()) {
                    case "cbDniTrabajador":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            TrabajadorDAO tradao = (TrabajadorDAO) cb.getItemAt(i);

                            if (tradao.getPerApellidosNombres().equalsIgnoreCase(valor)) {
                                pos = i;
                            }
                        }

                        break;
                    case "cbTipoUsuario":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            TipoUsuario tu = (TipoUsuario) cb.getItemAt(i);
                            if (tu.getNombreTipoUsuario().equalsIgnoreCase(valor)) {
                                pos = i;
                            }
                        }

                        break;

                    case "cbEstado":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            String es = (String) cb.getItemAt(i);
                            if (es.equalsIgnoreCase("ACTIVO") && estado == 1) {
                                pos = i;
                            } else if (es.equalsIgnoreCase("INACTIVO") && estado == 0) {
                                pos = i;
                            }

                        }

                        break;
                }

            }

            return pos;

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            int fila = this.vista.tablaUsuarios.getSelectedRow();
            this.idUsuario = (Integer) modelo.getValueAt(fila, 0);
            this.vista.txtNombreUsuario.setText(modelo.getValueAt(fila, 1).toString());

            int posTu = this.getPosComboPos(this.vista.cbTipoUsuario, modelo.getValueAt(fila, 2).toString(), (byte) -1);
            this.vista.cbTipoUsuario.setSelectedIndex(posTu);

            int posTra = this.getPosComboPos(this.vista.cbDniTrabajador, modelo.getValueAt(fila, 3).toString(), (byte) -1);

            this.vista.cbDniTrabajador.setSelectedIndex(posTra);

            int posEstado = this.getPosComboPos(this.vista.cbEstado, "", Integer.parseInt(modelo.getValueAt(fila, 4).toString()));
            this.vista.cbEstado.setSelectedIndex(posEstado);

        }

    }

    public void agregarUsuario() {

        Usuario usu = new Usuario();

        if ((this.vista.txtNombreUsuario.getText() != " ") && (this.vista.txtContraseniaUsuario.getText() != " ")) {
            usu.setEstadoUsuario((byte) 1);
            TipoUsuario tu = (TipoUsuario) this.vista.cbTipoUsuario.getSelectedItem();
            usu.setIdTipoUsuario(tu.getIdTipoUsuario());

            TrabajadorDAO td = (TrabajadorDAO) this.vista.cbDniTrabajador.getSelectedItem();
            usu.setIdTrabajador(td.getIdTrabajador());
            usu.setNombreUsuario(this.vista.txtNombreUsuario.getText());
            usu.setPassword_usuario(this.vista.txtContraseniaUsuario.getText());

            dao.registrarUsuario(usu);
            this.inicializarTablaVenta();
             limpiarCampos();
        }

    }
    
    private void limpiarCampos(){
        this.vista.txtNombreUsuario.setText("");
        this.vista.txtContraseniaUsuario.setText("");
        this.vista.cbDniTrabajador.setSelectedIndex(0);
        this.vista.cbEstado.setSelectedIndex(0);
        this.vista.cbTipoUsuario.setSelectedIndex(0);
    }

    private void eliminarUsuario() {
        int idUsuario = this.vigila.getIdUsuario();

        if (idUsuario != -1) {

            dao.eliminarUsuario(idUsuario);
            
            this.inicializarTablaVenta();
            limpiarCampos();

        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA");
        }
    }

    private void modificarUsuario() {

        int idUsuario = this.vigila.getIdUsuario();
        Usuario usu = new Usuario();

        if (idUsuario != -1) {
            if ((this.vista.txtNombreUsuario.getText() != " ") && (this.vista.txtContraseniaUsuario.getText() != " ")) {
                TipoUsuario tu = (TipoUsuario) this.vista.cbTipoUsuario.getSelectedItem();
                usu.setIdTipoUsuario(tu.getIdTipoUsuario());

                TrabajadorDAO td = (TrabajadorDAO) this.vista.cbDniTrabajador.getSelectedItem();
                usu.setIdTrabajador(td.getIdTrabajador());
                usu.setNombreUsuario(this.vista.txtNombreUsuario.getText());
                usu.setPassword_usuario(this.vista.txtContraseniaUsuario.getText());
                usu.setIdUsuario(idUsuario);

                String estado = (String) this.vista.cbEstado.getSelectedItem();
                if (estado.equalsIgnoreCase("ACTIVO")) {
                    usu.setEstadoUsuario((byte) 1);

                } else if (estado.equalsIgnoreCase("INACTIVO")) {
                    dao.setEstadoUsuario((byte) 0);
                }

                dao.modificarUsuario(usu);
                this.inicializarTablaVenta();
                 limpiarCampos();

            } else {
                JOptionPane.showMessageDialog(null, "INGRESE USUARIO Y CONTRASEÑA");
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA");
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vista.btnCancelar) {
            this.vista.dispose();

        }
        if (ae.getSource() == vista.btnAgregarUsuario) {
            agregarUsuario();
        }
        if (ae.getSource() == vista.btnModificarUsuario) {

            modificarUsuario();

        }
        if (ae.getSource() == vista.btnEliminarUsuario) {
            eliminarUsuario();

        }

    }

}
