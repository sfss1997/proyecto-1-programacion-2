/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Datos.Listas;
import static Datos.Listas.listaPrestamo;
import static Datos.Listas.listaUsuarios;
import Domain.Usuarios;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class InterfazBibliotecarioController extends Listas implements Initializable {

    
    @FXML Label nombreLabel;
    @FXML Label nombreUsuarioLabel;
    @FXML Label iDLabel;
    @FXML Label tipoIDLabel;
    
    @FXML TableView prestamoTableView;
    @FXML TableColumn nombreObraTableColumn;
    @FXML TableColumn categoriaObraTableColumn;
    @FXML TableColumn fechaDevolucionObraTableColumn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modificaLabel();
    }   
    
    //Volver a la ventana principal
    public void salirButton(ActionEvent event) throws IOException{
        buscaUsuarioActivo().setEstado("inactivo");
        cambioScene(event, "/GUI/Principal.fxml");
    }
    
    private Usuarios buscaUsuarioActivo(){
        Usuarios autor = new Usuarios();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getEstado().equals("activo"))
                autor = listaUsuarios.get(i);
        }
        return autor;
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
        

        for (int i = 0; i < listaPrestamo.size(); i++) {
            if (LocalDate.now().isAfter(listaPrestamo.get(i).getFechaVencimiento())) {
                   listaPrestamo.get(i).setEstado("Vencido");
            }
        }
        cambioScene(event, "/GUI/UsuariosMorosos.fxml");
    }
    
    //Cambiar a la ventada de memorias
    public void listaObrasButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/MuestraObras.fxml");
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
