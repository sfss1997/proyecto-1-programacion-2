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
public class Autor {

    private SimpleStringProperty nombre;
    private SimpleStringProperty apellido;
    private SimpleStringProperty libro;

    public Autor() {
    }

    public Autor(String nombre, String apellido, String libro) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.libro = new SimpleStringProperty(libro);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido = new SimpleStringProperty(apellido);
    }

    public String getLibro() {
        return libro.get();
    }

    public void setLibro(String libro) {
        this.libro = new SimpleStringProperty(libro);
    }

    @Override
    public String toString() {
        return "Autor{" + "nombre=" + nombre + ", apellido=" + apellido + ", libro=" + libro + '}';
    }

}
