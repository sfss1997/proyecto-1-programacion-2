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
public class Revistas {
    private String issn;
    private String edicion;

    public Revistas() {
    }

    public Revistas(String issn, String edicion) {
        this.issn = issn;
        this.edicion = edicion;
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

    @Override
    public String toString() {
        return "Revistas{" + "issn=" + issn + ", edicion=" + edicion + '}';
    }
    
    
    
}
