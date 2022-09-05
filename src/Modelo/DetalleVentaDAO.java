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
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryam
 */
public class DetalleVentaDAO {
    
    private String ws_url = "http://localhost/ws_proyecto_botica/ws_detalleVenta.php";
    
    public void registrarDetalleVenta(DetalleVenta dv){
        try{
            URL url = new URL(ws_url);
            Map<String, Object> parametros = new LinkedHashMap();
            parametros.put("idDetalleVenta",0 );
            parametros.put("idProducto",dv.getIdProducto());
            parametros.put("idVenta", dv.getIdVenta());
            parametros.put("precioProducto",dv.getPrecioProducto() );
            parametros.put("cantidad", dv.getCantidad());
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
            
        }catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
}
