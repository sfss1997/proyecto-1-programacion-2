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
public class Autor extends Usuarios{
    
    private List<Libro> listaObrasEscritas;

    public Autor() {
    }

    public Autor(List<Libro> listaObrasEscritas) {
        this.listaObrasEscritas = listaObrasEscritas;
    }

    public Autor(List<Libro> listaObrasEscritas, String nombreUnico, String contraseña, String nombreCompleto, 
            String tipoDeIdentificacion, String identificacion, String tipoDeUsuario) {
        super(nombreUnico, contraseña, nombreCompleto, tipoDeIdentificacion, identificacion, tipoDeUsuario);
        this.listaObrasEscritas = listaObrasEscritas;
    }

    public String getListaObrasEscritas() {
        String salida = "";
        for(int i = 0; i<listaObrasEscritas.size(); i++){
            Libro libro = new Libro();
            salida = listaObrasEscritas.get(i).getTitulo() + ", ";
        }
        return salida;
    }
    
    public List<Libro> getListaObras(){
        return listaObrasEscritas;
    }

    public void setListaObrasEscritas(List<Libro> listaObrasEscritas) {
        this.listaObrasEscritas = listaObrasEscritas;
    }
    
    


  
    
    
}
