/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductoDAO {
    
    ConexionBD conexion = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List Listar(){
        
        String sql = "select * from productos";
        List<Producto> lista = new ArrayList<>();
        try {
            con = conexion.conectarBD();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setTipo_material(rs.getString(3));
                producto.setMarca(rs.getString(4));
                producto.setModelo(rs.getString(5));
                producto.setNum_serie(rs.getString(6));
                producto.setCaracteristicas(rs.getString(7));
                producto.setDireccion_ip(rs.getString(8));
                producto.setAula(rs.getString(9));
                producto.setCentro_formativo(rs.getString(10));
                producto.setObservaciones(rs.getString(11));
                producto.setIncidencia(rs.getBoolean(12));
                producto.setFecha_compra(rs.getDate(13));
                producto.setProveedor(rs.getString(14));
                producto.setCantidad(rs.getInt(15));
                lista.add(producto);
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error listar: "+ e);
        }
        return lista;
        
    }// Fin metodo Listar
    
    //Metodo agregar
    
    public void agregar(Producto producto) {
        
        String sql = "insert into productos (nombre, tipo_material, marca, modelo, num_serie, caracteristicas, direccion_ip, aula, centro_formativo, observaciones, incidencia, fecha_compra, proveedor, cantidad) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            
            con = conexion.conectarBD();
            ps = conexion.prepareStatement(sql);
            
            ps.setString( 1, producto.getNombre());
            ps.setString(2, producto.getTipo_material());
            ps.setString(3, producto.getMarca());
            ps.setString(4, producto.getModelo());
            ps.setString(5, producto.getNum_serie());
            ps.setString(6, producto.getCaracteristicas());
            ps.setString(7, producto.getDireccion_ip());
            ps.setString(8, producto.getAula());
            ps.setString(9, producto.getCentro_formativo());
            ps.setString(10, producto.getObservaciones());
            ps.setBoolean(11, producto.isIncidencia());
            ps.setDate(12, producto.getFecha_compra());
            ps.setString(13, producto.getProveedor());
            ps.setInt(14, producto.getCantidad());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error en agrgar: "+ e);
        }
        
    }// Fin metodo agregar
    
}// Fin clase
