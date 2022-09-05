/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cargo;
import Modelo.CargoDAO;
import Modelo.Pais;
import Modelo.PaisDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import Modelo.Profesion;
import Modelo.ProfesionDAO;
import Modelo.Roles;
import Modelo.RolesDAO;
import Modelo.Trabajador;
import Modelo.TrabajadorDAO;
import Modelo.Turno;
import Modelo.TurnoDAO;
import Vista.GestionEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryam
 */
public class ControladorGestionEmpleados implements ActionListener {

    GestionEmpleados vista = null;
    DefaultTableModel modelo;
    VigilaTablaEmpleados vigila;

    public ControladorGestionEmpleados(GestionEmpleados vista) {
        this.vista = vista;
        vigila = new VigilaTablaEmpleados();
        this.vista.btnAgregarEmpleado.addActionListener(this);
        this.vista.btnModificarEmpleado.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnBuscarEmpleado.addActionListener(this);
        this.vista.btnEliminarEmpleado.addActionListener(this);
        this.vista.cbEstado.setName("cbEstado");
        this.vista.cbCargo.setName("cbCargo");
        this.vista.cbProfesion.setName("cbProfesion");
        this.vista.cbRoles.setName("cbRoles");
        this.vista.cbTurno.setName("cbTurno");
        this.vista.cbPais.setName("cbPais");
        this.vista.cbGenero.setName("cbGenero");

        llenarEstado();
        llenarCBCargo();
        llenarCBProfesion();
        llenarCBRoles();
        llenarCBTurno();
        llenarCBPais();
        llenarGenero();
        inicializarTablaTrabajadores();

        this.vista.tablaEmpleados.addMouseListener(vigila);
        vigila.setModeloVista(vista, modelo);
    }

    private void llenarGenero() {
        String[] genero = {"MASCULINO", "FEMENINO"};

        for (String g : genero) {
            this.vista.cbGenero.addItem(g);
        }
    }

    private void inicializarTablaTrabajadores() {
        TrabajadorDAO dao = new TrabajadorDAO();
        ArrayList<TrabajadorDAO> lista;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String cabecera[] = {"ID PERSONA", "ID PAIS", "APELLIDOS Y NOMBRES", "FECHA NACIMIENTO", "DNI",
            "ESTADO", "TELEFONO", "DIRECCION", "SEXO", "CORREO", "ID TRABAJADOR", "ID CARGO TRABAJADOR", "ID PROFESION",
            "ID ROLES", "ID TURNO", "FECHA INICIO", "CARGO ", "PROFESION", "ROL", "TURNO", "PAIS"};
        for (int i = 0; i < cabecera.length; i++) {
            modelo.addColumn(cabecera[i]);
        }

        try {
            lista = dao.listadoTrabajadores();
            TrabajadorDAO cd;
            if (lista.size() > 0) {
                for (int i = 0; i < lista.size(); i++) {
                    Object fila[] = new Object[cabecera.length];
                    cd = lista.get(i);
                    fila[0] = cd.getIdPersona();
                    fila[1] = cd.getIdPais();
                    fila[2] = cd.getPerApellidosNombres();
                    fila[3] = cd.getPerFechaNac();
                    fila[4] = cd.getPerDni();
                    fila[5] = cd.getPerEstado();
                    fila[6] = cd.getPerTelefono();
                    fila[7] = cd.getPerDireccion();
                    fila[8] = cd.getPerSexo();
                    fila[9] = cd.getPerCorreo();
                    fila[10] = cd.getIdTrabajador();
                    fila[11] = cd.getIdCargoTrabajador();
                    fila[12] = cd.getIdProfesion();
                    fila[13] = cd.getIdRoles();
                    fila[14] = cd.getIdTurno();
                    fila[15] = cd.getFechaInicio();
                    fila[16] = cd.getNomCargo();
                    fila[17] = cd.getNomProfesion();
                    fila[18] = cd.getNomRoles();
                    fila[19] = cd.getNomTurno();
                    fila[20] = cd.getNomPais();
                    modelo.addRow(fila);

                }
                this.vista.tablaEmpleados.setModel(modelo);
                this.vigila.setModeloVista(vista, modelo);

                this.vista.tablaEmpleados.setRowHeight(60);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private int[] obtenerFecha(String fecha_) {
        //int[0] anio
        //int[1] mes
        //int[2] dia
        int[] _fecha_ = new int[3];
        int pos1 = fecha_.indexOf("-");

        String anio = fecha_.substring(0, pos1);
        String resto = fecha_.substring(pos1 + 1, fecha_.length());

        int pos2 = resto.indexOf("-");

        String mes = resto.substring(0, pos2);

        String resto2 = resto.substring(pos2 + 1, resto.length());

        String dia = resto2;

        int anio_, mes_, dia_;
        anio_ = Integer.parseInt(anio);
        mes_ = Integer.parseInt(mes);
        dia_ = Integer.parseInt(dia);

        _fecha_[0] = anio_;
        _fecha_[1] = mes_;
        _fecha_[2] = dia_;

        return _fecha_;

    }

    private void modificarTrabajador() {
        int idPersona = this.vigila.getIdPersona();
        int idTrabajador = this.vigila.getIdTrabajador();

        if (idPersona != -1 && idTrabajador != -1) {
            TrabajadorDAO traDAO = new TrabajadorDAO();
            PersonaDAO perDAO = new PersonaDAO();
            Persona per = new Persona();
            Trabajador tra = new Trabajador();

            int[] fecha = this.obtenerFecha(this.vista.txtFechaNacimiento.getText());
            //AÑO - MES - DIA: debe ingresar en este formato el usuario
            LocalDate fechaNac = LocalDate.of(fecha[0], fecha[1], fecha[2]);

            Pais pa = (Pais) this.vista.cbPais.getSelectedItem();
            per.setIdPais(pa.getId_pais());
            per.setPerApellidosNombres(this.vista.txtApellidosNombres.getText());
            per.setPerFechaNac(Date.valueOf(fechaNac));
            per.setPerDni(this.vista.txtDniEmpleado.getText());
            per.setPerEstado((byte) 1);
            per.setPerTelefono(this.vista.txtTelefono.getText());
            per.setPerDireccion(this.vista.txtDireccion.getText());
            String genero = (String) this.vista.cbGenero.getSelectedItem();
            if (genero.equalsIgnoreCase("MASCULINO")) {
                per.setPerSexo("M");

            } else if (genero.equalsIgnoreCase("FEMENINO")) {
                per.setPerSexo("F");

            }
            per.setPerCorreo(this.vista.txtCorreoElectronico.getText());
            per.setIdPersona(idPersona);

            perDAO.modificarPersona(per);

            //-------------------------------------------------
            tra.setIdTrabajador(idTrabajador);
            tra.setIdPersona(idPersona);
            Cargo c = (Cargo) this.vista.cbCargo.getSelectedItem();
            tra.setIdCargoTrabajador(c.getIdCargoTrabajador());
            Profesion p = (Profesion) this.vista.cbProfesion.getSelectedItem();
            tra.setIdProfesion(p.getIdProfesion());
            Roles ro = (Roles) this.vista.cbRoles.getSelectedItem();
            tra.setIdRoles(ro.getIdRoles());
            Turno t = (Turno) this.vista.cbTurno.getSelectedItem();
            tra.setIdTurno(t.getIdTurno());

            fecha = this.obtenerFecha(this.vista.txtFechaInicio.getText());
            tra.setFechaInicio(Date.valueOf(LocalDate.of(fecha[0], fecha[1], fecha[2])));

            traDAO.modificarTrabajador(tra);
            limpiarCampos();
            this.inicializarTablaTrabajadores();

        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA");
        }
    }

    private void registrarTrabajador() {
        TrabajadorDAO traDAO = new TrabajadorDAO();
        PersonaDAO perDAO = new PersonaDAO();
        Persona per = new Persona();
        Trabajador tra = new Trabajador();

        int[] fecha = this.obtenerFecha(this.vista.txtFechaNacimiento.getText());
        //AÑO - MES - DIA: debe ingresar en este formato el usuario
        LocalDate fechaNac = LocalDate.of(fecha[0], fecha[1], fecha[2]);

        Pais pa = (Pais) this.vista.cbPais.getSelectedItem();
        per.setIdPais(pa.getId_pais());
        per.setPerApellidosNombres(this.vista.txtApellidosNombres.getText());
        per.setPerFechaNac(Date.valueOf(fechaNac));
        per.setPerDni(this.vista.txtDniEmpleado.getText());
        per.setPerEstado((byte) 1);
        per.setPerTelefono(this.vista.txtTelefono.getText());
        per.setPerDireccion(this.vista.txtDireccion.getText());
        String genero = (String) this.vista.cbGenero.getSelectedItem();
        if (genero.equalsIgnoreCase("MASCULINO")) {
            per.setPerSexo("M");

        } else if (genero.equalsIgnoreCase("FEMENINO")) {
            per.setPerSexo("F");

        }
        per.setPerCorreo(this.vista.txtCorreoElectronico.getText());

        perDAO.registrarPersona(per);

        int idPersona = perDAO.getMaximoIDPersonaRegistrado();

        tra.setIdPersona(idPersona);
        Cargo c = (Cargo) this.vista.cbCargo.getSelectedItem();
        tra.setIdCargoTrabajador(c.getIdCargoTrabajador());
        Profesion p = (Profesion) this.vista.cbProfesion.getSelectedItem();
        tra.setIdProfesion(p.getIdProfesion());
        Roles ro = (Roles) this.vista.cbRoles.getSelectedItem();
        tra.setIdRoles(ro.getIdRoles());
        Turno t = (Turno) this.vista.cbTurno.getSelectedItem();
        tra.setIdTurno(t.getIdTurno());
        tra.setFechaInicio(Date.valueOf(LocalDate.now()));

        traDAO.registrarTrabajadodr(tra);
        this.inicializarTablaTrabajadores();
        limpiarCampos();

    }

    private void llenarCBPais() {
        PaisDAO dao = new PaisDAO();
        ArrayList<Pais> listado;
        try {
            listado = dao.listadoPais();
            for (Pais pa : listado) {
                this.vista.cbPais.addItem(pa);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void llenarCBTurno() {
        TurnoDAO dao = new TurnoDAO();
        ArrayList<Turno> listado;
        try {
            listado = dao.listadoTurno();
            for (Turno tur : listado) {
                this.vista.cbTurno.addItem(tur);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void llenarCBRoles() {
        RolesDAO dao = new RolesDAO();
        ArrayList<Roles> listado;
        try {
            listado = dao.listadoRoles();
            for (Roles rol : listado) {
                this.vista.cbRoles.addItem(rol);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void llenarCBProfesion() {
        ProfesionDAO dao = new ProfesionDAO();
        ArrayList<Profesion> listado;
        try {
            listado = dao.listadoProfesion();
            for (Profesion pro : listado) {
                this.vista.cbProfesion.addItem(pro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void llenarCBCargo() {
        CargoDAO dao = new CargoDAO();
        ArrayList<Cargo> listado;
        try {
            listado = dao.listadoCargos();
            for (Cargo car : listado) {
                this.vista.cbCargo.addItem(car);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void llenarEstado() {
        String[] estado = {"ACTIVO", "INACTIVO"};
        for (String g : estado) {
            this.vista.cbEstado.addItem(g);
        }
    }

    private void limpiarCampos() {
        this.vista.txtDniEmpleado.setText("");
        this.vista.txtApellidosNombres.setText("");
        this.vista.txtFechaNacimiento.setText("");
        this.vista.txtDireccion.setText("");
        this.vista.txtTelefono.setText("");
        this.vista.txtCorreoElectronico.setText("");
        this.vista.cbEstado.setSelectedIndex(0);
        this.vista.txtBuscarEmpleado.setText("");
        this.vista.cbCargo.setSelectedIndex(0);
        this.vista.cbProfesion.setSelectedIndex(0);
        this.vista.cbRoles.setSelectedIndex(0);
        this.vista.cbTurno.setSelectedIndex(0);
        this.vista.cbPais.setSelectedIndex(0);
        this.vista.cbGenero.setSelectedIndex(0);

    }

    class VigilaTablaEmpleados extends MouseAdapter {

        GestionEmpleados vista;
        DefaultTableModel modelo;
        public int idTrabajador = -1;
        public int idPersona = -1;

        public void setModeloVista(GestionEmpleados vista, DefaultTableModel modelo) {
            this.vista = vista;
            this.modelo = modelo;

        }

        public void setVista(GestionEmpleados vista) {
            this.vista = vista;
        }

        public void setModelo(DefaultTableModel modelo) {
            this.modelo = modelo;
        }

        public int getPosComboPos(JComboBox cb, String valor, int estado) {
            int pos = -1;

            if (cb != null) {
                switch (cb.getName()) {
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
                    case "cbCargo":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            Cargo car = (Cargo) cb.getItemAt(i);
                            if (car.getNomCargoTrabajador().equalsIgnoreCase(valor)) {
                                pos = i;
                            }
                        }
                        break;
                    case "cbProfesion":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            Profesion pro = (Profesion) cb.getItemAt(i);
                            if (pro.getNomProfesion().equalsIgnoreCase(valor)) {
                                pos = i;
                            }
                        }
                        break;
                    case "cbRoles":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            Roles rol = (Roles) cb.getItemAt(i);
                            if (rol.getNomRol().equalsIgnoreCase(valor)) {
                                pos = i;
                            }
                        }
                        break;
                    case "cbTurno":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            Turno tur = (Turno) cb.getItemAt(i);
                            if (tur.getNombreTurno().equalsIgnoreCase(valor)) {
                                pos = i;
                            }
                        }
                        break;
                    case "cbPais":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            Pais pa = (Pais) cb.getItemAt(i);
                            if (pa.getNom_pais().equalsIgnoreCase(valor)) {
                                pos = i;
                            }
                        }
                        break;
                    case "cbGenero":
                        for (int i = 0; i < cb.getItemCount(); i++) {
                            String g = ((String) cb.getItemAt(i));
                            if (g.charAt(0) == valor.charAt(0)) {
                                pos = i;
                            }
                        }
                        break;

                }

            }
            return pos;
        }

        public int getIdTrabajador() {
            return idTrabajador;
        }

        public int getIdPersona() {
            return idPersona;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int fila = this.vista.tablaEmpleados.getSelectedRow();
            this.idPersona = (Integer) modelo.getValueAt(fila, 0);
            this.idTrabajador = (Integer) modelo.getValueAt(fila, 10);

            this.vista.txtDniEmpleado.setText(modelo.getValueAt(fila, 4).toString());
            this.vista.txtApellidosNombres.setText(modelo.getValueAt(fila, 2).toString());
            this.vista.txtFechaNacimiento.setText(modelo.getValueAt(fila, 3).toString());
            this.vista.txtDireccion.setText(modelo.getValueAt(fila, 7).toString());
            this.vista.txtTelefono.setText(modelo.getValueAt(fila, 6).toString());
            this.vista.txtCorreoElectronico.setText(modelo.getValueAt(fila, 9).toString());

            this.vista.txtFechaInicio.setText(modelo.getValueAt(fila, 15).toString());

            int posEstado = this.getPosComboPos(this.vista.cbEstado, "", Integer.parseInt(modelo.getValueAt(fila, 5).toString()));
            this.vista.cbEstado.setSelectedIndex(posEstado);

            int posCargo = this.getPosComboPos(this.vista.cbCargo, modelo.getValueAt(fila, 16).toString(), -1);
            this.vista.cbCargo.setSelectedIndex(posCargo);

            int posProfesion = this.getPosComboPos(this.vista.cbProfesion, modelo.getValueAt(fila, 17).toString(), -1);
            this.vista.cbProfesion.setSelectedIndex(posProfesion);

            int posRoles = this.getPosComboPos(this.vista.cbRoles, modelo.getValueAt(fila, 18).toString(), -1);
            this.vista.cbRoles.setSelectedIndex(posRoles);

            int posTurno = this.getPosComboPos(this.vista.cbTurno, modelo.getValueAt(fila, 19).toString(), -1);
            this.vista.cbTurno.setSelectedIndex(posTurno);

            int posPais = this.getPosComboPos(this.vista.cbPais, modelo.getValueAt(fila, 20).toString(), -1);
            this.vista.cbPais.setSelectedIndex(posPais);

            int posSexo = this.getPosComboPos(this.vista.cbGenero, modelo.getValueAt(fila, 8).toString(), -1);
            this.vista.cbGenero.setSelectedIndex(posSexo);

        }
    }

    private void buscarEmpleado() {
        String dni = this.vista.txtBuscarEmpleado.getText();
        TrabajadorDAO dao = new TrabajadorDAO();
        TrabajadorDAO aux = null;
        aux = dao.getTrabajadorDNI(dni);
        if (aux != null) {
            JOptionPane.showMessageDialog(null, "SE ENCONTRO EMPLEADO COMPLETANDO CAMPOS");
            this.vista.txtDniEmpleado.setText(aux.getPerDni());
            this.vista.txtApellidosNombres.setText(aux.getPerApellidosNombres());
            this.vista.txtFechaNacimiento.setText(aux.getPerFechaNac().toString());
            this.vista.txtDireccion.setText(aux.getPerDireccion());
            this.vista.txtTelefono.setText(aux.getPerTelefono());
            this.vista.txtCorreoElectronico.setText(aux.getPerCorreo());
            this.vista.txtFechaInicio.setText(aux.getFechaInicio().toString());
            if (aux.getPerEstado() == 1) {
                this.vista.cbEstado.setSelectedIndex(0);
            } else {
                this.vista.cbEstado.setSelectedIndex(1);
            }

            int posCargo = this.vigila.getPosComboPos(this.vista.cbCargo, aux.getNomCargo(), -1);
            this.vista.cbCargo.setSelectedIndex(posCargo);

            int posProfesion = this.vigila.getPosComboPos(this.vista.cbProfesion, aux.getNomProfesion(), -1);
            this.vista.cbProfesion.setSelectedIndex(posProfesion);

            int posRoles = this.vigila.getPosComboPos(this.vista.cbRoles, aux.getNomRoles(), -1);
            this.vista.cbRoles.setSelectedIndex(posRoles);

            int posTurno = this.vigila.getPosComboPos(this.vista.cbTurno, aux.getNomTurno(), -1);
            this.vista.cbTurno.setSelectedIndex(posTurno);

            int posPais = this.vigila.getPosComboPos(this.vista.cbPais, aux.getNomPais(), -1);
            this.vista.cbPais.setSelectedIndex(posPais);

            int posSexo = this.vigila.getPosComboPos(this.vista.cbGenero, aux.getPerSexo(), -1);
            this.vista.cbGenero.setSelectedIndex(posSexo);

        } else {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EMPLEADO");
        }
    }

    private void eliminarTrabajador() {
        int idTrabajador = this.vigila.getIdTrabajador();
        TrabajadorDAO traDAO = new TrabajadorDAO();
        if (idTrabajador != -1) {
            traDAO.eliminarTrabajador(idTrabajador);

            this.inicializarTablaTrabajadores();
            limpiarCampos();

        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.vista.btnCancelar) {
            this.vista.dispose();

        }
        if (ae.getSource() == this.vista.btnAgregarEmpleado) {
            registrarTrabajador();
        }
        if (ae.getSource() == this.vista.btnBuscarEmpleado) {
            buscarEmpleado();
        }
        if (ae.getSource() == this.vista.btnModificarEmpleado) {
            modificarTrabajador();
        }
        if (ae.getSource() == this.vista.btnEliminarEmpleado) {
            eliminarTrabajador();
        }
    }

}
