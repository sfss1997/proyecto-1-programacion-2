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
    
    private SimpleStringProperty nombreUnico;
    private SimpleStringProperty contraseña;
    private SimpleStringProperty nombreCompleto;
    private SimpleStringProperty tipoDeIdentificacion;
    private SimpleStringProperty identificacion;
    private SimpleStringProperty tipoDeUsuario;

    public Usuarios() {
    }

    public Usuarios(SimpleStringProperty nombreUnico, SimpleStringProperty contraseña, SimpleStringProperty nombreCompleto, SimpleStringProperty tipoDeIdentificacion, SimpleStringProperty identificacion, SimpleStringProperty tipoDeUsuario) {
        this.nombreUnico = nombreUnico;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.identificacion = identificacion;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public SimpleStringProperty getNombreUnico() {
        return nombreUnico;
    }

    public void setNombreUnico(SimpleStringProperty nombreUnico) {
        this.nombreUnico = nombreUnico;
    }

    public SimpleStringProperty getContraseña() {
        return contraseña;
    }

    public void setContraseña(SimpleStringProperty contraseña) {
        this.contraseña = contraseña;
    }

    public SimpleStringProperty getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(SimpleStringProperty nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public SimpleStringProperty getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(SimpleStringProperty tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public SimpleStringProperty getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(SimpleStringProperty identificacion) {
        this.identificacion = identificacion;
    }

    public SimpleStringProperty getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(SimpleStringProperty tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "nombreUnico=" + nombreUnico + ", contrase\u00f1a=" + contraseña + ", nombreCompleto=" + nombreCompleto + ", tipoDeIdentificacion=" + tipoDeIdentificacion + ", identificacion=" + identificacion + ", tipoDeUsuario=" + tipoDeUsuario + '}';
    }

    
 
    
    
    
    
    
}
