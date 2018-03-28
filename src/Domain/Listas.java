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
    
    public static List<Object> usuariosList = new LinkedList<Object>();
    public static ObservableList<Libros> ObrasList = FXCollections.observableArrayList();

    public Listas() {
    }

    public static List<Object> getUsuariosList() {
        return usuariosList;
    }

    public static void setUsuariosList(List<Object> usuariosList) {
        Listas.usuariosList = usuariosList;
    }

    public static ObservableList<Libros> getObrasList() {
        return ObrasList;
    }

    public static void setObrasList(ObservableList<Libros> ObrasList) {
        Listas.ObrasList = ObrasList;
    }
    
    
    
}
