/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author laptop
 */
public class PaisDAO extends Conector {
     PaisVO mpais = new PaisVO();
     String cSql;
     PreparedStatement ps;
     ResultSet rs;
     String respuesta;

    public PaisDAO() {
    }
     
     public  String insertarPais(PaisVO mpais){ 
         try {
             conectar();
             cSql = "INSERT INTO tbl_pais(id_pais,nombre_pais,capital_pais,poblacion_pais)VALUES (?,?,?,?)";
             ps = getMiConexion().prepareStatement(cSql);
             ps.setInt(1, mpais.getId_pais());
             ps.setString(2, mpais.getNombre_pais());
             ps.setString(3, mpais.getCapital_pais());
             ps.setLong(4, mpais.getPoblacion_pais());
             ps.executeUpdate();
             respuesta = "Registro almacenado Correctamente";
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         
         return respuesta;
     }
     
     public PaisVO consultarPais(int idpais){
         PaisVO paisvo = new PaisVO();
         try {
             conectar();
             cSql = "SELECT * FROM tbl_pais WHERE id_pais = ?";
             ps = getMiConexion().prepareStatement(cSql);
             ps.setInt(1, idpais);
             rs = ps.executeQuery();
             if (rs.next()) {
                 paisvo.setId_pais(rs.getInt("id_pais"));
                 paisvo.setNombre_pais(rs.getString("nombre_pais"));
                 paisvo.setCapital_pais(rs.getString("capital_pais"));
                 paisvo.setPoblacion_pais(rs.getLong("poblacion_pais"));
             }else{
                 String respuesta = "Registro no encontrado";
                 
             }
             
         } catch (Exception e) {
             System.err.println("Mensaje de Consulta: "+e.getMessage());
         }
         
         return paisvo;
     }
     
     public String modificarPais(PaisVO paisvo){
         try {
             conectar();
             cSql = "UPDATE tbl_pais SET nombre_pais=?, capital_pais=?, poblacion_pais=? WHERE id_pais =?";
             ps = getMiConexion().prepareStatement(cSql);
             ps.setString(1, paisvo.getNombre_pais());
             ps.setString(2, paisvo.getCapital_pais());
             ps.setLong(3, paisvo.getPoblacion_pais());
             ps.setInt(4, paisvo.getId_pais());
             ps.executeUpdate();
             respuesta = "Registro Modificado correctamente";
         } catch (Exception e) {
             System.err.println("Mensaje de Modificacion"+e.getMessage());
         }
         return respuesta;
         
     }
     
     public String eliminarPais(PaisVO paisvo){
         try {
             conectar();
             cSql = "DELETE FROM tbl_pais WHERE id_pais =?";
             ps = getMiConexion().prepareStatement(cSql);
             ps.setInt(1, paisvo.getId_pais());
             ps.executeUpdate();
             respuesta = "Eliminado Correctamente";
         } catch (Exception e) {
             System.err.println("Mensaje de Eliminacion: "+e.getMessage());
         }
         return respuesta;
     }
     
     public ArrayList<PaisVO> tabla(){
         
         ArrayList<PaisVO> registros = new ArrayList<>();
         try {
             conectar();
             cSql = "SELECT * FROM tbl_pais";
             ps = getMiConexion().prepareStatement(cSql);
             rs = ps.executeQuery();
             while(rs.next()){
                 PaisVO paisvo = new PaisVO();
                 paisvo.setId_pais(rs.getInt(1));
                 paisvo.setNombre_pais(rs.getString(2));
                 paisvo.setCapital_pais(rs.getString(3));
                 paisvo.setPoblacion_pais(rs.getLong(4));
                 registros.add(paisvo);
             }
             desconectar();
         } catch (Exception e) {
             System.err.println("Mensaje de Error tabla: "+e.getMessage());
         }
         
         return registros;
         
     }
     
     //variable publica necesaria
    public JasperViewer jv;
    //metodo para el reporte
    public void reporteD(){
        try {
            conectar();
            //variable que encuentra el reporte
            JasperReport reporte;
            String ruta = "C:\\Users\\laptop\\Documents\\NetBeansProjects\\CrudPais\\src\\reportes\\reportePaises.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jp = JasperFillManager.fillReport(ruta,null,con);
            JasperViewer jv = new JasperViewer(jp);
            this.jv = jv;
            
        } catch (Exception e) {
            System.err.println("error"+e.getMessage());
        }
       
        
        
        
        
        
    }
     
     
     
     

    private PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
