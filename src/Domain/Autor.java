/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fabian
 */
public class Autor extends Usuarios {

    private SimpleStringProperty listaObras;

    public Autor() {
    }

    public Autor(String nombreCompleto, String nombreUnico, String contraseña,
            String identificacion, String tipoDeIdentificacion, String tipoDeUsuario, String listaObras) {
        super(nombreCompleto, nombreUnico, contraseña, identificacion, tipoDeIdentificacion, tipoDeUsuario);
        this.listaObras = new SimpleStringProperty(listaObras);
    }

    public String getListaObras() {
        return listaObras.get();
    }

    public void setListaObras(String listaObras) {
        this.listaObras = new SimpleStringProperty(listaObras);
    }

    @Override
    public String toString() {
        return "Autor{" + "listaObras=" + listaObras + '}';
    }

}
