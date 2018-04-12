/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Datos.Listas;
import static Datos.Listas.listaUsuarios;
import Domain.Libro;
import Domain.Prestamo;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class InterfazClienteController extends Listas implements Initializable {

    //Tabla
    @FXML TableView prestamoTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn categoriaTableColumn;
    @FXML TableColumn fechaTableColumn;
    
    //Label
    @FXML Label nombreLabel;
    @FXML Label nombreUsuarioLabel;
    @FXML Label tipoIDLabel;
    @FXML Label iDLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inicializaTabla();
        modificaLabel();
                
        
    }    
    
    private void modificaLabel(){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getEstado().equals("activo")){
                nombreLabel.setText(listaUsuarios.get(i).getNombre());
                nombreUsuarioLabel.setText(listaUsuarios.get(i).getNombreUsuario());
                tipoIDLabel.setText(listaUsuarios.get(i).getTipoDeIdentificacion());
                iDLabel.setText(listaUsuarios.get(i).getIdentificacion());
            }
        }
    }
    
    //Cambiar a la ventada de bibliotecario
    public void salirButton(ActionEvent event) throws IOException{
        buscaUsuarioActivo();
        cambioScene(event, "/GUI/Principal.fxml");
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
    
    private void buscaUsuarioActivo(){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getEstado().equals("activo"))
                listaUsuarios.get(i).setEstado("inactivo");
        }
    }
    
    private void inicializaTabla(){
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("titulo"));
        categoriaTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("tema"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, LocalDate>("fecha"));
        
        prestamoTableView.setItems(llenaTabla());
    }
    
    private ObservableList llenaTabla(){
        ObservableList lista = FXCollections.observableArrayList();
        for (int i = 0; i < listaPrestamo.size(); i++) {
            if(nombreUsuarioLabel.getText().equals(listaPrestamo.get(i).getNombreUnico()))
                lista.add(listaPrestamo.get(i));
        }
        return lista;
    }
    
}
