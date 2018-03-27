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

    public Revistas(SimpleStringProperty issn, SimpleStringProperty edicion) {
        this.issn = issn;
        this.edicion = edicion;
    }

    public Revistas(SimpleStringProperty issn, SimpleStringProperty edicion, String titulo, LocalDate fecha, String ListaAutores) {
        super(titulo, fecha, ListaAutores);
        this.issn = issn;
        this.edicion = edicion;
    }

    public SimpleStringProperty getIssn() {
        return issn;
    }

    public void setIssn(SimpleStringProperty issn) {
        this.issn = issn;
    }

    public SimpleStringProperty getEdicion() {
        return edicion;
    }

    public void setEdicion(SimpleStringProperty edicion) {
        this.edicion = edicion;
    }

    
    
}
