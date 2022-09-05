/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControladorGestionUsuarios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryam
 */
public class Conexion {

    private static Conexion conexionbd;

//    public Connection getConnection() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            con = DriverManager.getConnection(url, user, pass);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
    private Conexion() {
    }

    public static Conexion getInstancia() {

        if (conexionbd == null) {
            conexionbd = new Conexion();
        }
        return conexionbd;
    }

    public String listar_datos(String ws_url) {
        String cadenaJSON = "";

        try {
            URL url = new URL(ws_url);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("Accept", "application/json");

            if (conexion.getResponseCode() != 200) {
                throw new RuntimeException("Error: Codigo" + conexion.getResponseCode());

            }
            InputStreamReader isr = new InputStreamReader(conexion.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();

            int linea;

            while ((linea = br.read()) != -1) {
                sb.append((char) linea);
            }

            cadenaJSON = sb.toString();

        } catch (IOException ex) {
            Logger.getLogger(ControladorGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return cadenaJSON;

    }

}
