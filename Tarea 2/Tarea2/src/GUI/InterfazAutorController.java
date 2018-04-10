/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.Autor;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class InterfazAutorController implements Initializable {

    //TableView y TableColumns
    @FXML TableView autorTableView;
    @FXML TableColumn autorTableColumnNombre;
    @FXML TableColumn autorTableColumnApellido;
    @FXML TableColumn autorTableColumnLibro;
    private ObservableList<Autor> listaAutores = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTablaAutor();
    }    
    
    public void salir(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    private void inicializarTablaAutor(){
        autorTableColumnNombre.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombre"));
        autorTableColumnApellido.setCellValueFactory(new PropertyValueFactory<Autor, String>("apellido"));
        autorTableColumnLibro.setCellValueFactory(new PropertyValueFactory<Autor, String>("libro"));
        
        autorTableView.setItems(llenarTablaAutor());
    }

    private ObservableList llenarTablaAutor(){
        
        listaAutores.add(new Autor("J.R.R.", "Tolkien", "EL Señor de los Anillos (saga)"));
        listaAutores.add(new Autor("J.R.R.", "Tolkien", "El Hobbit"));
        listaAutores.add(new Autor("J.R.R.", "Tolkien", "Los Hijos de Durin"));
        listaAutores.add(new Autor("J.R.R.", "Tolkien", "El Silmarillion"));
        listaAutores.add(new Autor("J.K.", "Rowling", "Harry Potter (saga)"));
        listaAutores.add(new Autor("Stephen", "King", "It"));
        listaAutores.add(new Autor("Gabriel", "García Marquez", "Cien años de soledad"));
        listaAutores.add(new Autor("Dan", "Brown", "El código Da Vinvi"));
        listaAutores.add(new Autor("George R.R.", "Martin", "Canciones de Hielo y Fuego (saga)"));

        return listaAutores;
    }
    
}
