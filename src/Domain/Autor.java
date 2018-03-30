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
public class Autor extends Usuarios{
    
    private ArrayList<Object> listaObrasEscritas;
    private SimpleStringProperty listaObras;

    public Autor() {
    }

    public Autor(ArrayList<Object> listaObrasEscritas) {
        this.listaObrasEscritas = listaObrasEscritas;
    }

    public Autor(String listaObras, String nombreUnico, String contraseña, String nombreCompleto, 
            String tipoDeIdentificacion, String identificacion, String tipoDeUsuario) {
        super(nombreUnico, contraseña, nombreCompleto, tipoDeIdentificacion, identificacion, tipoDeUsuario);
        this.listaObras = new SimpleStringProperty(listaObras);
    }

    public String getListaObras() {
        return listaObras.get();
    }

    public void setListaObras(String listaObras) {
        this.listaObras = new SimpleStringProperty(listaObras);
    }
    
    
    public ArrayList<Object> getListaObrasEscritas(){
        return listaObrasEscritas;
    }

    public void setListaObrasEscritas(ArrayList<Object> listaObrasEscritas) {
        this.listaObrasEscritas = listaObrasEscritas;
    }

    @Override
    public String toString() {
        return "Autor{" + "listaObras=" + listaObras + '}';
    }
    
    


  
    
    
}
