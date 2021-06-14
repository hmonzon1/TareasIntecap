/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author laptop
 */
public class ConsultasVO {
    
    //variables tabla libro
    private int codigolibro;
    private String nombrelibro;
    private String editoriallibro;
    //private int paginaslibro;
    //private String aniolibro;
   // private int codigoautorfk;
    
    //variables tabla autor
   // private int codigoautor;
    private String nombreautor;
    private String nacionalidadautor;
    private String generoautor;
    //private String obraautor;

    public ConsultasVO(int codigolibro, String nombrelibro, String editoriallibro, String nombreautor, String nacionalidadautor, String generoautor) {
        this.codigolibro = codigolibro;
        this.nombrelibro = nombrelibro;
        this.editoriallibro = editoriallibro;
        this.nombreautor = nombreautor;
        this.nacionalidadautor = nacionalidadautor;
        this.generoautor = generoautor;
    }

    public ConsultasVO() {
    }

    public int getCodigolibro() {
        return codigolibro;
    }

    public void setCodigolibro(int codigolibro) {
        this.codigolibro = codigolibro;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public String getEditoriallibro() {
        return editoriallibro;
    }

    public void setEditoriallibro(String editoriallibro) {
        this.editoriallibro = editoriallibro;
    }

    public String getNombreautor() {
        return nombreautor;
    }

    public void setNombreautor(String nombreautor) {
        this.nombreautor = nombreautor;
    }

    public String getNacionalidadautor() {
        return nacionalidadautor;
    }

    public void setNacionalidadautor(String nacionalidadautor) {
        this.nacionalidadautor = nacionalidadautor;
    }

    public String getGeneroautor() {
        return generoautor;
    }

    public void setGeneroautor(String generoautor) {
        this.generoautor = generoautor;
    }
    
    
    

   
    
    
    
}
