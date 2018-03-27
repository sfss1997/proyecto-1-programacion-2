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
public class Tesis {
    private String resumen;
    private String abstracto;

    public Tesis() {
    }

    public Tesis(String resumen, String abstracto) {
        this.resumen = resumen;
        this.abstracto = abstracto;
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

    @Override
    public String toString() {
        return "Tesis{" + "resumen=" + resumen + ", abstracto=" + abstracto + '}';
    }
    
    
}
