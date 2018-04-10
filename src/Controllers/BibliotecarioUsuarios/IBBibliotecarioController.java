/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioUsuarios;

import Datos.Listas;
import static Datos.Listas.listaAutores;
import static Datos.Listas.listaLibros;
import static Datos.Listas.listaRelacion;
import Domain.Bibliotecario;
import Domain.OnAction;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class IBBibliotecarioController extends Listas implements Initializable, OnAction {

    
    //Tabla
    @FXML TableView bibliotecarioTableView;
    @FXML TableColumn nombreTableColumn;
    @FXML TableColumn nombreUsuarioTableColumn;
    @FXML TableColumn contraseñaTableColumn;
    @FXML TableColumn iDTableColumn;
    @FXML TableColumn tipoIDTableColumn;
    @FXML TableColumn tipoUsuarioTableColumn;
    
    //TextFields
    @FXML TextField nombreTextField;
    @FXML TextField nombreUsuarioTextField;
    @FXML TextField contraseñaTextField;
    @FXML TextField iDTextField;
    @FXML TextField buscarTextField;
    
    //ChoiceBox
    @FXML ComboBox tipoIDComboBox;
    @FXML ComboBox busquedaComboBox;
    
    //Label
    @FXML Label avisoLabel;
    @FXML Label tipoUsuarioLabel;
    
    //Buttons
    @FXML Button agregarButton;
    @FXML Button modificarButton;
    @FXML Button eliminarButton;
    
    
    //Reconoce posicion en tabla
    private int posicionEnTabla;
    
    FilteredList filter = new FilteredList(listaBibliotecarios, e -> true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        
        inicializarTablaLibro();

        llenarAutorComboBox();
        llenarBusquedaComboBox();

        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        
        final ObservableList<Bibliotecario> tablaLibroSel = bibliotecarioTableView.getSelectionModel().getSelectedItems();
        tablaLibroSel.addListener(selectorTablaLibros);
    }
    
    /**
     * On Antion -----------------------------
     */

    @FXML
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }

    @FXML
    public void agregarButton(){
        Bibliotecario bibliotecario = new Bibliotecario(nombreTextField.getText(), 
                                                        nombreUsuarioTextField.getText(), 
                                                        contraseñaTextField.getText(), 
                                                        iDTextField.getText(), 
                                                        tipoIDComboBox.getValue().toString(), 
                                                        tipoUsuarioLabel.getText());
        
        if(validarInformacion() == true){
            super.listaBibliotecarios.add(bibliotecario);
            super.listaUsuarios.add(bibliotecario);
            limpiarButton();  
        }
        
    }

    @FXML
    public void modificarButton(){
        Bibliotecario bibliotecario = new Bibliotecario(nombreTextField.getText(), 
                                                        nombreUsuarioTextField.getText(), 
                                                        contraseñaTextField.getText(), 
                                                        iDTextField.getText(), 
                                                        tipoIDComboBox.getValue().toString(), 
                                                        tipoUsuarioLabel.getText());

        if(validarInformacion() == true){
            modificaUsuario(bibliotecario);
            super.listaBibliotecarios.set(posicionEnTabla, bibliotecario);
            limpiarButton();  
        }
    }

    @FXML
    public void eliminarButton(){
        
        eliminaUsuario();
        listaBibliotecarios.remove(posicionEnTabla); 

        limpiarButton();
    }

    @FXML
    public void limpiarButton(){
        iDTextField.setText("");
        nombreUsuarioTextField.setText("");
        contraseñaTextField.setText("");
        nombreTextField.setText("");
        tipoIDComboBox.setValue("Seleccione una opción");
        busquedaComboBox.setValue("Seleccione una opción");
        avisoLabel.setText("");
        
        agregarButton.setDisable(false);
        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
    }
    
    @FXML
    public void agregarAutorButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/IBAutor.fxml");
    }
    
    /**
     * Metodos ----------------------------- 
     */
    
    public void llenarBusquedaComboBox(){
        busquedaComboBox.getItems().addAll("Nombre de usuario");
        busquedaComboBox.setValue("Seleccione una opción");
    }
    
    public void llenarAutorComboBox(){
        tipoIDComboBox.setValue("Seleccione una opción");
        tipoIDComboBox.getItems().add("Cédula");
    }
    
    private void modificaUsuario(Bibliotecario nuevobibliotecario){
        Bibliotecario bibliotecario= listaBibliotecarios.get(posicionEnTabla);
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getNombreUsuario().equals(bibliotecario.getNombreUsuario())){
                listaUsuarios.get(i).setNombre(nuevobibliotecario.getNombre());
                listaUsuarios.get(i).setNombreUsuario(nuevobibliotecario.getNombreUsuario());
                listaUsuarios.get(i).setContraseña(nuevobibliotecario.getContraseña());
                listaUsuarios.get(i).setIdentificacion(nuevobibliotecario.getIdentificacion());
                listaUsuarios.get(i).setTipoDeIdentificacion(nuevobibliotecario.getTipoDeIdentificacion());
                listaUsuarios.get(i).setTipoDeUsuario(nuevobibliotecario.getTipoDeUsuario());
            }
        }
    }
    
    private void eliminaUsuario(){
        String nombreUsuario= listaBibliotecarios.get(posicionEnTabla).getNombreUsuario();
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)){
                listaUsuarios.remove(i);
            }
        }
    }

    private void inicializarTablaLibro(){

        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("nombre"));
        nombreUsuarioTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("nombreUsuario"));
        contraseñaTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("contraseña"));
        iDTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("identificacion"));
        tipoIDTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, LocalDate>("tipoDeIdentificacion"));
        tipoUsuarioTableColumn.setCellValueFactory(new PropertyValueFactory<Bibliotecario, String>("tipoDeUsuario"));
        
        bibliotecarioTableView.setItems(super.listaBibliotecarios);
    }

    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    private boolean verificaUsuarioExistente(){
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(nombreUsuarioTextField.getText().equals(listaUsuarios.get(i).getNombreUsuario()))
                return true;
        }
        return false;
    }

    private boolean validarInformacion(){
        if(nombreTextField.getText().equals("") ||
           nombreUsuarioTextField.getText().equals("") ||
           contraseñaTextField.getText().equals("") ||
           iDTextField.getText().equals("") ||
           tipoIDComboBox.getValue().equals("Selecione una opción")){
//            avisoLabel.setText("Complete todos los\nespacios.");
            JOptionPane.showMessageDialog(null, "Complete todos los espacios.");
            return false;
        } else if(agregarButton.isDisable() == false && verificaUsuarioExistente() == true){
//            avisoLabel.setText("Ya existe un libro con el\ntítulo sugerido.\nIngrese otro.");
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con el título sugerido.\nIngrese otro.");
            return false;
        }
        return true;
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
            tipoIDComboBox.setValue(bibliotecario.getTipoDeIdentificacion());
            iDTextField.setText(bibliotecario.getIdentificacion());
            
            agregarButton.setDisable(true);
            modificarButton.setDisable(false);
            eliminarButton.setDisable(false);

        }
    }

    @FXML
    private void buscar(KeyEvent event) {
            buscarTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate((Predicate<? super Bibliotecario>) (Bibliotecario libro)->{
                    if(busquedaComboBox.getValue().toString().equals("Seleccione una opción")){
                        return false;
                    }
                    else if(newValue.isEmpty() || newValue==null){
                        return true;
                    }
                    else if(busquedaComboBox.getValue().toString().equals("Título") && libro.getNombreUsuario().contains(newValue)){
                        return true;
                    }
                    return false;
                });
            });
            SortedList sort = new SortedList(filter);
            sort.comparatorProperty().bind(bibliotecarioTableView.comparatorProperty());
            bibliotecarioTableView.setItems(sort);
     
    }
    //
}
