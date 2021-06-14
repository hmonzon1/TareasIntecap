/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FormularioInicio;
import vista.FormularioPrincipal;

/**
 *
 * @author laptop
 */
public class ControladorInicio implements ActionListener {
    
    
    FormularioPrincipal principal = new FormularioPrincipal();
    FormularioInicio inicio = new FormularioInicio();

    public ControladorInicio(FormularioInicio inicio){
        this.inicio = inicio;
     
        this.inicio.btnIniciar.addActionListener(this);
        
        
        
    }

    

   
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==inicio.btnIniciar) {
            principal.setVisible(true);
            inicio.setVisible(false);
            
        }
        
    }
    
    
}
