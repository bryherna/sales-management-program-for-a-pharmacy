/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;

/**
 *
 * @author Bryam
 */
public class Venta {

    private int idVenta;
    private int idCliente;
    private int idTrabajador;
    private int idComprobanteVenta;
    private BigDecimal totalVenta;
    private Instant fechaVenta;
    private int idModoPago;

    public Venta() {
    }

    public Venta(int idVenta, int idCliente, int idTrabajador, int idComprobanteVenta, BigDecimal totalVenta, Instant fechaVenta, int idModoPago) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.idComprobanteVenta = idComprobanteVenta;
        this.totalVenta = totalVenta;
        this.fechaVenta = fechaVenta;
        this.idModoPago = idModoPago;
    }

    public int getIdVenta() {
        return idVenta;

    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdComprobanteVenta() {
        return idComprobanteVenta;
    }

    public void setIdComprobanteVenta(int idComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Instant getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Instant fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdModoPago() {
        return idModoPago;
    }

    public void setIdModoPago(int idModoPago) {
        this.idModoPago = idModoPago;
    }

}
