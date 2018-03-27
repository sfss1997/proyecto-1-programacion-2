/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Domain.Libros;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class IBLibroController implements Initializable {

    //Tabla
    @FXML TableView libroTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn temaTableColumn;
    @FXML TableColumn subTemaTableColumn;
    @FXML TableColumn autorTableColumn;
    @FXML TableColumn fechaTableColumn;
    @FXML TableColumn codigoTableColumn;
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField temaTextField;
    @FXML TextField subTemaTextField;
    @FXML TextField codigoTextField;
    
    //DatePicker
    @FXML DatePicker fechaDatePicker;
    
    //ChoiceBox
    @FXML ChoiceBox autorChoiceBox;
    
    //Lista para la tabla
    private ObservableList<Libros> listaLibros = FXCollections.observableArrayList();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTablaLibro();
        llenarChoiceBox();
    }
    
    /**
     * On Antion
     */
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    public void agregarButton(){
        Libros libro = new Libros(codigoTextField.getText(), 
                                  temaTextField.getText(), 
                                  subTemaTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorChoiceBox.getValue().toString());
        listaLibros.add(libro);
    }
    
    /**
     * Metodos
     */
    
    //Inicializa la tabla
    private void inicializarTablaLibro(){
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Libros, String>("titulo"));
        temaTableColumn.setCellValueFactory(new PropertyValueFactory<Libros, String>("tema"));
        subTemaTableColumn.setCellValueFactory(new PropertyValueFactory<Libros, String>("subtema"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Libros, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Libros, LocalDate>("fecha"));
        codigoTableColumn.setCellValueFactory(new PropertyValueFactory<Libros, String>("isbn"));
        
        libroTableView.setItems(llenarTablaLibros());
    }
    
    private ObservableList llenarTablaLibros(){
        listaLibros.add(new Libros("a", "a", "a", "a", LocalDate.MIN, "a"));
        return listaLibros;
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
    
    private void llenarChoiceBox(){
        autorChoiceBox.getItems().add("aaaa");
    }
    
}
