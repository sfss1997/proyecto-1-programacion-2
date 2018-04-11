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
import java.time.LocalDate;
import java.util.Date;
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
    
    private LocalDate fecha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializarTablaClientes();
        revisaMorosos();
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
        
        clientesTableView.setItems(llenarTabla());
    }
    
    private ObservableList llenarTabla(){
        ObservableList<Prestamo> lista = FXCollections.observableArrayList();
        
        for (int i = 0; i < listaPrestamo.size(); i++) {
           
            if(listaPrestamo.get(i).getEstado().equals("Vencido")){
                lista.add(listaPrestamo.get(i));
            }
        }
        return lista;
    }

    public void revisaMorosos() {


        for (int i = 0; i < listaPrestamo.size(); i++) {
            if (LocalDate.now().isAfter(listaPrestamo.get(i).getFechaVencimiento())) {
                   listaPrestamo.get(i).setEstado("Vencido");
            }
        }

    }

    public void volverButton(ActionEvent event) throws IOException {
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    public void adminUsuariosButton(ActionEvent event) throws IOException {
        cambioScene(event, "/GUI/ObrasPrestamos.fxml");
        
    }
    
    

    private void cambioScene(ActionEvent event, String destino) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
