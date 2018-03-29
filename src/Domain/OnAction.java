 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.IOException;
import javafx.event.ActionEvent;

/**
 *
 * @author hvill
 */
public interface OnAction {
    public void agregarButton();
    public void modificarButton();
    public void eliminarButton();
    public void limpiarButton();
    public void volverButton(ActionEvent event) throws IOException;
    
}
