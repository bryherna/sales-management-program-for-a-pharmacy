/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class RolesDAO {

    
    
    public Roles getRolesTrabajador(int idRol){
        Roles roles = null;
        Conexion con = Conexion.getInstancia();
         JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_roles.php?idRol="+idRol+"&roles_trabajador"));
         for (int i = 0; i < listado.length(); i++){
             JSONObject item = listado.getJSONObject(i);
              roles = new Roles(item.getInt("idRoles"),item.getString("nomRol"));
         }

        
        return roles;
        
    }
    
    public ArrayList<Roles> listadoRoles() {
        Conexion con = Conexion.getInstancia();
        ArrayList<Roles> lista = new ArrayList();

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_roles.php?listar"));
        
        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            Roles roles = new Roles(item.getInt("idRoles"),
            item.getString("nomRol"));
            lista.add(roles);
        }
        
        return lista;
    }
    
}
