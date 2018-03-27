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
public class Usuario extends Usuarios {
    
    private List<Object> listaLibrosPrestados;

    public Usuario() {
    }

    public Usuario(List<Object> listaLibrosPrestados) {
        this.listaLibrosPrestados = listaLibrosPrestados;
    }

    public Usuario(List<Object> listaLibrosPrestados, SimpleStringProperty nombreUnico, SimpleStringProperty contraseña, SimpleStringProperty nombreCompleto, SimpleStringProperty tipoDeIdentificacion, SimpleStringProperty identificacion, SimpleStringProperty tipoDeUsuario) {
        super(nombreUnico, contraseña, nombreCompleto, tipoDeIdentificacion, identificacion, tipoDeUsuario);
        this.listaLibrosPrestados = listaLibrosPrestados;
    }
    
    

    
    
    
}
