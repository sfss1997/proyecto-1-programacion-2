/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author fabian
 */
public class Memorias {
    
    private String resumen;
    private String abstracto;
    private String conferencia;

    public Memorias() {
    }

    public Memorias(String resumen, String abstracto, String conferencia) {
        this.resumen = resumen;
        this.abstracto = abstracto;
        this.conferencia = conferencia;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getAbstracto() {
        return abstracto;
    }

    public void setAbstracto(String abstracto) {
        this.abstracto = abstracto;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    @Override
    public String toString() {
        return "Memorias{" + "resumen=" + resumen + ", abstracto=" + abstracto + ", conferencia=" + conferencia + '}';
    }
    
    
}
