/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hvill
 */
public class CabezaGanado {

    private SimpleStringProperty nombre;
    private SimpleStringProperty sexo;
    private LocalDate nacimiento;
    private SimpleStringProperty raza;
    private SimpleStringProperty padre;
    private SimpleStringProperty madre;

    public CabezaGanado() {
    }

    public CabezaGanado(String nombre, String sexo, String raza, LocalDate nacimiento, String padre, String madre) {
        this.nombre = new SimpleStringProperty(nombre);
        this.sexo = new SimpleStringProperty(sexo);
        this.nacimiento = nacimiento;
        this.raza = new SimpleStringProperty(raza);
        this.padre = new SimpleStringProperty(padre);
        this.madre = new SimpleStringProperty(madre);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getSexo() {
        return sexo.get();
    }

    public void setSexo(String sexo) {
        this.sexo = new SimpleStringProperty(sexo);
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getRaza() {
        return raza.get();
    }

    public void setRaza(String raza) {
        this.raza = new SimpleStringProperty(raza);
    }

    public String getPadre() {
        return padre.get();
    }

    public void setPadre(String padre) {
        this.padre = new SimpleStringProperty(padre);
    }

    public String getMadre() {
        return madre.get();
    }

    public void setMadre(String madre) {
        this.madre = new SimpleStringProperty(madre);
    }

}
