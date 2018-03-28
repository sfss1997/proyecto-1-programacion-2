/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hvill
 */
public class Bibliotecario extends Usuarios{
    
    public Bibliotecario(){
    }
    
    public Bibliotecario(String nombreUnico, String contraseña, String nombreCompleto, String tipoDeIdentificacion, 
            String identificacion, String tipoDeUsuario){
        super(nombreUnico, contraseña, nombreCompleto, tipoDeIdentificacion, identificacion, tipoDeUsuario);
    }
}
