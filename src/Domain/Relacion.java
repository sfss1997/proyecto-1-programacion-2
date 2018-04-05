 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fabian
 */
public class Relacion {
    
    private SimpleStringProperty tituloObra;
    private SimpleStringProperty nombreUnico;
    private SimpleStringProperty tipoObra;

    public Relacion() {
    }

    public Relacion(String tituloObra, String nombreUnico, String tipoObra) {
        this.tituloObra = new SimpleStringProperty(tituloObra);
        this.nombreUnico = new SimpleStringProperty(nombreUnico);
        this.tipoObra = new SimpleStringProperty(tipoObra);
    }

    public String getTituloObra() {
        return tituloObra.get();
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = new SimpleStringProperty(tituloObra);
    }

    public String getNombreUnico() {
        return nombreUnico.get();
    }

    public void setNombreUnico(String nombreUnico) {
        this.nombreUnico = new SimpleStringProperty(nombreUnico);
    }
    
    public String getTipoObra() {
        return tipoObra.get();
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = new SimpleStringProperty(tipoObra);
    }
    
}
