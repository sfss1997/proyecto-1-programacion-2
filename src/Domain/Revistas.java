/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fabian
 */
public class Revistas extends Catalogo {
    
    private SimpleStringProperty issn;
    private SimpleStringProperty edicion;

    public Revistas() {
    }

    public Revistas(String isbn, String edicion) {
        this.issn = new SimpleStringProperty(isbn);
        this.edicion = new SimpleStringProperty(edicion);
    }

    public Revistas(String issn, String edicion, String titulo, LocalDate fecha, String ListaAutores) {    
        super(titulo, fecha, ListaAutores);
        this.issn = new SimpleStringProperty(issn);
        this.edicion = new SimpleStringProperty(edicion);
    }

    public String getIssn() {
        return issn.get();
    }

    public void setIssn(String isbn) {
        this.issn = new SimpleStringProperty(isbn);
    }

    public String getEdicion() {
        return edicion.get();
    }

    public void setEdicion(String edicion) {
        this.edicion = new SimpleStringProperty(edicion);
    }

    
    
}
