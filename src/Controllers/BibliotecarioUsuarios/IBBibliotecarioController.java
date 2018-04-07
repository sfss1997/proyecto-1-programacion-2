/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioUsuarios;

import Datos.Listas;
import static Datos.Listas.listaLibros;
import Domain.Bibliotecario;
import Domain.OnAction;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class IBBibliotecarioController extends Listas implements Initializable, OnAction {

    @FXML TableView bibliotecarioTableView;
    @FXML TableColumn nombreTableColumn;
    @FXML TableColumn nombreUsuarioTableColumn;
    @FXML TableColumn contraseñaTableColumn;
    @FXML TableColumn iDTableColumn;
    @FXML TableColumn tipoIDTableColumn;
    @FXML TableColumn tipoUsuarioTableColumn;
    
    @FXML TextField nombreTextField;
    @FXML TextField nombreUsuarioTextField;
    @FXML TextField contraseñaTextField;
    @FXML TextField iDTextField;
    @FXML TextField tipoUsuarioTextField;
    
    @FXML ComboBox tipoIDComboBox;
    
    @FXML Label avisoLabel;
    
    private int posicionEnTabla;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTabla();
        tipoIDComboBox.getItems().addAll("Seleccione una opción", "Cedula");
        tipoIDComboBox.setValue("Seleccione una opción");
        
        final ObservableList<Bibliotecario> tablaLibroSel = bibliotecarioTableView.getSelectionModel().getSelectedItems();
        tablaLibroSel.addListener(selectorTablaLibros);
    }
    
    @Override
    public void agregarButton() {
        Bibliotecario nuevoBibliotecario = new Bibliotecario(nombreTextField.getText(), 
                                                             nombreUsuarioTextField.getText(), 
                                                             contraseñaTextField.getText(), 
                                                             iDTextField.getText(), 
                                                             tipoIDComboBox.getValue().toString(), 
                                                             tipoUsuarioTextField.getText());
        if(verificaInformacion() == true)
            if(verificaUsuarioExistente() == false){
                listaBibliotecarios.add(nuevoBibliotecario);
                listaUsuarios.add(nuevoBibliotecario);
                limpiarButton();
            }
    }

    @Override
    public void modificarButton() {
        Bibliotecario nuevoBibliotecario = new Bibliotecario(nombreTextField.getText(), 
                                                             nombreUsuarioTextField.getText(), 
                                                             contraseñaTextField.getText(), 
                                                             iDTextField.getText(), 
                                                             tipoIDComboBox.getValue().toString(), 
                                                             tipoUsuarioTextField.getText());
        modificarUsuarioBibliotecario(nuevoBibliotecario);
        listaBibliotecarios.set(posicionEnTabla, nuevoBibliotecario);
        
        limpiarButton();
    }

    @Override
    public void eliminarButton() {
        if(verificaUsuarioActivo() == false){
            final Bibliotecario bibliotecario = getTablaLibrosSeleccionado();
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if(bibliotecario.getNombreUsuario().equals(listaUsuarios.get(i).getNombreUsuario()))
                    listaUsuarios.remove(i);
            }
            listaBibliotecarios.remove(posicionEnTabla);
            limpiarButton();
            
        }
    }

    @Override
    public void limpiarButton() {
        nombreTextField.setText("");
        nombreUsuarioTextField.setText("");
        contraseñaTextField.setText("");
        iDTextField.setText("");
        tipoIDComboBox.setValue("Seleccione una opción");
        avisoLabel.setText("");
    }
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    

    
    
    /**
     * Metodos.
     */
    
    private void modificarUsuarioBibliotecario(Bibliotecario bibliotecario){
        final Bibliotecario b = getTablaLibrosSeleccionado();
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getNombreUsuario().equals(b.getNombreUsuario())){
                listaUsuarios.get(i).setNombre(bibliotecario.getNombre());
                listaUsuarios.get(i).setNombreUsuario(bibliotecario.getNombreUsuario());
                listaUsuarios.get(i).setContraseña(bibliotecario.getContraseña());
                listaUsuarios.get(i).setIdentificacion(bibliotecario.getIdentificacion());
                listaUsuarios.get(i).setTipoDeIdentificacion(bibliotecario.getTipoDeIdentificacion());
                listaUsuarios.get(i).setTipoDeUsuario(bibliotecario.getTipoDeUsuario());
            }
        }
    }
    
    private boolean verificaUsuarioActivo(){
        final Bibliotecario bibliotecario = getTablaLibrosSeleccionado();
        if(bibliotecario.getEstado().equals("activo")){
            avisoLabel.setText("Este usuario está activo\nNo puede ser eliminado");
            return true;
        }
        return false;
    }
    
    private boolean verificaInformacion(){
        if(nombreTextField.getText().equals("") ||
           nombreUsuarioTextField.getText().equals("") ||
           contraseñaTextField.getText().equals("") ||
           iDTextField.getText().equals("") ||
           tipoIDComboBox.getValue().equals("Seleccione una opción")){
            avisoLabel.setText("Complete todos los espacios");
            return false;
        }
        return true;
    }
    
    private boolean verificaUsuarioExistente(){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(nombreUsuarioTextField.getText().equals(listaUsuarios.get(i).getNombreUsuario())){
                avisoLabel.setText("El usuario ya existe\nIngrese otro");
                return true;
            }
        }
        return false;
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
    
    public void inicializarTabla(){
        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("nombre"));
        nombreUsuarioTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("nombreUsuario"));
        contraseñaTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("contraseña"));
        iDTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("identificacion"));
        tipoIDTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("tipoDeIdentificacion"));
        tipoUsuarioTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("tipoDeUsuario"));
        
        bibliotecarioTableView.setItems(super.listaBibliotecarios);
    }
    
    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Bibliotecario> selectorTablaLibros =
            new ListChangeListener<Bibliotecario>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Bibliotecario> c) {
                    ponerLibroSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Bibliotecario getTablaLibrosSeleccionado() {
        if (bibliotecarioTableView != null) {
            List<Bibliotecario> tabla = bibliotecarioTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Bibliotecario competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerLibroSeleccionado() {
        final Bibliotecario bibliotecario = getTablaLibrosSeleccionado();
        posicionEnTabla = listaBibliotecarios.indexOf(bibliotecario);

        if (bibliotecario != null) {

            // Pongo los textFields con los datos correspondientes
            nombreTextField.setText(bibliotecario.getNombre());
            nombreUsuarioTextField.setText(bibliotecario.getNombreUsuario());
            contraseñaTextField.setText(bibliotecario.getContraseña());
            iDTextField.setText(bibliotecario.getIdentificacion());
            tipoIDComboBox.setValue(bibliotecario.getTipoDeIdentificacion());
            tipoUsuarioTextField.setText(bibliotecario.getTipoDeUsuario());

            // Pongo los botones en su estado correspondiente
//            libroButtonModificar.setDisable(false);
//            libroButtonEliminar.setDisable(false);

        }
    }
    
}
