/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Datos.Listas.listaPrestamo;
import static Datos.Listas.listaRelacion;
import Domain.Prestamo;
import Domain.Relacion;
import java.io.IOException;
import java.net.URL;
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
 * @author fabian
 */
public class UsuariosMorososController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     
    ///Tabla
    @FXML TableView  clientesTableView;
    @FXML TableColumn nombreTableColumn;
    @FXML TableColumn fechaPrestamoTableColumn;
    @FXML TableColumn fechaVencimientoTableColumn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializarTablaClientes();
    }   
    
        //Inicializa la tabla
    private void inicializarTablaClientes() {
        //Solo hay que hacerlo con las columnas
        //Ejemplo:
//  nombre del TableColumb.setCellValueFactory(new PropertyValueFactory
//  < El objeto que se va a usar en la tabla, El tipo del elemnto >( El nombre de la variable, tiene que ser igual al que está en la clase del objeto ));
        
        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("nombreUnico"));
        fechaPrestamoTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("fechaPrestamo"));
        fechaVencimientoTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("fechaVencimiento"));
        
        clientesTableView.setItems(listaPrestamo);
    }
    
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
