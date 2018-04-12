/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Datos.Listas;
import static Datos.Listas.listaRelacion;
import Domain.Relacion;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author fabian
 */
public class MuestraObrasController extends Listas implements Initializable {

 
    ///Tabla
    @FXML TableView  obrasTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn tipoTableColumn;
    @FXML TableColumn autorTableColumn;
    
    //ChoiceBox
    @FXML ComboBox tiposComboBox;
    
    
    //Esto es para reconocer el numero de la fila que se selecicona en la tabla
//    private int posicionEnTabla;

    
//    FilteredList filter = new FilteredList(listaRelacion, e -> true);
   /**
     * Este metodo es el que se ejecuta apenas entra a la interfaz.
     * Es como un constructor
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializa la tabla y las columnas para que funcione
        inicializarTablaRevista();
        
        //Llena el choiceBox 
        
        llenarComboBox();

    }    
    
     /**
     * On Antion ----------------------------- Metodos que se van a utilizar como On Action
     */
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    
    public void adminObrasButton(ActionEvent event) throws IOException{
        if(!tiposComboBox.getValue().equals("Seleccione una opción"))        
            switch(tiposComboBox.getValue().toString()){
                case "Libros":
                    cambioScene(event, "/GUI/BibliotecarioObras/IBLibro.fxml");
                    break;
                case "Revistas":
                    cambioScene(event, "/GUI/BibliotecarioObras/IBRevista.fxml");
                    break;
                case "Tesis":
                    cambioScene(event, "/GUI/BibliotecarioObras/IBTesis.fxml");
                    break;
                case "Periódicos":
                    cambioScene(event, "/GUI/BibliotecarioObras/IBPeriodico.fxml");
                    break;
                case "Memorias":
                    cambioScene(event, "/GUI/BibliotecarioObras/IBMemoria.fxml");
                    break;
                case "Otras":
                    cambioScene(event, "/GUI/BibliotecarioObras/IBOtro.fxml");
                    break;
            }
        else JOptionPane.showMessageDialog(null, "Seleccione un tipo de obra.");
    }

    
    
    //Inicializa la tabla
    private void inicializarTablaRevista() {
      
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("tituloObra"));
        tipoTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("nombreUnico"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("tipoObra"));
        
        obrasTableView.setItems(listaRelacion);
    }
    
    //Codigo para cambiar de ventana
    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    public void llenarComboBox(){
        tiposComboBox.setValue("Seleccione una opción");
        tiposComboBox.getItems().add("Libros");
        tiposComboBox.getItems().add("Revistas");
        tiposComboBox.getItems().add("Tesis");
        tiposComboBox.getItems().add("Periódicos");
        tiposComboBox.getItems().add("Memorias");
        tiposComboBox.getItems().add("Otras");
      
    }

}
