/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class TipoUsuarioDAO {

    public ArrayList<TipoUsuario> listadoTipoUsuario() {

        Conexion con = Conexion.getInstancia();
        ArrayList<TipoUsuario> lista = new ArrayList();

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_tipoUsuarios.php?listar"));

        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            TipoUsuario tu = new TipoUsuario(item.getInt("idTipoUsuario"), item.getString("nombreTipoUsuario"), item.getString("descripcionTipoUsuario"));
            lista.add(tu);
        }

        return lista;
    }

    public TipoUsuario getTipoUsuarioID(int idTipoUsuario) {
        TipoUsuario tp = null;
        Conexion con = Conexion.getInstancia();
         JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_tipoUsuarios.php?idTipoUsuario="+idTipoUsuario+"&tipo_usuario_id"));
         for (int i = 0; i < listado.length(); i++){
             JSONObject item = listado.getJSONObject(i);
             tp = new TipoUsuario(item.getInt("idTipoUsuario"),
                                item.getString("nombreTipoUsuario"), item.getString("descripcionTipoUsuario"));
         }
         return tp;
    }

}
