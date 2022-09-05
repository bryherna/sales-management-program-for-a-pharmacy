/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class ComprobanteVentaDAO {

    public ArrayList<ComprobanteVenta> listadoComprobanteVenta() {

        Conexion con = Conexion.getInstancia();
        ArrayList<ComprobanteVenta> lista = new ArrayList();

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_comprobanteVenta.php?listar"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            ComprobanteVenta cv = new ComprobanteVenta(item.getInt("idComprobanteVenta"),
                    item.getString("nomComprobanteVenta"));
            lista.add(cv);
        }

        return lista;
    }

}
