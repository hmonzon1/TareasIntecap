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
public class LibrosVO {
    
    private int codigo;
    private String nombre;
    private String editorial;
    private  int paginas;
    private String anio;
    private int codigoautor;

    public LibrosVO() {
    }

    public LibrosVO(int codigo, String nombre, String editorial, String anio, int codigoautor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.editorial = editorial;
        this.anio = anio;
        this.codigoautor = codigoautor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public  int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getCodigoautor() {
        return codigoautor;
    }

    public void setCodigoautor(int codigoautor) {
        this.codigoautor = codigoautor;
    }
    
    
}
