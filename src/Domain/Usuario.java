/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.List;

/**
 *
 * @author fabian
 */
public class Usuario extends Usuarios {
    
    private List<Object> listaLibrosPrestados;

    public Usuario() {
    }
    
    public Usuario(List<Object> listaLibrosPrestados) {
        this.listaLibrosPrestados = listaLibrosPrestados;
    }

    public Usuario(String nombreUnico, String contraseña, String nombreCompleto, String tipoDeIdentificacion, String identificacion) {
        super(nombreUnico, contraseña, nombreCompleto, tipoDeIdentificacion, identificacion);
    }

    public Usuario(List<Object> listaLibrosPrestados, String nombreUnico, String contraseña, String nombreCompleto, String tipoDeIdentificacion, String identificacion) {
        super(nombreUnico, contraseña, nombreCompleto, tipoDeIdentificacion, identificacion);
        this.listaLibrosPrestados = listaLibrosPrestados;
    }

    public List<Object> getListaLibrosPrestados() {
        return listaLibrosPrestados;
    }

    public void setListaLibrosPrestados(List<Object> listaLibrosPrestados) {
        this.listaLibrosPrestados = listaLibrosPrestados;
    }

    @Override
    public String toString() {
        return "Usuario{" + "listaLibrosPrestados=" + listaLibrosPrestados + '}';
    }
    
    
    
    
}
