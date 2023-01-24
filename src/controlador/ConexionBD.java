/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ConexionBD {
    Connection con;
    String driver = "com.mysql.jdbc.Driver";
    String baseDato = "inventario";
    String url = "jdbc:mysql://localhost:3306/"+baseDato+"?useSSL=false&serverTimezone=UTC";
    String usuario = "root";
    String clave = "Root";
    
    public Connection conectarBD(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion: "+ e);
        }
        return con;
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*class Prueba {
    public static void main(String[] args){
        Connection con;
        ConexionBD conexion = new ConexionBD();
        con = conexion.conectarBD();
    }
}*/