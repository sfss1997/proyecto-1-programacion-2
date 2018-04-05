/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Datos.Listas;
import Domain.Libro;
import Domain.Relacion;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class InterfazAutorController extends Listas implements Initializable {

    
    
    //Tabla
    @FXML TableView obrasDeAutorTableView;
    @FXML TableColumn nombreTableColumn;
    @FXML TableColumn categoriaTableColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        inicializarTablaLibro();
    }  
    
    //Volver a la ventana principal
    public void salirButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/Principal.fxml");
    }
    
    private void inicializarTablaLibro(){
        //Solo hay que hacerlo con las columnas
        //Ejemplo:
//  nombre del TableColumb.setCellValueFactory(new PropertyValueFactory
//  < El objeto que se va a usar en la tabla, El tipo del elemnto >( El nombre de la variable, tiene que ser igual al que está en la clase del objeto ));
        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("nombreUnico"));
        categoriaTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("tipoObra"));
        
        obrasDeAutorTableView.setItems(super.listaRelacion);
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
    
}
