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
import javax.swing.table.DefaultTableModel;
import modelo.AutorDAO;
import modelo.AutorVO;
import vista.AutorF;

/**
 *
 * @author laptop
 */
public class ControladorAutor implements ActionListener, MouseListener {
    
    AutorF autorf = new AutorF();
    AutorVO modeloAutor = new AutorVO();
    AutorDAO autorDAO = new AutorDAO();
    

    public ControladorAutor(AutorF autorf) {
        this.autorf = autorf;
       
        this.autorf.btnGuardar.addActionListener(this);
        this.autorf.btnEliminar.addActionListener(this);
        this.autorf.btnModificar.addActionListener(this);
        this.autorf.btnConsultar.addActionListener(this);
        //this.autorf.btnMostrar.addActionListener(this);
        this.autorf.btnSalir.addActionListener(this);
        this.autorf.btnLimpiar.addActionListener(this);
        this.autorf.tblDatos.addMouseListener(this);
        this.ListarAutores(autorf.tblDatos);
        
    }
    
    public void GuardarAutor(){
        modeloAutor.setCodigo(Integer.parseInt(autorf.txtCodigo.getText()));
        modeloAutor.setNombre(autorf.txtNombre.getText());
        modeloAutor.setNacionalidad(autorf.txtNacionalidad.getText());
        modeloAutor.setGenero(autorf.txtGenero.getText());
        modeloAutor.setObra(autorf.txtObra.getText());
        String respuesta = autorDAO.insertarAutor(modeloAutor);
        if (respuesta != null) {
            JOptionPane.showMessageDialog(null, respuesta);
            
        }
    }
    
    public void EliminarAutor(){
        modeloAutor.setCodigo(Integer.parseInt(autorf.txtCodigo.getText()));
        String respuesta = autorDAO.eliminarAutor(modeloAutor);
        if (respuesta != null) {
            JOptionPane.showMessageDialog(null, respuesta);
            
        }
    }
    
    public void ModificarAutor(){
        modeloAutor.setCodigo(Integer.parseInt(autorf.txtCodigo.getText()));
        modeloAutor.setNombre(autorf.txtNombre.getText());
        modeloAutor.setNacionalidad(autorf.txtNacionalidad.getText());
        modeloAutor.setGenero(autorf.txtGenero.getText());
        modeloAutor.setObra(autorf.txtObra.getText());
        String respuesta = autorDAO.modificarAutor(modeloAutor);
        if (respuesta != null) {
            JOptionPane.showMessageDialog(null, respuesta);
            
        }


    }
    
    public void ConsultarAutor(){
        int codigo = Integer.parseInt(autorf.txtCodigo.getText());
        modeloAutor = autorDAO.ConsultarAutor(codigo);
        autorf.txtNombre.setText(modeloAutor.getNombre());
        autorf.txtNacionalidad.setText(modeloAutor.getNacionalidad());
        autorf.txtGenero.setText(modeloAutor.getGenero());
        autorf.txtObra.setText(modeloAutor.getObra());
    }
    
    public void ListarAutores(JTable tabladatos){
        
        DefaultTableModel model = new DefaultTableModel();
        tabladatos.setModel(model);
        model.setColumnCount(0);
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Nacionalidad");
        model.addColumn("Genero");
        model.addColumn("Obra Reconocida");
        
        for(AutorVO modeloAutor:autorDAO.tabla()){
            model.addRow(new Object[]{modeloAutor.getCodigo(),modeloAutor.getNombre(),
                modeloAutor.getNacionalidad(),modeloAutor.getGenero(),modeloAutor.getObra()});
        }
        
        autorf.tblDatos.setModel(model);
        
        
        
    }
    
    public void limpiar(){
        autorf.txtCodigo.setText("");
        autorf.txtNombre.setText("");
        autorf.txtGenero.setText("");
        autorf.txtNacionalidad.setText("");
        autorf.txtObra.setText("");
        autorf.txtCodigo.requestFocus();
        
    }
    
    public void salir(){
        autorf.dispose();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        
        if (e.getSource()==autorf.btnGuardar) { 
            this.GuardarAutor();
            limpiar();
            ListarAutores(autorf.tblDatos);
            
            
        }
        if (e.getSource()==autorf.btnEliminar) {
            this.EliminarAutor();
             limpiar();
             ListarAutores(autorf.tblDatos);
            
        }
        if (e.getSource()==autorf.btnModificar) {
            this.ModificarAutor();
            limpiar();
            ListarAutores(autorf.tblDatos);
        }
        
        if (e.getSource()== autorf.btnConsultar) {
            this.ConsultarAutor();
            
        }
        //if (e.getSource()==autorf.btnMostrar) {
           // this.ListarAutores();
            
        //}
        
        if (e.getSource()==autorf.btnSalir) {
            this.salir();
            
        }
        if (e.getSource()==autorf.btnLimpiar) {
            this.limpiar();
            
        }
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== autorf.tblDatos) {
            autorf.txtCodigo.setText(autorf.tblDatos.getValueAt(autorf.tblDatos.getSelectedRow(),0).toString());
            autorf.txtNombre.setText(autorf.tblDatos.getValueAt(autorf.tblDatos.getSelectedRow(),1).toString());
            autorf.txtNacionalidad.setText(autorf.tblDatos.getValueAt(autorf.tblDatos.getSelectedRow(),2).toString());
            autorf.txtGenero.setText(autorf.tblDatos.getValueAt(autorf.tblDatos.getSelectedRow(), 3).toString());
            autorf.txtObra.setText(autorf.tblDatos.getValueAt(autorf.tblDatos.getSelectedRow(), 4).toString());
                    
            
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
