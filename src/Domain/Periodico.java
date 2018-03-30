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
public class Periodico extends Catalogo {
    
    private SimpleStringProperty isbn;
    private SimpleStringProperty edicion;
    

    public Periodico() {
    }

    public Periodico(String isbn, String edicion) {
        this.isbn = new SimpleStringProperty(isbn);
        this.edicion = new SimpleStringProperty(edicion);
    }

    public Periodico(String isbn, String edicion, String titulo, LocalDate fecha, String listaAutores) {
        super(titulo, fecha, listaAutores);
        this.isbn = new SimpleStringProperty(isbn);
        this.edicion = new SimpleStringProperty(edicion);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public void setIsbn(String issn) {
        this.isbn = new SimpleStringProperty(issn);
    }

    public String getEdicion() {
        return edicion.get();
    }

    public void setEdicion(String edicion) {
        this.edicion = new SimpleStringProperty(edicion);
    }
    
    
    

}
