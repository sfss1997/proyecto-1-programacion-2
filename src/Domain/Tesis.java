/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fabian
 */
public class Tesis extends Catalogo {
    
    private SimpleStringProperty resumen;
    private SimpleStringProperty abstracto;

    public Tesis() {
    }

    public Tesis(String resumen, String abstracto) {
        this.resumen = new SimpleStringProperty(resumen);
        this.abstracto = new SimpleStringProperty(abstracto);
    }

    public Tesis(String resumen, String abstracto, String titulo, LocalDate fecha, String ListaAutores) {
        super(titulo, fecha, ListaAutores);
        this.resumen = new SimpleStringProperty(resumen);
        this.abstracto = new SimpleStringProperty(abstracto);
    }

    public String getResumen() {
        return resumen.get();
    }

    public void setResumen(String resumen) {
        this.resumen = new SimpleStringProperty(resumen);
    }

    public String getAbstracto() {
        return abstracto.get();
    }

    public void setAbstracto(String abstracto) {
        this.abstracto = new SimpleStringProperty(abstracto);
    }

    

    
}
