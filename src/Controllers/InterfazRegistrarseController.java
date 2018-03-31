/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Datos.Listas;
import Domain.Autor;
import Domain.Cliente;
import Domain.Usuarios;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class InterfazRegistrarseController extends Listas implements Initializable {

    @FXML TextField nombreTextField;
    @FXML TextField nombreUsuarioTextField;
    @FXML TextField contraseñaTextField;
    @FXML TextField iDTextField;
    
    @FXML ComboBox tipoIDComboBox;
    @FXML ComboBox tipoUsuarioComboBox;
    
    @FXML Label avisoLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        llenarComboBox();
    }  
    
    /**
     * On Action. 
     */
    
    public void registrarseButton(ActionEvent event) throws IOException{
        Usuarios nuevoUsuario = new Usuarios(nombreUsuarioTextField.getText(), 
                                             contraseñaTextField.getText(), 
                                             nombreTextField.getText(), 
                                             tipoIDComboBox.getValue().toString(), 
                                             iDTextField.getText(), 
                                             tipoUsuarioComboBox.getValue().toString());
        
        if(verificaInformacion() == true){
            super.listaUsuarios.add(nuevoUsuario);
            verificaTipoUsuario();
            cambioScene(event, "/GUI/Principal.fxml");
        }
        else
            System.out.println("caca");
    }
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/Principal.fxml");
    }
    
    /**
     * Metodos.
     */
    
    private void llenarComboBox(){
        tipoIDComboBox.getItems().addAll("Seleccione una opción", "Cedula");
        tipoUsuarioComboBox.getItems().addAll("Seleccione una opción", "Autor", "Cliente");
        
        tipoIDComboBox.setValue("Seleccione una opción");
        tipoUsuarioComboBox.setValue("Seleccione una opción");
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
    
    private boolean verificaInformacion(){
        if(nombreTextField.getText().equals("") ||
           nombreUsuarioTextField.getText().equals("") ||
           contraseñaTextField.getText().equals("") ||
           tipoIDComboBox.getValue().toString().equals("Seleccione una opción") ||
           iDTextField.getText().equals("") ||
           tipoUsuarioComboBox.getValue().toString().equals("Seleccione una opción")){
            
            avisoLabel.setText("Rellene todas las\nopciones");
            return false;
        }
        if(verificaUsuarioExistente() == true){
            avisoLabel.setText("Nombre de usuario\nya existe\nIngrese otro");
            return false;
        }
        return true;
    }
    
    private boolean verificaUsuarioExistente(){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(nombreUsuarioTextField.getText().equals(listaUsuarios.get(i).getNombreUsuario()))
                return true;
        }
        return false;
    }
    
    private void verificaTipoUsuario(){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println("caca x2");
                Autor autor = new Autor();
                Cliente cliente = new Cliente();
                if(listaUsuarios.get(i).getTipoDeUsuario().equals("Autor")){
                    autor.setNombre(listaUsuarios.get(i).getNombre());
                    autor.setNombreUsuario(listaUsuarios.get(i).getNombreUsuario());
                    autor.setContraseña(listaUsuarios.get(i).getContraseña());
                    autor.setIdentificacion(listaUsuarios.get(i).getIdentificacion());
                    autor.setTipoDeIdentificacion(listaUsuarios.get(i).getTipoDeIdentificacion());
                    autor.setTipoDeUsuario(listaUsuarios.get(i).getTipoDeUsuario());
                    autor.setListaObras("Ninguno");
                    listaAutores.add(autor);
                }
                if(listaUsuarios.get(i).getTipoDeUsuario().equals("Cliente")){
                    cliente.setNombre(listaUsuarios.get(i).getNombre());
                    cliente.setNombreUsuario(listaUsuarios.get(i).getNombreUsuario());
                    cliente.setContraseña(listaUsuarios.get(i).getContraseña());
                    cliente.setIdentificacion(listaUsuarios.get(i).getIdentificacion());
                    cliente.setTipoDeIdentificacion(listaUsuarios.get(i).getTipoDeIdentificacion());
                    cliente.setTipoDeUsuario(listaUsuarios.get(i).getTipoDeUsuario());
                    listaClientes.add(cliente);
                }
            }
    }
}
