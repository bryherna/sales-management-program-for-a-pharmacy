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
public class ModoPagoDAO {

    public ArrayList<ModoPago> listadoModoPago() {
        Conexion con = Conexion.getInstancia();

        ArrayList<ModoPago> lista = new ArrayList();

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_modoPago.php?listar"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            ModoPago mp = new ModoPago(item.getInt("idModoPago"), item.getString("nomModoPago"));
            lista.add(mp);
        }

        return lista;

    }

}
