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
public class Cliente {
    
    private SimpleStringProperty nombre;
    private SimpleStringProperty libroPrestado;

    public Cliente(String nombre, String libroPrestado) {
        this.nombre = new SimpleStringProperty(nombre);
        this.libroPrestado = new SimpleStringProperty(libroPrestado);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getLibroPrestado() {
        return libroPrestado.get();
    }

    public void setLibroPrestado(String libroPrestado) {
        this.libroPrestado = new SimpleStringProperty(libroPrestado);
    }
    
    
    
}
