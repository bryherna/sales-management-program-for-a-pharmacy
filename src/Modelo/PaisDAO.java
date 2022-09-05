/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class PaisDAO {

    private String ws_url = "http://localhost/ws_proyecto_botica/ws_pais.php";

    public ArrayList<Pais> listadoPais() throws Exception {

        Conexion con = Conexion.getInstancia();
        ArrayList<Pais> lista = new ArrayList();

        JSONArray listado = new JSONArray(con.listar_datos(ws_url));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            Pais pa = new Pais(item.getInt("idPais"), item.getString("nomPais"));
            lista.add(pa);
        }

        return lista;
    }

}
