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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author hvill
 */
public class PrincipalController extends Listas implements Initializable {
    
    
    @FXML TextField nombreUsuarioTextField;
    
    @FXML PasswordField contraseñaPasswordField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    public void iniciarButton(ActionEvent event) throws IOException{
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getNombreUsuario().equals(nombreUsuarioTextField.getText()) &&
               listaUsuarios.get(i).getContraseña().equals(contraseñaPasswordField.getText())){
                listaUsuarios.get(i).setEstado("activo");
                System.out.println(listaUsuarios.get(i).getNombreUsuario()+ "  " + listaUsuarios.get(i).getEstado());
                if(listaUsuarios.get(i).getTipoDeUsuario().equals("Bibliotecario"))
                    cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
                if(listaUsuarios.get(i).getTipoDeUsuario().equals("Autor"))
                    cambioScene(event, "/GUI/InterfazAutor.fxml");
                if(listaUsuarios.get(i).getTipoDeUsuario().equals("Cliente"))
                    cambioScene(event, "/GUI/InterfazCliente.fxml");
            }
        }
        
    }
    
    public void bibliotecario(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    public void autor(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazAutor.fxml");
    }
    
    public void cliente(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazCliente.fxml");
    }
    
    //Cambiar a la ventada de bibliotecario
    public void registrarseButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazRegistrarse.fxml");
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
