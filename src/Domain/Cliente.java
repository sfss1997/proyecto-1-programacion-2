/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fabian
 */
public class Cliente extends Usuarios {
    
    private List<Object> listaLibrosPrestados;

    public Cliente() {
    }

    public Cliente(List<Object> listaLibrosPrestados) {
        this.listaLibrosPrestados = listaLibrosPrestados;
    }

    public Cliente(String nombre, String nombreUsuario, String contraseña, String identificacion, String tipoDeIdentificacion, String tipoDeUsuario){
        super(nombre, nombreUsuario, contraseña, identificacion, tipoDeIdentificacion, tipoDeUsuario);
    }
    
    

    
    
    
}
