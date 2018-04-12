/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Datos.Listas;
import static Datos.Listas.listaPrestamo;
import Domain.Autor;
import Domain.Libro;
import Domain.Prestamo;
import Domain.Relacion;
import Domain.Usuarios;
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
public class InterfazAutorController extends Listas implements Initializable {

    @FXML Label nombreLabel;
    @FXML Label nombreUsuarioLabel;
    @FXML Label iDLabel;
    @FXML Label tipoIDLabel;
    
    //Tabla
    @FXML TableView obrasDeAutorTableView;
    @FXML TableColumn nombreTableColumn;
    @FXML TableColumn categoriaTableColumn;
    
    @FXML TableView prestamoTableView;
    @FXML TableColumn nombreObraTableColumn;
    @FXML TableColumn categoriaObraTableColumn;
    @FXML TableColumn fechaDevolucionObraTableColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        modificaLabel();
        inicializarTablaObrasEscritas();
        inicializaTablaObrasPrestadas();
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
    
    //Volver a la ventana principal
    public void salirButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/Principal.fxml");
    }
    
    private void inicializarTablaObrasEscritas(){
        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("tituloObra"));
        categoriaTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("tipoObra"));
        
        obrasDeAutorTableView.setItems(llenaTablaObrasEscritas());
    }
    private void inicializaTablaObrasPrestadas(){
        nombreObraTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("titulo"));
        categoriaObraTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("tema"));
        fechaDevolucionObraTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, LocalDate>("fecha"));
        
        prestamoTableView.setItems(llenaTablaObrasPrestadas());
    }
    
    private ObservableList llenaTablaObrasPrestadas(){
        ObservableList lista = FXCollections.observableArrayList();
        for (int i = 0; i < listaPrestamo.size(); i++) {
            if(nombreUsuarioLabel.getText().equals(listaPrestamo.get(i).getNombreUnico()))
                lista.add(listaPrestamo.get(i));
        }
        return lista;
    }
    
    private ObservableList llenaTablaObrasEscritas(){
        ObservableList<Relacion> lista = FXCollections.observableArrayList();
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getNombreUnico().equals(buscaUsuarioActivo().getNombre())){
                lista.add(listaRelacion.get(i));
            }
        }
        return lista;
    }
    
    private Usuarios buscaUsuarioActivo(){
        Usuarios autor = new Usuarios();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getEstado().equals("activo"))
                autor = listaUsuarios.get(i);
        }
        return autor;
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
