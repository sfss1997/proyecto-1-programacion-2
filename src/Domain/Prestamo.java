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
public class Prestamo {

    
        private SimpleStringProperty tituloObra;
        private SimpleStringProperty nombreUnico;
        private SimpleStringProperty tipoObra;
        private SimpleStringProperty estado;
        private LocalDate fechaPrestamo;
        private LocalDate fechaVencimiento;
    
    public Prestamo(String tituloObra,String nombreUnico, String tipoObra,String estado, LocalDate fechaPrestamo, LocalDate fechaVencimiento) {
        this.tituloObra = new SimpleStringProperty(tituloObra);
        this.nombreUnico = new SimpleStringProperty(nombreUnico);
        this.tipoObra = new SimpleStringProperty(tipoObra);
        this.estado = new SimpleStringProperty(estado);
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
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
    
    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado = new SimpleStringProperty(estado);
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    

    
    
    
    
    
}
