/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Datos.Listas;
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
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class InterfazBibliotecarioController extends Listas implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    //Volver a la ventana principal
    public void salirButton(ActionEvent event) throws IOException{
        buscaUsuarioActivo();
        cambioScene(event, "/GUI/Principal.fxml");
    }
    
    private void buscaUsuarioActivo(){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getEstado().equals("activo"))
                listaUsuarios.get(i).setEstado("inactivo");
        }
    }
    
    /**
     * Obras
     */
    
    //Cambiar a la ventada de libros
    public void libroButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioObras/IBLibro.fxml");
    }
    
    //Cambiar a la ventada de revistas
    public void revistaButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioObras/IBRevista.fxml");
    }
    
    //Cambiar a la ventada de tesis
    public void tesisButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioObras/IBTesis.fxml");
    }
    
    //Cambiar a la ventada de periodicos
    public void periodicoButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioObras/IBPeriodico.fxml");
    }
    
    //Cambiar a la ventada de memorias
    public void memoriaButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioObras/IBMemoria.fxml");
    }
    
    //Cambiar a la ventada de memorias
    public void otroButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioObras/IBOtro.fxml");
    }
    
    /**
     * Usuarios
     */
    
    //Cambiar a la ventada de memorias
    public void bibliotecarioButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/IBBibliotecario.fxml");
    }
    
    //Cambiar a la ventada de memorias
    public void autorButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/IBAutor.fxml");
    }
    
    //Cambiar a la ventada de memorias
    public void clienteButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/IBCliente.fxml");
    }
    
    //Cambiar a la ventada de memorias
    public void prestamoButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/ObrasPrestamos.fxml");
    }
    
    //Cambiar a la ventada de memorias
    public void morososButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/IBCliente.fxml");
    }
    
    //Cambiar a la ventada de memorias
    public void listaObrasButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/MuestraObras.fxml");
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
