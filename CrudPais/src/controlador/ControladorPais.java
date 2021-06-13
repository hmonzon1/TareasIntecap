/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PaisDAO;
import modelo.PaisVO;
import net.sf.jasperreports.view.JasperViewer;
import vista.PaisF;

/**
 *
 * @author laptop
 */
public class ControladorPais implements ActionListener{
    
    PaisF paisf = new PaisF();
    PaisVO paisvo = new PaisVO();
    PaisDAO paisDAO = new PaisDAO();

    public ControladorPais(PaisF paisf) {
        this.paisf = paisf;
        
        paisf.btnGuardar.addActionListener(this);
        paisf.btnModificar.addActionListener(this);
        paisf.btnEliminar.addActionListener(this);
        paisf.btnConsultar.addActionListener(this);
        paisf.btnLimpiar.addActionListener(this);
        paisf.btnSalir.addActionListener(this);
        paisf.btnMostrar.addActionListener(this);
        paisf.btnGenerar.addActionListener(this);       
        
        
    }
    
    public void GuardarPais(){
        paisvo.setId_pais(Integer.parseInt(paisf.txtCodigo.getText()));
        paisvo.setNombre_pais(paisf.txtNombre.getText());
        paisvo.setCapital_pais(paisf.txtCapital.getText());
        paisvo.setPoblacion_pais(Long.parseLong(paisf.txtPoblacion.getText()));
        String respuesta = paisDAO.insertarPais(paisvo);
        if (respuesta!=null) {
            JOptionPane.showMessageDialog(null, respuesta);
            
        }
    }
    
    public void ConsultarPais(){
        int codigo = Integer.parseInt(paisf.txtCodigo.getText());
        
           
        paisvo = paisDAO.consultarPais(codigo);
        paisf.txtCodigo.setText(String.valueOf(paisvo.getId_pais()));
        paisf.txtNombre.setText(String.valueOf(paisvo.getNombre_pais()));
        paisf.txtCapital.setText(String.valueOf(paisvo.getCapital_pais()));
        paisf.txtPoblacion.setText(String.valueOf(paisvo.getPoblacion_pais()));
                 
        
    }
    
    public void ModificarPais(){
        paisvo.setId_pais(Integer.parseInt(paisf.txtCodigo.getText()));
        paisvo.setNombre_pais(paisf.txtNombre.getText());
        paisvo.setCapital_pais(paisf.txtCapital.getText());
        paisvo.setPoblacion_pais(Long.parseLong(paisf.txtPoblacion.getText()));
        String respuesta = paisDAO.modificarPais(paisvo);
        if (respuesta !=  null) {
            JOptionPane.showMessageDialog(null, respuesta);
            
        }
    }
 
    public void EliminarPais(){
        paisvo.setId_pais(Integer.parseInt(paisf.txtCodigo.getText()));
        String respuesta = paisDAO.eliminarPais(paisvo);
        if (respuesta != null) {
            JOptionPane.showMessageDialog(null, respuesta);
            
        }
    }
    
    public void Limpiar(){
         paisf.txtCodigo.setText("");
         paisf.txtNombre.setText("");
         paisf.txtCapital.setText("");
         paisf.txtPoblacion.setText("");
         paisf.txtCodigo.requestFocus();
     }
    
    public void Salir(){
        paisf.dispose();
    }
    
    public void tabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnCount(0);
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Capital");
        model.addColumn("Poblacion");
        
         for(PaisVO paisvo: paisDAO.tabla()){
            model.addRow(new Object[]{paisvo.getId_pais(),paisvo.getNombre_pais(),
                paisvo.getCapital_pais(),paisvo.getPoblacion_pais()});
            
        }
         
         paisf.miTabla.setModel(model);
            
       
        
    }
    
    public void reporte(){
        paisDAO.reporteD();
        paisDAO.jv.setDefaultCloseOperation(paisf.DISPOSE_ON_CLOSE);
        paisDAO.jv.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource()==paisf.btnGuardar) {
            this.GuardarPais();
            this.Limpiar();
            
        }
        
        if (e.getSource()==paisf.btnConsultar) {
          
            this.ConsultarPais();
            
        }
        
        if (e.getSource()==paisf.btnModificar) {
            this.ModificarPais();
            this.Limpiar();
            
        }
        if (e.getSource()== paisf.btnEliminar) {
            this.EliminarPais();
            this.Limpiar();
            
        }
        
        if (e.getSource()== paisf.btnLimpiar) {
            this.Limpiar();
            
        }
        if (e.getSource()== paisf.btnSalir) {
            this.Salir();
            
        }
        
        if (e.getSource()== paisf.btnMostrar) {
            this.tabla();
            
        }
        
        if (e.getSource()== paisf.btnGenerar) {
            reporte();
            
        }
    }
    
}
