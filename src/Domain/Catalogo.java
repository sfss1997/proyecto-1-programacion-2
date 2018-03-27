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
public class Catalogo implements Serializable{
    
    private SimpleStringProperty titulo;
    private LocalDate fecha;
//    private List<Object> ListaAutores;
    private SimpleStringProperty listaAutores;

    public Catalogo() {
    }

    public Catalogo(String titulo, LocalDate fecha, String ListaAutores) {
        this.titulo = new SimpleStringProperty(titulo);
        this.fecha = fecha;
        this.listaAutores = new SimpleStringProperty(ListaAutores);
    }

    public String getTitulo() {
        return titulo.get();
    }

    public void setTitulo(String titulo) {
        this.titulo = new SimpleStringProperty(titulo);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getListaAutores() {
        return listaAutores.get();
    }

    public void setListaAutores(String ListaAutores) {
        this.listaAutores = new SimpleStringProperty(ListaAutores);
    }

    @Override
    public String toString() {
        return "Catalogo{" + "titulo=" + titulo + ", fecha=" + fecha + ", ListaAutores=" + listaAutores + '}';
    }
    
    
    
    
}
