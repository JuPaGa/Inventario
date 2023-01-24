/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.ProductoDAO;
import vista.Interfaz;

/**
 *
 * @author Admin
 */
public class ControladorProducto implements ActionListener {

    Producto producto = new Producto();
    ProductoDAO productodao = new ProductoDAO();
    Interfaz vista = new Interfaz();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    
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
    

    public ControladorProducto(Interfaz vista) {

        this.vista = vista;
        vista.setVisible(true);
        agregarEventos();
        listarTabla();
    }

    private void agregarEventos() {

        vista.getBtnAnadir().addActionListener(this);
        vista.getBtnUpdate().addActionListener(this);
        vista.getBtnDelete().addActionListener(this);
        vista.getBtnClean().addActionListener(this);
        vista.getTblTabla().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                llenarCampos(e);
            }
        });
    }
    
    private void listarTabla() {
        
        String[] titulos = new String[]{"id","nombre","tipo_material","marca","modelo","num_serie","caracteristicas","direccion_ip","aula","centro_formativo","observaciones","incidencia","fecha_compra","proveedor","cantidad"};
        modeloTabla = new DefaultTableModel(titulos, 0);
        List<Producto> listaProductos = productodao.Listar();
        for (Producto producto : listaProductos) {
            modeloTabla.addRow(new Object[]{producto.getId(), producto.getNombre(),producto.getTipo_material(),producto.getMarca(),producto.getModelo(), producto.getNum_serie(),producto.getCaracteristicas(),producto.getDireccion_ip(),producto.getAula(),producto.getCentro_formativo(),producto.getObservaciones(),producto.isIncidencia(),producto.getFecha_compra(),producto.getProveedor(),producto.getCantidad()});
            
        }
        vista.getTblTabla().setModel(modeloTabla);
        vista.getTblTabla().setPreferredSize(new Dimension(350,modeloTabla.getRowCount() * 16));
    }
    
    private void llenarCampos(MouseEvent e) {
        
        JTable traget = (JTable) e.getSource();
        
        vista.getTxtNombre().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 1).toString());
        vista.getTxtTipoMate().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 2).toString());
        vista.getTxtMarca().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 3).toString());
        vista.getTxtModelo().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 4).toString());
        vista.getTxtNumSerie().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 5).toString());
        vista.getTxtCaracteristicas().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 6).toString());
        vista.getTxtDireccionIP().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 7).toString());
        vista.getTxtAula().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 8).toString());
        vista.getTxtCentroFormativo().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 9).toString());
        vista.getTxtAreaObservaciones().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 10).toString());
        vista.getCheckBoxIncidencia().setSelected((boolean) vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 11)); 
        vista.getTxtFechaCompra().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 12).toString());
        vista.getTxtProveedor().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 13).toString());
        vista.getTxtCantidad().setText(vista.getTblTabla().getModel().getValueAt(traget.getSelectedRow(), 14).toString());
    
    }
    
    //=================================================================================== Validar formulario//
    private boolean validadDatos(){
        if ("".equals(vista.getTxtNombre().getText()) /*|| "".equals(vista.getTxtTipoMate().getText()) || "".equals(vista.getTxtNumSerie().getText()) || "".equals(vista.getTxtAula().getText()) || "".equals(vista.getTxtCentroFormativo().getText())  || "".equals(vista.getCheckBoxIncidencia().getText()) || "".equals(vista.getTxtCantidad().getText())*/ ) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden ser vacios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    } //Errores tambien aqui
    
    private boolean cargarDatos() {
        try {
            
            nombre = vista.getTxtNombre().getText();
            tipo_material = vista.getTxtTipoMate().getText();
            marca = vista.getTxtMarca().getText();
            modelo = vista.getTxtModelo().getText();
            num_serie = vista.getTxtNumSerie().getText();
            caracteristicas = vista.getTxtCaracteristicas().getText();
            direccion_ip = vista.getTxtDireccionIP().getText();
            aula = vista.getTxtAula().getText();
            centro_formativo = vista.getTxtCentroFormativo().getText();
            observaciones = vista.getTxtAreaObservaciones().getText();
            incidencia = vista.getCheckBoxIncidencia().isSelected();
            fecha_compra = Date.valueOf(vista.getTxtFechaCompra().getText());
            proveedor = vista.getTxtProveedor().getText();
            cantidad = Integer.parseInt(vista.getTxtCantidad().getText());
            
            return true;

            
        } catch (NumberFormatException e) {
            //JOptionPane.showMessageDialog(null, "Los campos no pueden ser vacios", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al cagar datos: "+ e);
            return false;
        }
        
    }
    
    private void cleanCampos() {
        
        vista.getTxtNombre().setText("");
        vista.getTxtTipoMate().setText("");
        vista.getTxtMarca().setText("");
        vista.getTxtModelo().setText("");
        vista.getTxtNumSerie().setText("");
        vista.getTxtCaracteristicas().setText("");
        vista.getTxtDireccionIP().setText("");
        vista.getTxtAula().setText("");
        vista.getTxtCentroFormativo().setText("");
        vista.getTxtAreaObservaciones().setText("");
        vista.getCheckBoxIncidencia().setSelected(false);
        vista.getTxtFechaCompra().setText("");
        vista.getTxtProveedor().setText("");
        vista.getTxtCantidad().setText("");
        
        nombre = "";
        tipo_material = "";
        marca = "";
        modelo = "";
        num_serie = "";
        caracteristicas = "";
        direccion_ip = "";
        aula = "";
        centro_formativo = "";
        observaciones = "";
        incidencia = false;
        fecha_compra = null;
        proveedor = "";
        cantidad = 0;
        
        
        
    }
    
    private void añadirProducto() {
        try {
            
            if (validadDatos()) {
                if(cargarDatos()) {
                    Producto producto = new Producto(nombre, tipo_material, marca, modelo, num_serie, caracteristicas, direccion_ip, aula, centro_formativo, observaciones, incidencia, fecha_compra, proveedor, cantidad);
                    productodao.agregar(producto);
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    cleanCampos();
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al añadir producto: "+ e);
        } finally {
            listarTabla();
        }
    } //Errores aqui... voler a ver el video 6 y verificar
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()== vista.getBtnAnadir()) {
            añadirProducto();
        }
        
    }

}
