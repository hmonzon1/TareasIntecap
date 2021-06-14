/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author laptop
 */
public class LibrosDAO extends Conector {

    LibrosVO librosVO = new LibrosVO();
    String cSql;
    PreparedStatement ps;
    ResultSet rs;
    String respuesta;

    public LibrosDAO() {
    }
    
    public String guardarLibros(LibrosVO librosVO){
        
        try {
            conectar();
            cSql = "INSERT INTO tbl_libro (codigo_libro, nombre_libro, editorial_libro,"
                    + " paginas_libro,anio_libro,codigo_autor_fk) VALUES (?,?,?,?,?,?)";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setInt(1, librosVO.getCodigo());
            ps.setString(2, librosVO.getNombre());
            ps.setString(3, librosVO.getEditorial());
            ps.setInt(4, librosVO.getPaginas());
            ps.setString(5, librosVO.getAnio());
            ps.setInt(6, librosVO.getCodigoautor());
            ps.executeUpdate();
            respuesta = "Registro ingresado correctamente!";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return respuesta;
        
    }
    
    public LibrosVO consultarLibros(int codigoLibro){
           
        LibrosVO librosVO = new LibrosVO();
        try {
            conectar();
            cSql = "SELECT * FROM tbl_libro WHERE codigo_libro =?";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setInt(1, codigoLibro);
            rs = ps.executeQuery();
            if (rs.next()) {
                librosVO.setCodigo(rs.getInt("codigo_libro"));
                librosVO.setNombre(rs.getString("nombre_libro"));
                librosVO.setEditorial(rs.getString("editorial_libro"));
                librosVO.setPaginas(rs.getInt("paginas_libro"));
                librosVO.setAnio(rs.getString("anio_libro"));
                librosVO.setCodigoautor(rs.getInt("codigo_autor_fk"));
                
            }else{
                JOptionPane.showMessageDialog(null, "Resgistro no encontrado");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return librosVO;
    }
      

     public String eliminarLibro(LibrosVO librosVO){
            try {
             conectar();
             cSql = "DELETE FROM tbl_libro WHERE codigo_libro =?";
             ps = getMiConexion().prepareStatement(cSql);
             ps.setInt(1, librosVO.getCodigo());
             ps.executeUpdate();
             respuesta = "Registro eliminado!";
         } catch (Exception e) {
                System.err.println(e.getMessage());
         }
         
         
         return respuesta;
         
     }    
     
     public String modificarLibro(LibrosVO librosVO){
         
         try {
             conectar();
             cSql = "UPDATE tbl_libro SET nombre_libro=?, editorial_libro=?, paginas_libro=?,"
                     + "anio_libro=?, codigo_autor_fk=? WHERE codigo_libro =?";
             ps = getMiConexion().prepareStatement(cSql);
             ps.setString(1, librosVO.getNombre());
             ps.setString(2, librosVO.getEditorial());
             ps.setInt(3, librosVO.getPaginas());
             ps.setString(4, librosVO.getAnio());
             ps.setInt(5, librosVO.getCodigoautor());
             ps.setInt(6, librosVO.getCodigo());
             ps.executeUpdate();
             respuesta = "Registro Modificado Correctamente!";
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         
         
         return respuesta;
         
         
     }
     
     public ArrayList<LibrosVO>tabla(){
         
         ArrayList<LibrosVO> datos = new ArrayList<>(); 
         try {
             conectar();
             cSql = "SELECT * FROM tbl_libro";
             ps = getMiConexion().prepareStatement(cSql);
             rs = ps.executeQuery();
             while(rs.next()){
                 LibrosVO modeloLibros = new LibrosVO();
                 modeloLibros.setCodigo(rs.getInt(1));
                 modeloLibros.setNombre(rs.getString(2));
                 modeloLibros.setEditorial(rs.getString(3));
                 modeloLibros.setPaginas(rs.getInt(4));
                 modeloLibros.setAnio(rs.getString(5));
                 modeloLibros.setCodigoautor(rs.getInt(6));
                 datos.add(modeloLibros);
                 
                 
             }
             desconectar();
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         
         return datos;
         
     }
     
   
    
     
     
}
