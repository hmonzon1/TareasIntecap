/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author laptop
 */
public class ConsultasDAO extends Conector {
    ConsultasVO modeloConsultas = new ConsultasVO();
    String cSql;
    String respuesta;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public ArrayList<ConsultasVO> consultas2(){
        
        ArrayList<ConsultasVO> informacion = new ArrayList<>();
        try {
            conectar();
            cSql = "SELECT l.codigo_libro, l.nombre_libro, l.editorial_libro, a.nombre_autor, "
                    + "a.nacionalidad_autor, a.genero_autor "
                    + "FROM tbl_libro AS l INNER JOIN tbl_autor AS a ON l.codigo_autor_fk = a.codigo_autor";
            ps = getMiConexion().prepareStatement(cSql);
            rs = ps.executeQuery();
            while(rs.next()){
                ConsultasVO modeloConsultas = new ConsultasVO();
                modeloConsultas.setCodigolibro(rs.getInt(1));
                modeloConsultas.setNombrelibro(rs.getString(2));
                modeloConsultas.setEditoriallibro(rs.getString(3));
                modeloConsultas.setNombreautor(rs.getString(4));
                modeloConsultas.setNacionalidadautor(rs.getString(5));
                modeloConsultas.setGeneroautor(rs.getString(6));
                informacion.add(modeloConsultas);
                
                
            }
            desconectar();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return informacion; 
        
    }
    
}
