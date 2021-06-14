/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.ConsultasDAO;
import modelo.ConsultasVO;
import vista.ConsultasF;

/**
 *
 * @author laptop
 */
public class ControladorConsultas implements ActionListener {
    
    ConsultasF consultasF = new ConsultasF();
    ConsultasVO modeloConsultas = new ConsultasVO();
    ConsultasDAO consultasDAO = new ConsultasDAO();

    public ControladorConsultas(ConsultasF consultasF) {
        this.consultasF = consultasF;
        
        this.consultasF.btnSalir.addActionListener(this);
        mostrarTabla(consultasF.tblDatos);
    }
    
    public void mostrarTabla(JTable modeloDatos){ 
        DefaultTableModel modelo = new DefaultTableModel();
        modeloDatos.setModel(modelo);
        modelo.setColumnCount(0);
        modelo.addColumn("Codigo Libro");
        modelo.addColumn("Nombre Libro");
        modelo.addColumn("Editorial");
        modelo.addColumn("Autor");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Genero");
        
        for(ConsultasVO modeloConsultas:consultasDAO.consultas2()){
            modelo.addRow(new Object[]{modeloConsultas.getCodigolibro(),modeloConsultas.getNombrelibro(),
            modeloConsultas.getEditoriallibro(),modeloConsultas.getNombreautor(),modeloConsultas.getNacionalidadautor(),modeloConsultas.getGeneroautor()});
        }
        
        consultasF.tblDatos.setModel(modelo);
        TableColumn c1 = consultasF.tblDatos.getColumnModel().getColumn(0);
        c1.setMaxWidth(35);
        c1.setMinWidth(35);
       
     }
    
    public void salir(){
        consultasF.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==consultasF.btnSalir) {
            this.salir();
            
        }
        
         {
            
        }
    }
    
    
    
    
    
}
