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
public class Memorias extends Catalogo{
    
    private SimpleStringProperty resumen;
    private SimpleStringProperty abstracto;
    private SimpleStringProperty conferencia;

    public Memorias() {
    }

    public Memorias(SimpleStringProperty resumen, SimpleStringProperty abstracto, SimpleStringProperty conferencia) {
        this.resumen = resumen;
        this.abstracto = abstracto;
        this.conferencia = conferencia;
    }

    public Memorias(SimpleStringProperty resumen, SimpleStringProperty abstracto, SimpleStringProperty conferencia, SimpleStringProperty titulo, LocalDate fecha, List<Object> ListaAutores) {
        super(titulo, fecha, ListaAutores);
        this.resumen = resumen;
        this.abstracto = abstracto;
        this.conferencia = conferencia;
    }

    public SimpleStringProperty getResumen() {
        return resumen;
    }

    public void setResumen(SimpleStringProperty resumen) {
        this.resumen = resumen;
    }

    public SimpleStringProperty getAbstracto() {
        return abstracto;
    }

    public void setAbstracto(SimpleStringProperty abstracto) {
        this.abstracto = abstracto;
    }

    public SimpleStringProperty getConferencia() {
        return conferencia;
    }

    public void setConferencia(SimpleStringProperty conferencia) {
        this.conferencia = conferencia;
    }

    
    
}
