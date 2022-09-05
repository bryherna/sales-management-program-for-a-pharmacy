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
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class PersonaDAO {

    private String ws_url = "http://localhost/ws_proyecto_botica/ws_persona.php";

    public void modificarPersona(Persona per) {
        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("idPersona", per.getIdPersona());
            parametros.put("idPais", per.getIdPais());
            parametros.put("perApellidosNombres", per.getPerApellidosNombres());
            parametros.put("perFechaNac", per.getPerFechaNac());
            parametros.put("perDni", per.getPerDni());
            parametros.put("perEstado", per.getPerEstado());
            parametros.put("perTelefono", per.getPerTelefono());
            parametros.put("perDireccion", per.getPerDireccion());
            parametros.put("perSexo", per.getPerSexo());
            parametros.put("perCorreo", per.getPerCorreo());
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

    public void registrarPersona(Persona per) {

        try {
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("idPersona", 0);
            parametros.put("idPais", per.getIdPais());
            parametros.put("perApellidosNombres", per.getPerApellidosNombres());
            parametros.put("perFechaNac", per.getPerFechaNac());
            parametros.put("perDni", per.getPerDni());
            parametros.put("perEstado", per.getPerEstado());
            parametros.put("perTelefono", per.getPerTelefono());
            parametros.put("perDireccion", per.getPerDireccion());
            parametros.put("perSexo", per.getPerSexo());
            parametros.put("perCorreo", per.getPerCorreo());
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

    public int getMaximoIDPersonaRegistrado() {
        int id_max = -1;
        //
        Conexion con = Conexion.getInstancia();
        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_persona.php?maximo_id_persona"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            id_max = item.getInt("mayorID");
        }

        return id_max;
    }

    public Persona getPersonaIDTrabajador(int idTrabajador) {
        Persona p = null;
        Conexion con = Conexion.getInstancia();
        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_persona.php?idTrabajador=" + idTrabajador + "&persona_id_trabajador"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            p = new Persona(item.getInt("idPersona"), item.getInt("idPais"),
                    item.getString("perApellidosNombres"), Date.valueOf(item.getString("perFechaNac")),
                    item.getString("perDni"), item.getInt("perEstado"), item.getString("perTelefono"),
                    item.getString("perDireccion"), item.getString("perSexo"), item.getString("perCorreo"));

        }

        return p;

    }

}
