/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClienteDAO;
import Modelo.ComprobanteVenta;
import Modelo.ComprobanteVentaDAO;
import Modelo.DetalleVenta;
import Modelo.DetalleVentaDAO;
import Modelo.ModoPago;
import Modelo.ModoPagoDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import Modelo.ProductoDAO;
import Modelo.Trabajador;
import Modelo.Usuario;
import Modelo.Venta;
import Modelo.VentaDAO;
import Vista.AgregarProductoVenta;
import Vista.GestionVenta;
import Vista.MenuPrincipal;
import Vista.RegistroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryam
 */
public class ControladorGestionVenta implements ActionListener {

    GestionVenta vista = new GestionVenta();
    Usuario usuario = null;
    Trabajador trabajador = null;
    DefaultTableModel modelo;
    Persona persona = null;
    ClienteDAO clidao = null;
    public int idProducto = -1;
    public int cantidad = -1;
    public double importe = 0.0D;
    public int idVenta = -1;

    VigilaVentanaProductoVenta vigilaVentana = new VigilaVentanaProductoVenta();
    int filas = 0;

    public ControladorGestionVenta(GestionVenta vista, Usuario u, Trabajador tra) {
        this.vista = vista;
        this.usuario = u;
        this.trabajador = tra;
        inicializarDatosVendedor();
        this.vista.btnNuevoCliente.addActionListener(this);
        this.vista.btnAgregarProductoVenta.addActionListener(this);
        this.vista.btnEliminarProductoVenta.addActionListener(this);
        this.vista.btnBuscarClienteDNI.addActionListener(this);
        this.vista.btnMenuPrincipal.addActionListener(this);
        this.vista.btnGuardarVenta.addActionListener(this);
        this.vista.btnRegistrarPago.addActionListener(this);
        this.vista.btnTotalPagar.addActionListener(this);
        this.vista.btnCalcularMonto.addActionListener(this);
        inicializarTablaVenta();
        inicializarCBComprobanteVenta();
        inicializarModoPago();

    }

    public void inicializarCBComprobanteVenta() {
        ComprobanteVentaDAO dao = new ComprobanteVentaDAO();
        ArrayList<ComprobanteVenta> lista;
        try {
            lista = dao.listadoComprobanteVenta();
            for (ComprobanteVenta cv : lista) {
                this.vista.cbComprobanteVenta.addItem(cv);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void inicializarModoPago() {
        ModoPagoDAO dao = new ModoPagoDAO();
        ArrayList<ModoPago> lista;

        try {
            lista = dao.listadoModoPago();
            for (ModoPago mp : lista) {
                this.vista.cbTipoPago.addItem(mp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void inicializarDatosVendedor() {
        vista.lblUsuario.setText(usuario.getNombreUsuario().toUpperCase());
        PersonaDAO dao = new PersonaDAO();

        this.persona = dao.getPersonaIDTrabajador(trabajador.getIdTrabajador());
        vista.lblDniVendedorInicio.setText(this.persona.getPerDni());
        vista.lblDNIVendedor.setText(this.persona.getPerDni());
        vista.lblNombresVendedor.setText(this.persona.getPerApellidosNombres().toUpperCase());
        vista.lblDireccionVendedor.setText(this.persona.getPerDireccion().toUpperCase());

    }

    public void iniciarInterfazRegistrarCliente() {
        RegistroCliente rc = new RegistroCliente();
        ControladorRegistrarCliente controlador = new ControladorRegistrarCliente(rc);
        rc.setVisible(true);

    }

    public void iniciarInterfazAgregarProductoVenta() {
        AgregarProductoVenta aProducto = new AgregarProductoVenta();
        ControladorAgregarProductoVenta controlador = new ControladorAgregarProductoVenta(aProducto);
        aProducto.addWindowListener(vigilaVentana);
        vigilaVentana.setControlador(controlador);
        vigilaVentana.setVista(vista);
        aProducto.setVisible(true);

    }

    public void inicializarTablaVenta() {
        modelo = (DefaultTableModel) this.vista.tablaVenta.getModel();
        String cabecera[] = {"ID PRODUCTO", "ID PRESENTACION", "ID LABORATORIO", "NOMBRE PRODUCTO",
            "PRECIO VENTA", "DESCRIPCION", "CANTIDAD COMPRAR", "IMPORTE", "CADUCIDAD", "LOTE", "NOMBRE PRESENTACION", "NOMBRE LABORATORIO"};
        for (int i = 0; i < cabecera.length; i++) {
            modelo.addColumn(cabecera[i]);
        }
        this.vista.tablaVenta.setRowHeight(60);
    }

    private void sumarTotalPrecioProductos() {
        modelo = (DefaultTableModel) this.vista.tablaVenta.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            this.importe = this.importe + Double.parseDouble(modelo.getValueAt(i, 7).toString());
        }
        this.vista.lblSubtotal.setText(String.valueOf(this.importe));
        this.vista.lblTotal.setText(String.valueOf(this.importe));
    }

    private void guardarVentaDetalle() {

        modelo = (DefaultTableModel) this.vista.tablaVenta.getModel();
        DetalleVentaDAO dao = new DetalleVentaDAO();
        DetalleVenta dv = new DetalleVenta();

        for (int i = 0; i < modelo.getRowCount(); i++) {

            dv.setIdProducto((Integer) modelo.getValueAt(i, 0));
            dv.setIdVenta(this.idVenta);
            dv.setPrecioProducto(BigDecimal.valueOf(Double.parseDouble(modelo.getValueAt(i, 4).toString())));
            dv.setCantidad((Integer) modelo.getValueAt(i, 6));

            dao.registrarDetalleVenta(dv);

        }

    }
    
    private void calcularMonto(){
        if(!this.vista.txtMontoRecibido.getText().isEmpty()){
            double recibido = Double.parseDouble(this.vista.txtMontoRecibido.getText());
            double vuelto = recibido -this.importe;
            this.vista.txtVuelto.setText(String.valueOf(vuelto));
        }else{
            JOptionPane.showMessageDialog(vista, "DEBE INGRESAR EL MONTO RECIBIDO");
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vista.btnNuevoCliente) {
            iniciarInterfazRegistrarCliente();
        } else if (ae.getSource() == vista.btnAgregarProductoVenta) {
            iniciarInterfazAgregarProductoVenta();
        } else if (ae.getSource() == vista.btnEliminarProductoVenta) {
            modelo = (DefaultTableModel) this.vista.tablaVenta.getModel();
            modelo.removeRow(this.vista.tablaVenta.getSelectedRow());
            filas--;
        } else if (ae.getSource() == vista.btnBuscarClienteDNI) {
            buscarClienteAgregarVenta();
        } else if (ae.getSource() == vista.btnMenuPrincipal) {
            iniciarInterfazMenuPrincipal();

        } else if (ae.getSource() == vista.btnGuardarVenta) {

        } else if (ae.getSource() == vista.btnRegistrarPago) {
            guardarVenta();
            guardarVentaDetalle();
        } else if (ae.getSource() == vista.btnTotalPagar) {
            sumarTotalPrecioProductos();
        }else if(ae.getSource() == vista.btnCalcularMonto){
            calcularMonto();
        }

    }

    private void guardarVenta() {
        VentaDAO dao = new VentaDAO();
        if (this.clidao != null && this.trabajador != null) {
            Venta venta = new Venta();
            venta.setIdCliente(this.clidao.getIdCliente());
            venta.setIdTrabajador(this.trabajador.getIdTrabajador());
            ComprobanteVenta cv = (ComprobanteVenta) this.vista.cbComprobanteVenta.getSelectedItem();

            venta.setIdComprobanteVenta(cv.getIdComprobanteVenta());

            venta.setFechaVenta(Instant.now());

            ModoPago mp = (ModoPago) this.vista.cbTipoPago.getSelectedItem();
            venta.setIdModoPago(mp.getIdModoPago());

            dao.registrarVenta(venta);
            this.idVenta = dao.getMaximoIDVentaRegistrado();

        } else {
            if (this.clidao == null) {
                JOptionPane.showMessageDialog(vista, "DEBE INGRESAR UN CLIENTE PARA LA VENTA");
            }
            if (this.trabajador == null) {
                JOptionPane.showMessageDialog(vista, "TRABAJADOR NO INGRESADO-ERROR");
            }
        }

    }

    private void iniciarInterfazMenuPrincipal() {
        MenuPrincipal mp = new MenuPrincipal();
        ControladorMenuPrincipal cmp = new ControladorMenuPrincipal(mp, this.usuario, this.trabajador);
        mp.setVisible(true);
        this.vista.dispose();

    }

    private void buscarClienteAgregarVenta() {
        if (!this.vista.txtBuscarClienteDNI.getText().isEmpty()) {
            ClienteDAO clidao = new ClienteDAO();
            this.clidao = clidao.getClienteDAOPorDni(this.vista.txtBuscarClienteDNI.getText());
            if (this.clidao != null) {
                JOptionPane.showMessageDialog(vista, "CLIENTE ENCONTRADO AÑADIENDO...");
                this.vista.lblDNICliente.setText(this.clidao.getPerDni());
                this.vista.lblNombresCliente.setText(this.clidao.getPerApellidosNombres());
                this.vista.lblDireccionCliente.setText(this.clidao.getPerDireccion());
            } else {
                JOptionPane.showMessageDialog(vista, "CLIENTE NO EXISTE, REGISTRELO");
                this.vista.txtBuscarClienteDNI.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "INGRESE EL DNI DEL CLIENTE PARA BUSCAR");
        }

    }

    class VigilaVentanaProductoVenta extends WindowAdapter {

        ControladorAgregarProductoVenta controlador;
        public int idProducto = -1;
        public int cantidad = -1;
        public double importe = 0.0D;
        GestionVenta vista;

        public int getIdProducto() {
            return idProducto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getImporte() {
            return importe;
        }

        public void setControlador(ControladorAgregarProductoVenta controlador) {
            this.controlador = controlador;

        }

        public void setVista(GestionVenta vista) {
            this.vista = vista;
        }

        public void windowClosing(WindowEvent e) {
            this.idProducto = controlador.getIdProducto();
            this.cantidad = controlador.getCantidadVender();
            this.importe = controlador.getImporte();
            controlador.limpiarVariables();
            llenarProductoEnTabla();

        }

        private void llenarProductoEnTabla() {

            try {
                ProductoDAO prodao = null;
                ProductoDAO dao = new ProductoDAO();
                prodao = dao.getProductoPorID(idProducto);

                modelo.addRow(new Object[filas]);
                for (int i = 0; i < this.vista.tablaVenta.getColumnCount() - 1; i++) {
                    modelo.setValueAt(prodao.getIdProducto(), filas, 0);
                    modelo.setValueAt(prodao.getIdPresentacion(), filas, 1);
                    modelo.setValueAt(prodao.getIdLaboratorio(), filas, 2);
                    modelo.setValueAt(prodao.getNomProducto(), filas, 3);
                    modelo.setValueAt(prodao.getPrecioVenta(), filas, 4);
                    modelo.setValueAt(prodao.getDescripcion(), filas, 5);
                    modelo.setValueAt(this.cantidad, filas, 6);
                    modelo.setValueAt(this.importe, filas, 7);

                    modelo.setValueAt(prodao.getCaducidad(), filas, 8);
                    modelo.setValueAt(prodao.getLote(), filas, 9);
                    modelo.setValueAt(prodao.getNomPresentacion(), filas, 10);
                    modelo.setValueAt(prodao.getNomLaboratorio(), filas, 11);
                }
                filas++;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
