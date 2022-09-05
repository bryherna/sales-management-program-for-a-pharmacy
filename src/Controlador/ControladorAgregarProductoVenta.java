/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProductoDAO;
import Vista.AgregarProductoVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryam
 */
public class ControladorAgregarProductoVenta implements ActionListener {

    AgregarProductoVenta vista;
    ArrayList<ProductoDAO> listadoPro;
    DefaultTableModel modelo;
    VigilaTablaProducto vigila = new VigilaTablaProducto();
    VigilaLabelCantidad vigilalbl = new VigilaLabelCantidad();
    public int idProducto = -1;
    public int cantidad = -1;
    public double importe = 0.0D;

    public ControladorAgregarProductoVenta(AgregarProductoVenta vista) {
        this.vista = vista;
        this.vista.btnBuscarProducto.addActionListener(this);
        this.vista.tabla_producto_buscado.addMouseListener(vigila);
        this.vista.txtCantidadVender.addKeyListener(vigilalbl);
        this.vista.btnAceptarAgregarPro.addActionListener(this);
    }

    public int getCantidadVender() {
        return cantidad;
    }

    public double getImporte() {
        return importe;
    }

    class VigilaLabelCantidad extends KeyAdapter {

        AgregarProductoVenta vista;
        DefaultTableModel modelo;
        public int cantidad = -1;
        public double importe = 0.0D;

        public int getCantidadVender() {
            return cantidad;
        }

        public double getImporte() {
            return importe;
        }

        public void setModeloVista(AgregarProductoVenta vista, DefaultTableModel modelo) {
            this.vista = vista;
            this.modelo = modelo;
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (Integer.valueOf(this.vista.lblStock.getText()) < Integer.valueOf(this.vista.txtCantidadVender.getText())) {
                JOptionPane.showMessageDialog(this.vista, "NO SE PUDO PROCESAR, LA CANTIDAD INGRESADA SUPERA AL STOCK DEL PRODUCTO");
                this.vista.txtCantidadVender.setText("");
                this.vista.lblImporteProductoVenta.setText("");
            } else {
                this.cantidad = Integer.valueOf(this.vista.txtCantidadVender.getText());
                double total = Double.parseDouble(this.vista.lblPrecioVentaProducto.getText()) * Integer.valueOf(this.vista.txtCantidadVender.getText());

                this.importe = total;
                this.vista.lblImporteProductoVenta.setText(String.valueOf(total));

            }

        }

    }

    public int getIdProducto() {
        return idProducto;
    }

    class VigilaTablaProducto extends MouseAdapter {

        AgregarProductoVenta vista;
        DefaultTableModel modelo;
        public int idProducto = -1;

        public void setModeloVista(AgregarProductoVenta vista, DefaultTableModel modelo) {
            this.vista = vista;
            this.modelo = modelo;
        }

        public int getIdProducto() {
            return idProducto;
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            int fila = this.vista.tabla_producto_buscado.getSelectedRow();
            this.idProducto = (Integer) modelo.getValueAt(fila, 0);
            this.vista.lblPrecioVentaProducto.setText(modelo.getValueAt(fila, 4).toString());
            this.vista.txtA_descripcionProducto.setText(modelo.getValueAt(fila, 5).toString());
            this.vista.lblStock.setText(modelo.getValueAt(fila, 6).toString());
            this.vista.lblFechaVencimiento.setText(modelo.getValueAt(fila, 7).toString());
            this.vista.lblLoteProducto.setText(modelo.getValueAt(fila, 8).toString());
            this.vista.lblLaboratorioProducto.setText(modelo.getValueAt(fila, 10).toString());

        }

    }

    public void llenarTablaProductoBuscado() {
        String cabecera[] = {"ID PRODUCTO", "ID PRESENTACION", "ID LABORATORIO", "NOMBRE PRODUCTO",
            "PRECIO VENTA", "DESCRIPCION", "STOCK", "CADUCIDAD", "LOTE", "NOMBRE PRESENTACION", "NOMBRE LABORATORIO"};

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < cabecera.length; i++) {
            modelo.addColumn(cabecera[i]);
        }
        try {
            ProductoDAO prodao;
            if (this.listadoPro.size() > 0) {
                for (int i = 0; i < this.listadoPro.size(); i++) {
                    Object fila[] = new Object[cabecera.length];
                    prodao = this.listadoPro.get(i);
                    fila[0] = prodao.getIdProducto();
                    fila[1] = prodao.getIdPresentacion();
                    fila[2] = prodao.getIdLaboratorio();
                    fila[3] = prodao.getNomProducto();
                    fila[4] = prodao.getPrecioVenta();
                    fila[5] = prodao.getDescripcion();
                    fila[6] = prodao.getStock();
                    fila[7] = prodao.getCaducidad();
                    fila[8] = prodao.getLote();
                    fila[9] = prodao.getNomPresentacion();
                    fila[10] = prodao.getNomLaboratorio();
                    modelo.addRow(fila);

                }
                this.vista.tabla_producto_buscado.setModel(modelo);
                this.vista.tabla_producto_buscado.setRowHeight(60);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void limpiarVariables() {
        this.idProducto = -1;
        this.cantidad = -1;
        this.importe = 0.0D;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.btnBuscarProducto) {
            if (!this.vista.txtBuscarNombreProducto.getText().isEmpty()) {
                ProductoDAO dao = new ProductoDAO();
                this.listadoPro = dao.getProductoPorNombre(this.vista.txtBuscarNombreProducto.getText().toUpperCase());
                llenarTablaProductoBuscado();
                vigila.setModeloVista(vista, modelo);
                vigilalbl.setModeloVista(vista, modelo);
            } else {
                JOptionPane.showMessageDialog(vista, "INGRESE NOMBRE DEL PRODUCTO A BUSCAR");
            }

        } else if (ae.getSource() == vista.btnAceptarAgregarPro) {
            this.idProducto = vigila.getIdProducto();
            this.cantidad = vigilalbl.getCantidadVender();
            this.importe = vigilalbl.getImporte();
            JOptionPane.showMessageDialog(vista, "SE AGREGARA CORRECTAMENTE EL PRODUCTO POR FAVOR CIERRE LA VENTANA");


        }
    }

}
