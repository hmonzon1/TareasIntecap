/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.LibrosDAO;
import modelo.LibrosVO;
import vista.LibroF;

/**
 *
 * @author laptop
 */
public class ControladorLibros implements ActionListener, MouseListener {
    
    LibroF libroF = new LibroF();
    LibrosVO modeloLibros = new LibrosVO();
    LibrosDAO librosDAO = new LibrosDAO();

   /* public ControladorLibros(LibroF libroF, LibrosVO modeloLibros, LibrosDAO librosDAO) {
        this.libroF = libroF;
        this.modeloLibros = modeloLibros;
        this.librosDAO = librosDAO;
        
        this.libroF.btnGuardar.addActionListener(this);
    }*/

    public ControladorLibros(LibroF libroF) {
        this.libroF = libroF;
        
        this.libroF.btnGuardar.addActionListener(this);
        this.libroF.btnConsultar.addActionListener(this);
        this.libroF.btnEliminar.addActionListener(this);
        this.libroF.btnModificar.addActionListener(this);
        //this.libroF.btnMostrar.addActionListener(this);
        this.libroF.btnSalir.addActionListener(this);
        this.libroF.btnLimpiar.addActionListener(this);
        this.libroF.tblDatos.addMouseListener(this);
        mostrarDatos(libroF.tblDatos);
    }
    
    public void guardarLibros(){
        modeloLibros.setCodigo(Integer.parseInt(libroF.txtCodigo.getText()));
        modeloLibros.setNombre(libroF.txtNombre.getText());
        modeloLibros.setPaginas(Integer.parseInt(libroF.txtPaginas.getText()));
        modeloLibros.setEditorial(libroF.txtEditorial.getText());
        modeloLibros.setAnio(libroF.txtAnio.getText());
        modeloLibros.setCodigoautor(Integer.parseInt(libroF.txtCodigoAutor.getText()));
        String respuesta = librosDAO.guardarLibros(modeloLibros);
        if (respuesta != null) {
            JOptionPane.showMessageDialog(null, respuesta);
            
        }
    }
        public void consultarLibros(){
               int codigo = Integer.parseInt(libroF.txtCodigo.getText());
               modeloLibros = librosDAO.consultarLibros(codigo);
               libroF.txtNombre.setText(String.valueOf(modeloLibros.getNombre()));
               libroF.txtEditorial.setText(String.valueOf(modeloLibros.getEditorial()));
               libroF.txtPaginas.setText(String.valueOf(modeloLibros.getPaginas()));
               libroF.txtAnio.setText(String.valueOf(modeloLibros.getAnio()));
               libroF.txtCodigoAutor.setText(String.valueOf(modeloLibros.getCodigoautor()));
               
        }
        
        public void eliminarLibros(){
           modeloLibros.setCodigo(Integer.parseInt(libroF.txtCodigo.getText()));
           String respuesta = librosDAO.eliminarLibro(modeloLibros);
            if (respuesta!= null) {
                JOptionPane.showMessageDialog(null, respuesta);
                
            }
           
            
        }
        
        public void modificarLibros(){
            modeloLibros.setCodigo(Integer.parseInt(libroF.txtCodigo.getText()));
            modeloLibros.setNombre(libroF.txtNombre.getText());
            modeloLibros.setEditorial(libroF.txtEditorial.getText());
            modeloLibros.setPaginas(Integer.parseInt(libroF.txtPaginas.getText()));
            modeloLibros.setAnio(libroF.txtAnio.getText());
            modeloLibros.setCodigoautor(Integer.parseInt(libroF.txtCodigoAutor.getText()));
            String respuesta = librosDAO.modificarLibro(modeloLibros);
            if (respuesta!= null) {
                JOptionPane.showMessageDialog(null, respuesta);
                
            }
            
            
        }
        
        public void mostrarDatos(JTable tblDatos){
            
            DefaultTableModel model = new DefaultTableModel();
            tblDatos.setModel(model);
            model.setColumnCount(0);
            model.addColumn("Codigo");
            model.addColumn("Nombre");
            model.addColumn("Editorial");
            model.addColumn("Paginas");
            model.addColumn("Año");
            model.addColumn("Codigo Autor");
            
            for(LibrosVO modeloLibros:librosDAO.tabla()){
                model.addRow(new Object[]{modeloLibros.getCodigo(), modeloLibros.getNombre(), modeloLibros.getEditorial(),
                modeloLibros.getPaginas(),modeloLibros.getAnio(),modeloLibros.getCodigoautor()});
            }
            
            libroF.tblDatos.setModel(model);
            
        }
        
        public void limpiar(){
            libroF.txtCodigo.setText("");
            libroF.txtNombre.setText("");
            libroF.txtEditorial.setText("");
            libroF.txtPaginas.setText("");
            libroF.txtAnio.setText("");
            libroF.txtCodigoAutor.setText("");
            libroF.txtCodigo.requestFocus();
            
        }
        
        public void salir(){
           this.libroF.dispose();
        }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()== libroF.btnGuardar) {
            this.guardarLibros();
            limpiar();
            mostrarDatos(libroF.tblDatos);
            
        }
        if (e.getSource()==libroF.btnConsultar) {
            this.consultarLibros();
            
        }
        if (e.getSource()==libroF.btnEliminar) {
            this.eliminarLibros();
            limpiar();
            mostrarDatos(libroF.tblDatos);
            
        }
        
        if (e.getSource()==libroF.btnModificar) {
            this.modificarLibros();
            limpiar();
            mostrarDatos(libroF.tblDatos);
        }
        
        if (e.getSource()==libroF.btnSalir) {
            this.salir();
            
        }
        //if (e.getSource()==libroF.btnMostrar) {
           // this.mostrarDatos();
            
            
       // }
        if (e.getSource()==libroF.btnLimpiar) {
            this.limpiar();
            
        }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== libroF.tblDatos) { 
            libroF.txtCodigo.setText(libroF.tblDatos.getValueAt(libroF.tblDatos.getSelectedRow(), 0).toString());
            libroF.txtNombre.setText(libroF.tblDatos.getValueAt(libroF.tblDatos.getSelectedRow(), 1).toString());
            libroF.txtEditorial.setText(libroF.tblDatos.getValueAt(libroF.tblDatos.getSelectedRow(), 2).toString());
            libroF.txtPaginas.setText(libroF.tblDatos.getValueAt(libroF.tblDatos.getSelectedRow(), 3).toString());
            libroF.txtAnio.setText(libroF.tblDatos.getValueAt(libroF.tblDatos.getSelectedRow(), 4).toString());
            libroF.txtCodigoAutor.setText(libroF.tblDatos.getValueAt(libroF.tblDatos.getSelectedRow(), 5).toString());
            
            
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    
}
