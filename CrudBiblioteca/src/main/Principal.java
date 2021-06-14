/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorInicio;
import vista.FormularioInicio;
import vista.FormularioPrincipal;

/**
 *
 * @author laptop
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FormularioInicio inicio = new FormularioInicio();
        //FormularioPrincipal principal = new FormularioPrincipal();
        ControladorInicio cInicio = new ControladorInicio(inicio);
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
        
        
    }
    
}
