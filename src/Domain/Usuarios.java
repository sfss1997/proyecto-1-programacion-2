/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author fabian
 */
public class Usuarios {
    
    private String nombreUnico;
    private String contraseña;
    private String nombreCompleto;
    private String tipoDeIdentificacion;
    private String identificacion;

    public Usuarios() {
    }

    public Usuarios(String nombreUnico, String contraseña, String nombreCompleto, String tipoDeIdentificacion, String identificacion) {
        this.nombreUnico = nombreUnico;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.tipoDeIdentificacion = tipoDeIdentificacion;
        this.identificacion = identificacion;
    }

    public String getNombreUnico() {
        return nombreUnico;
    }

    public void setNombreUnico(String nombreUnico) {
        this.nombreUnico = nombreUnico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "nombreUnico=" + nombreUnico + ", contrase\u00f1a=" + contraseña + ", nombreCompleto=" + nombreCompleto + ", tipoDeIdentificacion=" + tipoDeIdentificacion + ", identificacion=" + identificacion + '}';
    }
    
    
    
    
    
}
