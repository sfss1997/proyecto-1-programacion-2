/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.Autor;
import domain.Cliente;
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
public class InterfazUsuarioController implements Initializable {

//TableView y TableColumns
    @FXML TableView clienteTableView;
    @FXML TableColumn clienteTableColumnNombre;
    @FXML TableColumn clienteTableColumnLibro;
    private ObservableList<Cliente> listaCliente = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTablaCliente();
    }    
    
    public void salir(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    private void inicializarTablaCliente(){
        clienteTableColumnNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        clienteTableColumnLibro.setCellValueFactory(new PropertyValueFactory<Cliente, String>("libroPrestado"));
        
        clienteTableView.setItems(llenarTablaCliente());
    }

    private ObservableList llenarTablaCliente(){
        listaCliente.add(new Cliente("Laura Sanchez", "Cien años de soledad"));
        return listaCliente;
    }   
    
}
