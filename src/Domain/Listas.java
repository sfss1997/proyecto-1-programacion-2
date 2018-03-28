/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author fabian
 */
public class Listas {
    
    public static List<Object> listaUsuarios = new LinkedList<Object>();
    public static ObservableList<Libro> listaLibros = FXCollections.observableArrayList();

    public Listas() {
    }

    public static List<Object> getUsuariosList() {
        return listaUsuarios;
    }

    public static void setUsuariosList(List<Object> usuariosList) {
        Listas.listaUsuarios = usuariosList;
    }

    public static ObservableList<Libro> getListaLibros() {
        return listaLibros;
    }

    public static void setListaLibros(ObservableList<Libro> listaLibros) {
        Listas.listaLibros = listaLibros;
    }
    
    
    
}
