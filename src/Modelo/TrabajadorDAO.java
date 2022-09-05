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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class TrabajadorDAO {

    private int idPersona;
    private int idPais;
    private String perApellidosNombres;
    private Date perFechaNac;
    private String perDni;
    private int perEstado;
    private String perTelefono;
    private String perDireccion;
    private String perSexo;
    private String perCorreo;

    private int idTrabajador;
    private int idCargoTrabajador;
    private int idProfesion;
    private int idRoles;
    private int idTurno;
    private Date fechaInicio;

    private String nomCargo;
    private String nomProfesion;
    private String nomRoles;
    private String nomTurno;
    private String nomPais;

    private String ws_url = "http://localhost/ws_proyecto_botica/ws_trabajadores.php";

    public TrabajadorDAO() {
    }

    public TrabajadorDAO(int idPersona, int idPais, String perApellidosNombres, Date perFechaNac, String perDni, int perEstado, String perTelefono, String perDireccion, String perSexo, String perCorreo, int idTrabajador, int idCargoTrabajador, int idProfesion, int idRoles, int idTurno, Date fechaInicio, String nomCargo, String nomProfesion, String nomRoles, String nomTurno, String nomPais) {
        this.idPersona = idPersona;
        this.idPais = idPais;
        this.perApellidosNombres = perApellidosNombres;
        this.perFechaNac = perFechaNac;
        this.perDni = perDni;
        this.perEstado = perEstado;
        this.perTelefono = perTelefono;
        this.perDireccion = perDireccion;
        this.perSexo = perSexo;
        this.perCorreo = perCorreo;
        this.idTrabajador = idTrabajador;
        this.idCargoTrabajador = idCargoTrabajador;
        this.idProfesion = idProfesion;
        this.idRoles = idRoles;
        this.idTurno = idTurno;
        this.fechaInicio = fechaInicio;
        this.nomCargo = nomCargo;
        this.nomProfesion = nomProfesion;
        this.nomRoles = nomRoles;
        this.nomTurno = nomTurno;
        this.nomPais = nomPais;
    }

    public TrabajadorDAO(int idPersona, int idPais, String perApellidosNombres, Date perFechaNac, String perDni, int perEstado, String perTelefono, String perDireccion, String perSexo, String perCorreo, int idTrabajador, int idCargoTrabajador, int idProfesion, int idRoles, int idTurno, Date fechaInicio) {
        this.idPersona = idPersona;
        this.idPais = idPais;
        this.perApellidosNombres = perApellidosNombres;
        this.perFechaNac = perFechaNac;
        this.perDni = perDni;
        this.perEstado = perEstado;
        this.perTelefono = perTelefono;
        this.perDireccion = perDireccion;
        this.perSexo = perSexo;
        this.perCorreo = perCorreo;
        this.idTrabajador = idTrabajador;
        this.idCargoTrabajador = idCargoTrabajador;
        this.idProfesion = idProfesion;
        this.idRoles = idRoles;
        this.idTurno = idTurno;
        this.fechaInicio = fechaInicio;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdCargoTrabajador() {
        return idCargoTrabajador;
    }

    public void setIdCargoTrabajador(int idCargoTrabajador) {
        this.idCargoTrabajador = idCargoTrabajador;
    }

    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }

    public int getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(int idRoles) {
        this.idRoles = idRoles;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

    public String getNomProfesion() {
        return nomProfesion;
    }

    public void setNomProfesion(String nomProfesion) {
        this.nomProfesion = nomProfesion;
    }

    public String getNomRoles() {
        return nomRoles;
    }

    public void setNomRoles(String nomRoles) {
        this.nomRoles = nomRoles;
    }

    public String getNomTurno() {
        return nomTurno;
    }

    public void setNomTurno(String nomTurno) {
        this.nomTurno = nomTurno;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public void eliminarTrabajador(int idTrabajador) {
        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("id", idTrabajador);
            parametros.put("eliminar", "");
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

    public void modificarTrabajador(Trabajador tra) {
        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("idTrabajador", tra.getIdTrabajador());
            parametros.put("idPersona", tra.getIdPersona());
            parametros.put("idCargoTrabajador", tra.getIdCargoTrabajador());
            parametros.put("idProfesion", tra.getIdProfesion());
            parametros.put("idRoles", tra.getIdRoles());
            parametros.put("idTurno", tra.getIdTurno());
            parametros.put("fechaInicio", tra.getFechaInicio());
            parametros.put("actualizar", "");
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

    public void registrarTrabajadodr(Trabajador tra) {
        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("idTrabajador", 0);
            parametros.put("idPersona", tra.getIdPersona());
            parametros.put("idCargoTrabajador", tra.getIdCargoTrabajador());
            parametros.put("idProfesion", tra.getIdProfesion());
            parametros.put("idRoles", tra.getIdRoles());
            parametros.put("idTurno", tra.getIdTurno());
            parametros.put("fechaInicio", tra.getFechaInicio());
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

    public TrabajadorDAO getTrabajadorDNI(String dni) {
        //
        Conexion con = Conexion.getInstancia();
        TrabajadorDAO tra = null;
        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_trabajadores.php?perDni=" + dni + "&trabajador_por_dni"));
        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            tra = new TrabajadorDAO(item.getInt("idPersona"), item.getInt("idPais"),
                    item.getString("perApellidosNombres"), Date.valueOf(item.getString("perFechaNac")),
                    item.getString("perDni"), item.getInt("perEstado"), item.getString("perTelefono"),
                    item.getString("perDireccion"), item.getString("perSexo"), item.getString("perCorreo"), item.getInt("idTrabajador"),
                    item.getInt("idCargoTrabajador"), item.getInt("idProfesion"), item.getInt("idRoles"),
                    item.getInt("idTurno"), Date.valueOf(item.getString("fechaInicio")), item.getString("nomCargoTrabajador"),
                    item.getString("nomProfesion"), item.getString("nomRol"),
                    item.getString("nombreTurno"), item.getString("nomPais"));
        }
        return tra;
    }

    public ArrayList<TrabajadorDAO> listadoTrabajadores() {

        Conexion con = Conexion.getInstancia();
        ArrayList<TrabajadorDAO> lista = new ArrayList();

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_trabajadores.php?listar"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            TrabajadorDAO tra = new TrabajadorDAO(item.getInt("idPersona"), item.getInt("idPais"),
                    item.getString("perApellidosNombres"), Date.valueOf(item.getString("perFechaNac")),
                    item.getString("perDni"), item.getInt("perEstado"), item.getString("perTelefono"),
                    item.getString("perDireccion"), item.getString("perSexo"), item.getString("perCorreo"), item.getInt("idTrabajador"),
                    item.getInt("idCargoTrabajador"), item.getInt("idProfesion"), item.getInt("idRoles"),
                    item.getInt("idTurno"), Date.valueOf(item.getString("fechaInicio")), item.getString("nomCargoTrabajador"),
                    item.getString("nomProfesion"), item.getString("nomRol"),
                    item.getString("nombreTurno"), item.getString("nomPais"));
            lista.add(tra);
        }

        return lista;
    }

    public Trabajador getTrabajadorID(int idTrabajador) {
        Conexion con = Conexion.getInstancia();
        Trabajador tra = null;

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_trabajadores.php?idTrabajador=" + idTrabajador + "&trabajador_por_id"));
        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            tra = new Trabajador(item.getInt("idTrabajador"), item.getInt("idPersona"),
                    item.getInt("idCargoTrabajador"), item.getInt("idProfesion"), item.getInt("idRoles"),
                    item.getInt("idTurno"), Date.valueOf(item.getString("fechaInicio")));
        }

        return tra;

    }

    @Override
    public String toString() {
        return perDni;
    }

}
