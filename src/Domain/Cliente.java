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

    public Cliente(List<Object> listaLibrosPrestados, String nombreUnico, String contraseña, String nombreCompleto, 
            String tipoDeIdentificacion, String identificacion, String tipoDeUsuario) {
        super(nombreUnico, contraseña, nombreCompleto, tipoDeIdentificacion, identificacion, tipoDeUsuario);
        this.listaLibrosPrestados = listaLibrosPrestados;
    }
    
    

    
    
    
}
