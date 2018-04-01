/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fabian
 */
public class Otro extends Catalogo {
    
    
    private SimpleStringProperty tipo;

    public Otro() {
    }

    public Otro(String tipo) {
        this.tipo = new SimpleStringProperty(tipo);
    }

    public Otro(String tipo, String titulo, LocalDate fecha, String listaAutores) {
        super(titulo, fecha, listaAutores);
        this.tipo = new SimpleStringProperty(tipo);
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo = new SimpleStringProperty(tipo);
    }
    
    
    
    
    
    
}
