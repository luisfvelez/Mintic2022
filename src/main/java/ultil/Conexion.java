/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;

import java.sql.*;

/**
 *
 * @author juand
 */
public class Conexion {

    private static final String UBICACION_BD = "ProyectosConstruccion.db";

    String url = "jdbc:sqlite:" + UBICACION_BD;

    Connection conn = null;

    public Conexion() {
        try {
                Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ResultSet consultaRegistros(String url){
        try {
            PreparedStatement pstm = conn.prepareStatement(url);
            ResultSet respuesta = pstm.executeQuery();
            
            return  respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
