/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author fabian
 */
public class Libros {
//    libro1
    private String codigo;
    private String tema;
    private String edicion;

    public Libros() {
    }

    public Libros(String codigo, String tema, String edicion) {
        this.codigo = codigo;
        this.tema = tema;
        this.edicion = edicion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return "Libros{" + "codigo=" + codigo + ", tema=" + tema + ", edicion=" + edicion + '}';
    }
    
    
    
}
