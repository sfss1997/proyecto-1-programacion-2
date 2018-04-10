/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import laboratorio1.Frutas;

/**
 *
 * @author hvill
 */
public class CalcuFrutaController implements Initializable {
    
    @FXML ComboBox primerFrutaComboBox;
    @FXML ComboBox segundaFrutaComboBox;
    
    @FXML RadioButton sumaRadioButton;
    @FXML RadioButton restaRadioButton;
    private ToggleGroup radioButtonSeleccionado;
    
    @FXML Label resultadoLabel;
    
    private ArrayList<Frutas> listaFrutas;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        radioButtonSeleccionado = new ToggleGroup();
        sumaRadioButton.setToggleGroup(radioButtonSeleccionado);
        restaRadioButton.setToggleGroup(radioButtonSeleccionado);
        
        llenarLista();
        llenarComboBox();
    }  
    
    private void llenarLista(){
        listaFrutas = new ArrayList<>();
        for (Frutas value : Frutas.values()) {
            listaFrutas.add(value);
        }
    }
    
    private void llenarComboBox(){
        for (int i = 0; i < listaFrutas.size(); i++) {
            primerFrutaComboBox.getItems().add(listaFrutas.get(i));
            segundaFrutaComboBox.getItems().add(listaFrutas.get(i));
        }
    }
    
}
