/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Pais;
import Modelo.PaisDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import Vista.RegistroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryam
 */
public class ControladorRegistrarCliente implements ActionListener {

    RegistroCliente vista = new RegistroCliente();

    public ControladorRegistrarCliente(RegistroCliente vista) {
        this.vista = vista;
        this.vista.btnRegistrarCliente.addActionListener(this);
        this.vista.btnCancelarCliente.addActionListener(this);
        inicializarComboBox();

    }

    public void inicializarComboBox() {
        llenarCBPais();
        llenarCBsexo();
    }

    public void llenarCBsexo() {
        String[] sexo = {"MASCULINO", "FEMENINO"};

        for (String s : sexo) {
            vista.cbSexo.addItem(s);
        }
    }

    public void llenarCBPais() {
        PaisDAO dao = new PaisDAO();
        ArrayList<Pais> listaPaises = null;

        try {
            listaPaises = dao.listadoPais();
            for (Pais p : listaPaises) {
                vista.cbPais.addItem(p);
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

    public void registrarCliente() {
        Cliente cli = new Cliente();
        Persona per = new Persona();
        PersonaDAO daoPer = new PersonaDAO();
        ClienteDAO daoCli = new ClienteDAO();
        int idPersona = -1;

        per.setPerApellidosNombres(this.vista.txtNombresCliente.getText());

        //obtener fecha
        int[] fecha = this.obtenerFecha(this.vista.txtFechaNacimientoCliente.getText());
        //AÑO - MES - DIA: debe ingresar en este formato el usuario
        LocalDate fechaNac = LocalDate.of(fecha[0], fecha[1], fecha[2]);
        per.setPerFechaNac(Date.valueOf(fechaNac));

        per.setPerDni(this.vista.txtDniCliente.getText());
        per.setPerTelefono(this.vista.txtTelefonoCliente.getText());
        per.setPerDireccion(this.vista.txtDireccionCliente.getText());

        if (vista.cbSexo.getSelectedItem() == "MASCULINO") {
            per.setPerSexo("M");
        } else if (vista.cbSexo.getSelectedItem() == "FEMENINO") {
            per.setPerSexo("F");
        }

        Pais p = (Pais) this.vista.cbPais.getSelectedItem();
        per.setIdPais(p.getId_pais());

        per.setPerCorreo(this.vista.txtCorreoCliente.getText());
        per.setPerEstado((byte) 1);

        daoPer.registrarPersona(per);
        idPersona = daoPer.getMaximoIDPersonaRegistrado();
        if (idPersona != -1) {
            cli.setIdPersona(idPersona);
            cli.setFechaInicio(Date.valueOf(LocalDate.now()));
            daoCli.registrarCliente(cli);

        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.btnRegistrarCliente) {
            registrarCliente();

        } else if (ae.getSource() == vista.btnCancelarCliente) {
            this.vista.dispose();
        }

    }

}
