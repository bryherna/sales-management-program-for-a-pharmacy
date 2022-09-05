/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class ProductoDAO {

    private int idProducto;
    private int idPresentacion;
    private int idLaboratorio;
    private String nomProducto;
    private BigDecimal precioVenta;
    private String descripcion;
    private int stock;
    private Date caducidad;
    private String lote;
    private String nomPresentacion;
    private String nomLaboratorio;

    public ProductoDAO() {
    }

    public ProductoDAO(int idProducto, int idPresentacion, int idLaboratorio, String nomProducto, BigDecimal precioVenta, String descripcion, int stock, Date caducidad, String lote, String nomPresentacion, String nomLaboratorio) {
        this.idProducto = idProducto;
        this.idPresentacion = idPresentacion;
        this.idLaboratorio = idLaboratorio;
        this.nomProducto = nomProducto;
        this.precioVenta = precioVenta;
        this.descripcion = descripcion;
        this.stock = stock;
        this.caducidad = caducidad;
        this.lote = lote;
        this.nomPresentacion = nomPresentacion;
        this.nomLaboratorio = nomLaboratorio;
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

    public String getNomPresentacion() {
        return nomPresentacion;
    }

    public void setNomPresentacion(String nomPresentacion) {
        this.nomPresentacion = nomPresentacion;
    }

    public String getNomLaboratorio() {
        return nomLaboratorio;
    }

    public void setNomLaboratorio(String nomLaboratorio) {
        this.nomLaboratorio = nomLaboratorio;
    }

    public ProductoDAO getProductoPorID(int id_pro) {

        Conexion con = Conexion.getInstancia();
        ProductoDAO prodao = null;

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_producto.php?idPro=" + id_pro + "&producto_por_id"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            prodao = new ProductoDAO(item.getInt("idProducto"),
                    item.getInt("idPresentacion"), item.getInt("idLaboratorio"),
                    item.getString("nomProducto"), item.getBigDecimal("precioVenta"),
                    item.getString("descripcion"), item.getInt("stock"),
                    Date.valueOf(item.getString("caducidad")), item.getString("lote"),
                    item.getString("nomPresentacion"), item.getString("nomLaboratorio"));

        }

        return prodao;

    }

    public ArrayList<ProductoDAO> getProductoPorNombre(String nombre) {

        Conexion con = Conexion.getInstancia();
        ArrayList<ProductoDAO> lista = new ArrayList<>();
        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_producto.php?nomPro=" + nombre + "&producto_por_nombre"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            ProductoDAO proDAO = new ProductoDAO(item.getInt("idProducto"),
                    item.getInt("idPresentacion"), item.getInt("idLaboratorio"),
                    item.getString("nomProducto"), item.getBigDecimal("precioVenta"),
                    item.getString("descripcion"), item.getInt("stock"),
                    Date.valueOf(item.getString("caducidad")), item.getString("lote"),
                    item.getString("nomPresentacion"), item.getString("nomLaboratorio"));

            lista.add(proDAO);
        }

        return lista;

    }

}
