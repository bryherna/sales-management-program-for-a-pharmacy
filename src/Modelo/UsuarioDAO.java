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
public class UsuarioDAO {

    private int idUsuario;
    private String nombreUsuario;
    private int idTipoUsuario;
    private int idTrabajador;
    private String password_usuario;
    private int estadoUsuario;
    private String nombreTipoUsuario;
    private String perApellidosNombres;
    private String ws_url = "http://localhost/ws_proyecto_botica/ws_usuarios.php";

    public UsuarioDAO(int idUsuario, String nombreUsuario, int idTipoUsuario, int idTrabajador, String password_usuario, int estadoUsuario, String nombreTipoUsuario, String perApellidosNombres) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idTipoUsuario = idTipoUsuario;
        this.idTrabajador = idTrabajador;
        this.password_usuario = password_usuario;
        this.estadoUsuario = estadoUsuario;
        this.nombreTipoUsuario = nombreTipoUsuario;
        this.perApellidosNombres = perApellidosNombres;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(byte estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public String getPerApellidosNombres() {
        return perApellidosNombres;
    }

    public void setPerApellidosNombres(String perApellidosNombres) {
        this.perApellidosNombres = perApellidosNombres;
    }

    public UsuarioDAO() {
    }

    public void eliminarUsuario(int idUsuario) {

        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("id", idUsuario);
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

    public void modificarUsuario(Usuario usu) {
        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("idUsuario", usu.getIdUsuario());
            parametros.put("nombreUsuario", usu.getNombreUsuario());
            parametros.put("idTipoUsuario", usu.getIdTipoUsuario());
            parametros.put("idTrabajador", usu.getIdTrabajador());
            parametros.put("password_usuario", usu.getPassword_usuario());
            parametros.put("estadoUsuario", usu.getEstadoUsuario());
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

    public void registrarUsuario(Usuario usu) {

        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("idUsuario", 0);
            parametros.put("nombreUsuario", usu.getNombreUsuario());
            parametros.put("idTipoUsuario", usu.getIdTipoUsuario());
            parametros.put("idTrabajador", usu.getIdTrabajador());
            parametros.put("password_usuario", usu.getPassword_usuario());
            parametros.put("estadoUsuario", usu.getEstadoUsuario());
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

    public ArrayList<UsuarioDAO> listadoUsuarios() {

        Conexion con = Conexion.getInstancia();
        ArrayList<UsuarioDAO> lista = new ArrayList();

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_usuarios.php?listar"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            UsuarioDAO dao = new UsuarioDAO(item.getInt("idUsuario"),
                    item.getString("nombreUsuario"), item.getInt("idTipoUsuario"),
                    item.getInt("idTrabajador"), item.getString("password_usuario"),
                    item.getInt("estadoUsuario"), item.getString("nombreTipoUsuario"),
                    item.getString("perApellidosNombres"));
            lista.add(dao);
        }

        return lista;

    }

    public Usuario logearse(String user, String pass) {
        Conexion con = Conexion.getInstancia();
        Usuario u = null;
        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_usuarios.php?nomUsuario=" + user + "&passwordUsuario=" + pass + "&logearse"));
        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            u = new Usuario(item.getInt("idUsuario"),
                    item.getString("nombreUsuario"), item.getInt("idTipoUsuario"),
                    item.getInt("idTrabajador"), item.getString("password_usuario"),
                    item.getInt("estadoUsuario"));

        }

        return u;

    }

}
