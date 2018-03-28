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
    
    private List<Object> listaObrasEscritas;

    public Autor() {
    }

    public Autor(List<Object> listaObrasEscritas) {
        this.listaObrasEscritas = listaObrasEscritas;
    }

    public Autor(List<Object> listaObrasEscritas, String nombreUnico, String contraseña, String nombreCompleto, 
            String tipoDeIdentificacion, String identificacion, String tipoDeUsuario) {
        super(nombreUnico, contraseña, nombreCompleto, tipoDeIdentificacion, identificacion, tipoDeUsuario);
        this.listaObrasEscritas = listaObrasEscritas;
    }

    public List<Object> getListaObrasEscritas() {
        return listaObrasEscritas;
    }

    public void setListaObrasEscritas(List<Object> listaObrasEscritas) {
        this.listaObrasEscritas = listaObrasEscritas;
    }
    
    


  
    
    
}
