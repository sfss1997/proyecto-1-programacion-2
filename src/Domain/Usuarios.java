/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fabian
 */
public class Usuarios {

    private SimpleStringProperty nombre;
    private SimpleStringProperty nombreUsuario;
    private SimpleStringProperty contraseña;
    private SimpleStringProperty identificacion;
    private SimpleStringProperty tipoDeIdentificacion;
    private SimpleStringProperty tipoDeUsuario;

    public Usuarios() {
    }

    public Usuarios(String nombreUsuario, String contraseña, String nombre, String tipoDeIdentificacion, String identificacion, String tipoDeUsuario) {
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
        this.contraseña = new SimpleStringProperty(contraseña);
        this.nombre = new SimpleStringProperty(nombre);
        this.tipoDeIdentificacion = new SimpleStringProperty(tipoDeIdentificacion);
        this.identificacion = new SimpleStringProperty(identificacion);
        this.tipoDeUsuario = new SimpleStringProperty(tipoDeUsuario);
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

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion.get();
    }

    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = new SimpleStringProperty(tipoDeIdentificacion);
    }

    public String getIdentificacion() {
        return identificacion.get();
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = new SimpleStringProperty(identificacion);
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario.get();
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = new SimpleStringProperty(tipoDeUsuario);
    }

    @Override
    public String toString() {
        return "Usuarios{" + "nombreUnico=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + ", nombreCompleto=" + nombre + ", tipoDeIdentificacion=" + tipoDeIdentificacion + ", identificacion=" + identificacion + ", tipoDeUsuario=" + tipoDeUsuario + '}';
    }

}
