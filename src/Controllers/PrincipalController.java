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
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

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
        boolean x = false;
        if(nombreUsuarioTextField.getText().equals("") ||
                contraseñaPasswordField.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Complete los espacios.");
        else{
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if(listaUsuarios.get(i).getNombreUsuario().equals(nombreUsuarioTextField.getText()) &&
                   listaUsuarios.get(i).getContraseña().equals(DigestUtils.md5Hex(contraseñaPasswordField.getText()))){
                    x = true;
                    listaUsuarios.get(i).setEstado("activo");
                    
                    if(listaUsuarios.get(i).getTipoDeUsuario().equals("Bibliotecario"))
                        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
                    if(listaUsuarios.get(i).getTipoDeUsuario().equals("Autor"))
                        cambioScene(event, "/GUI/InterfazAutor.fxml");
                    if(listaUsuarios.get(i).getTipoDeUsuario().equals("Cliente"))
                        cambioScene(event, "/GUI/InterfazCliente.fxml");

                }   
            }
            if(x == false) JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecto.\nIntente de nuevo.");
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
