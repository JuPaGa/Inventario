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
import java.util.List;
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
            public void mouseClicked(MouseEvent e){
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

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
