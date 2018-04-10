/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hvill
 */
public class Libro {
    
    private SimpleStringProperty nombre;
    private SimpleStringProperty autor;
    private SimpleStringProperty categoria;

    public Libro() {
    }
    
    
    
    public Libro(String nombre, String autor, String categoria) {
        this.nombre = new SimpleStringProperty(nombre);
        this.autor = new SimpleStringProperty(autor);
        this.categoria = new SimpleStringProperty(categoria);
    }
    
    public String getNombre() {
        return nombre.get();
    }
    
    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }
    
    public String getAutor() {
        return autor.get();
    }
    
    public void setAutor(String autor) {
        this.autor = new SimpleStringProperty(autor);
    }
    
    public String getCategoria() {
        return categoria.get();
    }
    
    public void setCategoria(String categoria) {
        this.categoria = new SimpleStringProperty(categoria);
    }
    
}
