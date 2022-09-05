/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class ClienteDAO {

    public int idCliente;
    public int idPersona;
    public Date fechaInicio;
    public int idPais;
    public String perApellidosNombres;
    public Date perFechaNac;
    public String perDni;
    public int perEstado;
    public String perTelefono;
    public String perDireccion;
    public String perSexo;
    public String perCorreo;
    private String ws_url = "http://localhost/ws_proyecto_botica/ws_cliente.php";

    public ClienteDAO(int idCliente, int idPersona, Date fechaInicio, int idPais, String perApellidosNombres, Date perFechaNac, String perDni, int perEstado, String perTelefono, String perDireccion, String perSexo, String perCorreo) {
        this.idCliente = idCliente;
        this.idPersona = idPersona;
        this.fechaInicio = fechaInicio;
        this.idPais = idPais;
        this.perApellidosNombres = perApellidosNombres;
        this.perFechaNac = perFechaNac;
        this.perDni = perDni;
        this.perEstado = perEstado;
        this.perTelefono = perTelefono;
        this.perDireccion = perDireccion;
        this.perSexo = perSexo;
        this.perCorreo = perCorreo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getPerApellidosNombres() {
        return perApellidosNombres;
    }

    public void setPerApellidosNombres(String perApellidosNombres) {
        this.perApellidosNombres = perApellidosNombres;
    }

    public Date getPerFechaNac() {
        return perFechaNac;
    }

    public void setPerFechaNac(Date perFechaNac) {
        this.perFechaNac = perFechaNac;
    }

    public String getPerDni() {
        return perDni;
    }

    public void setPerDni(String perDni) {
        this.perDni = perDni;
    }

    public int getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(byte perEstado) {
        this.perEstado = perEstado;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(String perSexo) {
        this.perSexo = perSexo;
    }

    public String getPerCorreo() {
        return perCorreo;
    }

    public void setPerCorreo(String perCorreo) {
        this.perCorreo = perCorreo;
    }

    public ClienteDAO() {
    }

    public ClienteDAO getClienteDAOPorDni(String dni) {

        ClienteDAO clidao = null;
        Conexion con = Conexion.getInstancia();
        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_cliente.php?dni="+dni+"&buscarClienteDni"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            clidao = new ClienteDAO(item.getInt("idCliente"), item.getInt("idPersona"), Date.valueOf(item.getString("fechaInicio")),
                    item.getInt("idPais"), item.getString("perApellidosNombres"), Date.valueOf(item.getString("perFechaNac")), item.getString("perDni"),
                    item.getInt("perEstado"),
                    item.getString("perTelefono"), item.getString("perDireccion"), item.getString("perSexo"), item.getString("perCorreo"));
        }

        return clidao;

    }

    public void registrarCliente(Cliente cli) {

        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("idCliente", 0);
            parametros.put("idPersona", cli.getIdPersona());
            parametros.put("fechaInicio", cli.getFechaInicio());
            parametros.put("insertar", "");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> param : parametros.entrySet()) {
                if (sb.length() != 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] dataByte = sb.toString().getBytes("UTF-8");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.getOutputStream().write(dataByte);
            Reader in;
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            StringBuilder mensaje = new StringBuilder();

            for (int c; (c = in.read()) >= 0;) {
                mensaje.append((char) c);
            }
            String respuesta = mensaje.toString();
            JOptionPane.showMessageDialog(null, respuesta);

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

}
