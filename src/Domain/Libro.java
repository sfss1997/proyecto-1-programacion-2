/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fabian
 */
public class Libro extends Catalogo {
//    libro1
    private SimpleStringProperty isbn;
    private SimpleStringProperty tema;
    private SimpleStringProperty subtema;

    public Libro() {
    }


    public Libro(String isbn, String tema, String subtema) {
        this.isbn = new SimpleStringProperty(isbn);
        this.tema = new SimpleStringProperty(tema);
        this.subtema = new SimpleStringProperty(subtema);

    }

    public Libro(String isbn, String tema, String subtema, String titulo, LocalDate fecha, String ListaAutores) {
        
        super(titulo, fecha, ListaAutores);
        this.isbn = new SimpleStringProperty(isbn);
        this.tema = new SimpleStringProperty(tema);
        this.subtema = new SimpleStringProperty(subtema);

    }

    public String getIsbn() {
        return isbn.get();
    }

    public void setIsbn(String isbn) {
        this.isbn = new SimpleStringProperty(isbn);
    }


    public String getTema() {
        return tema.get();
    }

    public void setTema(String tema) {
        this.tema = new SimpleStringProperty(tema);
    }

    public String getSubtema() {
        return subtema.get();
    }

    public void setSubtema(String subtema) {
        this.subtema = new SimpleStringProperty(subtema);
    }

    
    
}
