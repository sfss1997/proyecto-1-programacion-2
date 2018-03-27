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
public class Libros extends Catalogo {
//    libro1
    private SimpleStringProperty isbn;
    private SimpleStringProperty tema;
    private SimpleStringProperty subtema;

    public Libros() {
    }

    public Libros(SimpleStringProperty isbn, SimpleStringProperty tema, SimpleStringProperty subtema) {
        this.isbn = isbn;
        this.tema = tema;
        this.subtema = subtema;
    }

    public Libros(SimpleStringProperty isbn, SimpleStringProperty codigo, SimpleStringProperty tema, SimpleStringProperty subtema, SimpleStringProperty titulo, LocalDate fecha, List<Object> ListaAutores) {
        super(titulo, fecha, ListaAutores);
        this.isbn = isbn;
        this.tema = tema;
        this.subtema = subtema;
    }

    public SimpleStringProperty getIsbn() {
        return isbn;
    }

    public void setIsbn(SimpleStringProperty isbn) {
        this.isbn = isbn;
    }


    public SimpleStringProperty getTema() {
        return tema;
    }

    public void setTema(SimpleStringProperty tema) {
        this.tema = tema;
    }

    public SimpleStringProperty getSubtema() {
        return subtema;
    }

    public void setSubtema(SimpleStringProperty subtema) {
        this.subtema = subtema;
    }

    
    
}