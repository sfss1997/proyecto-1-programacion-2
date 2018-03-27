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
public class Catalogo {
    
    private SimpleStringProperty titulo;
    private LocalDate fecha;
    private List<Object> ListaAutores;

    public Catalogo() {
    }

    public Catalogo(SimpleStringProperty titulo, LocalDate fecha, List<Object> ListaAutores) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.ListaAutores = ListaAutores;
    }

    public SimpleStringProperty getTitulo() {
        return titulo;
    }

    public void setTitulo(SimpleStringProperty titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Object> getListaAutores() {
        return ListaAutores;
    }

    public void setListaAutores(List<Object> ListaAutores) {
        this.ListaAutores = ListaAutores;
    }

    @Override
    public String toString() {
        return "Catalogo{" + "titulo=" + titulo + ", fecha=" + fecha + ", ListaAutores=" + ListaAutores + '}';
    }
    
    
    
    
}
