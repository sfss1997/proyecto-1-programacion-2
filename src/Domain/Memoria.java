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
public class Memoria extends Catalogo{
    
    private SimpleStringProperty resumen;
    private SimpleStringProperty abstracto;
    private SimpleStringProperty conferencia;

    public Memoria() {
    }

    public Memoria(String resumen,String abstracto, String conferencia) {
        this.resumen = new SimpleStringProperty(resumen);
        this.abstracto = new SimpleStringProperty(abstracto);
        this.conferencia = new SimpleStringProperty(conferencia);
    }

    public Memoria(String resumen, String abstracto, String conferencia, String titulo, LocalDate fecha, String ListaAutores) {
        super(titulo, fecha, ListaAutores);
        this.resumen = new SimpleStringProperty(resumen);
        this.abstracto = new SimpleStringProperty(abstracto);
        this.conferencia = new SimpleStringProperty(conferencia);
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

    public String getConferencia() {
        return conferencia.get();
    }

    public void setConferencia(String conferencia) {
        this.conferencia = new SimpleStringProperty(conferencia);
    }

    
    
}
