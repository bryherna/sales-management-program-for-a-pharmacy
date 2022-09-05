/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Bryam
 */
public class Producto {
    private int idProducto;
    private int idPresentacion;
    private int idLaboratorio;
    private String nomProducto;
    private BigDecimal precioVenta;
    private String descripcion;
    private int stock;
    private Date caducidad;
    private String lote;

    public Producto(int idProducto, int idPresentacion, int idLaboratorio, String nomProducto, BigDecimal precioVenta, String descripcion, int stock, Date caducidad, String lote) {
        this.idProducto = idProducto;
        this.idPresentacion = idPresentacion;
        this.idLaboratorio = idLaboratorio;
        this.nomProducto = nomProducto;
        this.precioVenta = precioVenta;
        this.descripcion = descripcion;
        this.stock = stock;
        this.caducidad = caducidad;
        this.lote = lote;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
    
    

    
    
}
