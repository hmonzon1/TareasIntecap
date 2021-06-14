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
public class AutorDAO extends Conector {
    AutorVO modeloAutor = new AutorVO();
    String cSql;
    PreparedStatement ps;
    ResultSet rs;
    String respuesta;

    public AutorDAO() {
    }
    
    public String insertarAutor(AutorVO modeloAutor){
        try {
            conectar();
            cSql = "INSERT INTO tbl_autor (codigo_autor, nombre_autor, nacionalidad_autor, genero_autor, obrac_autor)"
                    + "VALUES(?,?,?,?,?)";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setInt(1, modeloAutor.getCodigo());
            ps.setString(2, modeloAutor.getNombre());
            ps.setString(3, modeloAutor.getNacionalidad());
            ps.setString(4, modeloAutor.getGenero());
            ps.setString(5, modeloAutor.getObra());
            ps.executeUpdate();
            respuesta = "Registro almacenado Correctamente";
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return respuesta;
    }
    
    
    public AutorVO ConsultarAutor(int codigoautor){
        AutorVO autorVO = new AutorVO();
        try {
            conectar();
            cSql = "SELECT * FROM tbl_autor WHERE codigo_autor = ?";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setInt(1, codigoautor);
            rs = ps.executeQuery();
            if (rs.next()) { 
                autorVO.setCodigo(rs.getInt("codigo_autor"));
                autorVO.setNombre(rs.getString("nombre_autor"));
                autorVO.setNacionalidad(rs.getString("nacionalidad_autor"));
                autorVO.setGenero(rs.getString("genero_autor"));
                autorVO.setObra(rs.getString("obrac_autor"));
            }else{
                JOptionPane.showMessageDialog(null,"Registro no encontrado");
                        
                        }
                
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return autorVO ;
        
    }
    
    public String eliminarAutor(AutorVO autorVO){
        try {
            conectar();
            cSql = "DELETE FROM tbl_autor WHERE codigo_autor = ?";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setInt(1, autorVO.getCodigo());
            ps.executeUpdate();
            respuesta = "Registro Eliminado";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return respuesta;
    }
    
    public String modificarAutor(AutorVO autorVO){
        try {
            conectar();
            cSql = "UPDATE tbl_autor SET nombre_autor =?, nacionalidad_autor=?, genero_autor=?, obrac_autor=? WHERE codigo_autor = ?";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setString(1, autorVO.getNombre());
            ps.setString(2, autorVO.getNacionalidad());
            ps.setString(3, autorVO.getGenero());
            ps.setString(4, autorVO.getObra());
            ps.setInt(5, autorVO.getCodigo());
            ps.executeUpdate();
            respuesta = "Registro Modificado Correctamente";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return respuesta;
        
    }
    
    public ArrayList <AutorVO> tabla(){
        
        ArrayList<AutorVO> datos = new ArrayList<>();
        try {
            conectar();
            cSql = "SELECT * FROM tbl_autor";
            ps = getMiConexion().prepareStatement(cSql);
            rs = ps.executeQuery();
            while(rs.next()){
                AutorVO modeloAutor = new AutorVO();
                modeloAutor.setCodigo(rs.getInt(1));
                modeloAutor.setNombre(rs.getString(2));
                modeloAutor.setNacionalidad(rs.getString(3));
                modeloAutor.setGenero(rs.getString(4));
                modeloAutor.setObra(rs.getString(5));
                datos.add(modeloAutor);
                
            }
            desconectar();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        
        return datos;
        
    } 
    
    public ArrayList <AutorVO> consulta2(){
        
        ArrayList<AutorVO> datos = new ArrayList<>();
        try {
            conectar();
            cSql = "SELECT * FROM tbl_autor aut";
            ps = getMiConexion().prepareStatement(cSql);
            rs = ps.executeQuery();
            while(rs.next()){
                AutorVO modeloAutor = new AutorVO();
                modeloAutor.setCodigo(rs.getInt(1));
                modeloAutor.setNombre(rs.getString(2));
                modeloAutor.setNacionalidad(rs.getString(3));
                modeloAutor.setGenero(rs.getString(4));
                modeloAutor.setObra(rs.getString(5));
                datos.add(modeloAutor);
                
            }
            desconectar();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        
        return datos;
        
    } 
    
        
        
    }

