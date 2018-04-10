/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import com.sun.javafx.css.converters.StringConverter;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author hvill
 */
public class FXMLVistaController implements Initializable {
    
    //Buttons
    @FXML private Button eliminarBT;
    @FXML private Button modificarBT;
    @FXML private Button agregarBT;
    @FXML private Button cruzarBT;
    @FXML private Button limpiarBT;
    
    //Label
    @FXML private Label mensajeLB;
    
    //TextField
    @FXML private TextField nombreTF;
    
    //RadioButton
    @FXML private RadioButton machoRB;
    @FXML private RadioButton hembraRB;
    private ToggleGroup seleccionRadioButton; //Esto es un grupo para los RadioButton, solo se puede seleccionar
                                              //un RadioButton por grupo
    
    //ComboBox
    @FXML private ChoiceBox razaCB;
    @FXML private ComboBox padreCB;
    @FXML private ComboBox madreCB;
    
    //DatePicker
    @FXML private DatePicker nacimientoDP;
    
    //Tabla
    @FXML private TableView<CabezaGanado> tablaGanadoTV;
    @FXML private TableColumn<CabezaGanado, String> nombreTC;
    @FXML private TableColumn<CabezaGanado, String> sexoTC;
    @FXML private TableColumn<CabezaGanado, String> razaTC;
    @FXML private TableColumn<CabezaGanado, LocalDate> nacimientoTC;
    @FXML private TableColumn<CabezaGanado, String> padreTC;
    @FXML private TableColumn<CabezaGanado, String> madreTC;
    ObservableList<CabezaGanado> listaCabezaGanado = FXCollections.observableArrayList();
    
    private int posicionGanadoEnTabla;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mensajeLB.setText("");
        nacimientoDP.setEditable(false);
        modificarBT.setDisable(true);
        limpiarBT.setDisable(true);
        
        
        
        //Preparar las columnas de la tabla
        this.nombreTC.setCellValueFactory(new PropertyValueFactory<CabezaGanado, String>("nombre"));
        this.sexoTC.setCellValueFactory(new PropertyValueFactory<CabezaGanado, String>("sexo"));
        this.razaTC.setCellValueFactory(new PropertyValueFactory<CabezaGanado, String>("raza"));
        this.nacimientoTC.setCellValueFactory(new PropertyValueFactory<CabezaGanado, LocalDate>("nacimiento"));
        this.padreTC.setCellValueFactory(new PropertyValueFactory<CabezaGanado, String>("padre"));
        this.madreTC.setCellValueFactory(new PropertyValueFactory<CabezaGanado, String>("madre"));
        //Llenar la tabla con valores predeterminados
        tablaGanadoTV.setItems(getGanado());
        
        //Configuración de los RadioButtons
        seleccionRadioButton = new ToggleGroup();
        //Se añaden todos los RadioButtons al ToggleGroup
        this.machoRB.setToggleGroup(seleccionRadioButton);
        this.hembraRB.setToggleGroup(seleccionRadioButton);
        
        //Llenar el ChoiceBox de raza
        razaCB.getItems().addAll("Angus", "Criollo", "Lidia", "Holstein", "Jersey", "Búfalo", "Mixta");
        
        padreComboBox();
        madreComboBox();
        
        
    }   
    
    /**
     * 
     * ---------------------- On Action ----------------------
     * 
     */
    
    public void agregarButton(){
        CabezaGanado nuevaCabezaGanado = new CabezaGanado();
        nuevaCabezaGanado.setNombre(nombreTF.getText());
        nuevaCabezaGanado.setSexo(verificaRadioButton());
        nuevaCabezaGanado.setRaza(razaCB.getValue().toString());
        nuevaCabezaGanado.setNacimiento(nacimientoDP.getValue());
        nuevaCabezaGanado.setPadre(padreCB.getValue().toString());
        nuevaCabezaGanado.setMadre(madreCB.getValue().toString());
        
        listaCabezaGanado.add(nuevaCabezaGanado);
        actualizarPadreComboBox();
        actualizarMadreComboBox();
        actualizarRazaChoiceBox();
        mensajeLB.setText("Se agregó una nueva cabeza de ganado");
    }
 
    public void limpiarButton(){
        mensajeLB.setText("");
        nombreTF.setText("");
        seleccionRadioButton.getSelectedToggle().setSelected(false);
    }
    
    public void eliminarButton(){
        ObservableList<CabezaGanado> selectedRows, ganado;
        ganado = tablaGanadoTV.getItems();
        
        //Esto nos da las filas seleccionadas
        selectedRows = tablaGanadoTV.getSelectionModel().getSelectedItems();
        
        //recorrer las filas seleccionadas y remove la perona de la tabla
        for(CabezaGanado cabeza: selectedRows){
            ganado.remove(cabeza);
        }
        actualizarPadreComboBox();
        actualizarMadreComboBox();
    }
    
    public void cruzarButton(){
        CabezaGanado nuevaCabezaGanado = new CabezaGanado();
        nuevaCabezaGanado.setNombre(nombreTF.getText());
        nuevaCabezaGanado.setSexo(verificaRadioButton());
        nuevaCabezaGanado.setRaza(razaCB.getValue().toString());
        nuevaCabezaGanado.setNacimiento(nacimientoDP.getValue());
        nuevaCabezaGanado.setPadre(padreCB.getValue().toString());
        nuevaCabezaGanado.setMadre(madreCB.getValue().toString());
        
        listaCabezaGanado.add(nuevaCabezaGanado);
        actualizarPadreComboBox();
        actualizarMadreComboBox();
        actualizarRazaChoiceBox();
        mensajeLB.setText("Se agregó una nueva cabeza de ganado");
    }
    
/**
* 
* ---------------------- Metodos ----------------------
* 
*/
    
    private ObservableList<CabezaGanado> getGanado(){
        ObservableList<CabezaGanado> ganado = listaCabezaGanado;
        ganado.add(new CabezaGanado("Casimiro", "Macho", "Jersey", LocalDate.of(2005, Month.OCTOBER, 7), "Desconocido", "Desconocido"));
        ganado.add(new CabezaGanado("Buenavista", "Macho", "Angus", LocalDate.of(2003, Month.SEPTEMBER, 14), "Desconocido", "Desconocido"));
        ganado.add(new CabezaGanado("Violeta", "Hembra", "Holstein", LocalDate.of(2008, Month.MAY, 22), "Desconocido", "Desconocido"));
        ganado.add(new CabezaGanado("Blanca", "Hembra", "Lidia", LocalDate.of(2007, Month.JANUARY, 10), "Desconocido", "Desconocido"));
        ganado.add(new CabezaGanado("Niebla", "Hembra", "Holstein", LocalDate.of(2009, Month.JULY, 23), "Desconocido", "Desconocido"));

        return ganado;
    }
    
    public void padreComboBox(){
        padreCB.getItems().add("Desconocido");
        for(CabezaGanado cabeza : listaCabezaGanado){
                if(cabeza.getSexo().equals("Macho"))
                    padreCB.getItems().add(cabeza.getNombre());      
        }
    }
    
    public void madreComboBox(){
        madreCB.getItems().add("Desconocido");
        for(CabezaGanado cabeza : listaCabezaGanado){
            if(cabeza.getSexo().equals("Hembra"))
                madreCB.getItems().add(cabeza.getNombre());
        }
    }
    
    private void actualizarPadreComboBox(){
        padreCB.getItems().clear();
        padreComboBox();
    }
    
    private void actualizarMadreComboBox(){
        madreCB.getItems().clear();
        madreComboBox();
    }
    
    private String verificaRadioButton(){
        String salida = "";
        if(this.seleccionRadioButton.getSelectedToggle().equals(this.machoRB))
            salida = "Macho";
        if(this.seleccionRadioButton.getSelectedToggle().equals(this.hembraRB))
            salida = "Hembra";
        return salida;
    }
    
    private boolean verificaPadreChoiceBox(CabezaGanado cabeza){
        boolean verifica = false;
        for(CabezaGanado cabezaG : listaCabezaGanado){
            if(cabeza.getNombre().equals(cabezaG.getNombre()))
                verifica = true;
        }
        return verifica;
    }
    
    private CabezaGanado getObjetoDeLista(String nombre, ObservableList lista){
        CabezaGanado objeto = new CabezaGanado();
        for(CabezaGanado cabeza : listaCabezaGanado){
            if(cabeza.getNombre().equals(nombre))
                objeto = cabeza;
        }
        return objeto;
    }
    
    private void actualizarRazaChoiceBox(){
        razaCB.getItems().clear();
        razaCB.getItems().addAll("Angus", "Criollo", "Lidia", "Holstein", "Jersey", "Búfalo", "Mixta");
    }
    
}
