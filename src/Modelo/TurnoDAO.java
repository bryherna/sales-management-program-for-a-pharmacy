/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryam
 */
public class TurnoDAO {
    public ArrayList<Turno> listadoTurno() {
        Conexion con = Conexion.getInstancia();
        ArrayList<Turno> lista = new ArrayList();

        JSONArray listado = new JSONArray(con.listar_datos("http://localhost/ws_proyecto_botica/ws_turno.php?listar"));
        
        for (int i = 0; i < listado.length(); i++) {
            JSONObject item = listado.getJSONObject(i);
            Turno turno = new Turno(item.getInt("idTurno"),
            item.getString("nombreTurno"));
            lista.add(turno);
        }
        
        return lista;
    }
    
}
