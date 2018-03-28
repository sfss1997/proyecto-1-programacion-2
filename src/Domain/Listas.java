/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fabian
 */
public class Listas {
    
    public static List<Object> usuariosList = new LinkedList<Object>();
    public static List<Object> ObrasList = new LinkedList<Object>();

    public Listas() {
    }

    public static List<Object> getUsuariosList() {
        return usuariosList;
    }

    public static void setUsuariosList(List<Object> usuariosList) {
        Listas.usuariosList = usuariosList;
    }

    public static List<Object> getObrasList() {
        return ObrasList;
    }

    public static void setObrasList(List<Object> ObrasList) {
        Listas.ObrasList = ObrasList;
    }
    
    
    
}
