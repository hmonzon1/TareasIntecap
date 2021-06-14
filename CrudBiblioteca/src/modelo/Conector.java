/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conector {
    Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String servidor = "127.0.0.1";
    private String usuario = "root";
    private String password = "tsare2020";
    private String bd = "bd_biblioteca";
    private String cadena = " ";
    
    public Connection getMiConexion(){
        return con;
    }
     //metodo para conectar
    public void conectar(){
        this.cadena = "jdbc:mysql://"+this.servidor+"/"+this.bd;
        try {
            Class.forName(this.driver).newInstance();
            this.con = DriverManager.getConnection(this.cadena, this.usuario, this.password );
        } catch (Exception e) {
            System.err.println("Mensaje Conectar: "+e.getMessage());
        }
    }
    
    //metodo para desconectar
    
    public void desconectar(){
        try {
            this.con.close();
        } catch (Exception e) {
            System.err.println("Mensaje Desconeccion:"+e.getMessage());
            
        }
    }
    
    
    
}
