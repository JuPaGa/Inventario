/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String tipo_material;
    private String marca;
    private String modelo;
    private String num_serie;
    private String caracteristicas;
    private String direccion_ip;
    private String aula;
    private String centro_formativo;
    private String observaciones;
    private boolean incidencia;
    private Date fecha_compra;
    private String proveedor;
    private int cantidad;

    //Constructor vacio
    public Producto() {
    }

    //Constructor añadir
    public Producto(String nombre, String tipo_material, String marca, String modelo, String num_serie, String caracteristicas, String direccion_ip, String aula, String centro_formativo, String observaciones, boolean incidencia, Date fecha_compra, String proveedor, int cantidad) {
        this.nombre = nombre;
        this.tipo_material = tipo_material;
        this.marca = marca;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.caracteristicas = caracteristicas;
        this.direccion_ip = direccion_ip;
        this.aula = aula;
        this.centro_formativo = centro_formativo;
        this.observaciones = observaciones;
        this.incidencia = incidencia;
        this.fecha_compra = fecha_compra;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
    }
    
    //Constructor update
    public Producto(int id, String nombre, String tipo_material, String marca, String modelo, String num_serie, String caracteristicas, String direccion_ip, String aula, String centro_formativo, String observaciones, boolean incidencia, Date fecha_compra, String proveedor, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_material = tipo_material;
        this.marca = marca;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.caracteristicas = caracteristicas;
        this.direccion_ip = direccion_ip;
        this.aula = aula;
        this.centro_formativo = centro_formativo;
        this.observaciones = observaciones;
        this.incidencia = incidencia;
        this.fecha_compra = fecha_compra;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
    }
    
    //Getter y Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_material() {
        return tipo_material;
    }

    public void setTipo_material(String tipo_material) {
        this.tipo_material = tipo_material;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDireccion_ip() {
        return direccion_ip;
    }

    public void setDireccion_ip(String direccion_ip) {
        this.direccion_ip = direccion_ip;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getCentro_formativo() {
        return centro_formativo;
    }

    public void setCentro_formativo(String centro_formativo) {
        this.centro_formativo = centro_formativo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isIncidencia() {
        return incidencia;
    }

    public void setIncidencia(boolean incidencia) {
        this.incidencia = incidencia;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
                    
}
