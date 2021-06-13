/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorPais;
import vista.PaisF;

/**
 *
 * @author laptop
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        PaisF paisf = new PaisF();
        ControladorPais controlador = new ControladorPais(paisf);
        paisf.setVisible(true);
        
        
        
    }
    
}
