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
public class Periodicos {
    
    private String issn;
    private String edicion;
    private String fecha;

    public Periodicos() {
    }

    public Periodicos(String issn, String edicion, String fecha) {
        this.issn = issn;
        this.edicion = edicion;
        this.fecha = fecha;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Periodicos{" + "issn=" + issn + ", edicion=" + edicion + ", fecha=" + fecha + '}';
    }
    
    
}
