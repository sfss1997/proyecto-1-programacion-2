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
public class Usuario {

    private SimpleStringProperty nombreUsuario;
    private SimpleStringProperty contraseña;
    private SimpleStringProperty nombreCompleto;
    private SimpleStringProperty id;
    private SimpleStringProperty tipoUsuario;

    public Usuario(String nombreUsuario, String contraseña, String nombreCompleto, String id, String tipoUsuario) {
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
        this.contraseña = new SimpleStringProperty(contraseña);
        this.nombreCompleto = new SimpleStringProperty(nombreCompleto);
        this.id = new SimpleStringProperty(id);
        this.tipoUsuario = new SimpleStringProperty(tipoUsuario);
    }

    public String getNombreUsuario() {
        return nombreUsuario.get();
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
    }

    public String getContraseña() {
        return contraseña.get();
    }

    public void setContraseña(String contraseña) {
        this.contraseña = new SimpleStringProperty(contraseña);
    }

    public String getNombreCompleto() {
        return nombreCompleto.get();
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = new SimpleStringProperty(nombreCompleto);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public String getTipoUsuario() {
        return tipoUsuario.get();
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = new SimpleStringProperty(tipoUsuario);
    }

}
