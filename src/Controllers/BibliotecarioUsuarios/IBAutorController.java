/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioUsuarios;

import Domain.Autor;
import Datos.Listas;
import Domain.Libro;
import Domain.OnAction;
import Domain.Usuarios;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ChoiceBox;
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
public class IBAutorController extends Listas implements Initializable, OnAction{

    @FXML TableView autorTableView;
    @FXML TableColumn nombreTableColumn;
    @FXML TableColumn nombreUsuarioTableColumn;
    @FXML TableColumn contraseñaTableColumn;
    @FXML TableColumn iDTableColumn;
    @FXML TableColumn tipoIDTableColumn;
    @FXML TableColumn tipoUsuarioTableColumn;
    @FXML TableColumn obrasTableColumn;
    
    @FXML TextField nombreTextField;
    @FXML TextField nombreUsuarioTextField;
    @FXML TextField contraseñaTextField;
    @FXML TextField iDTextField;
    @FXML TextField tipoUsuarioTextField;
    @FXML TextField tipoIDTextField;
    
    @FXML ComboBox tipoObraComboBox;
    @FXML ComboBox obrasComboBox;
    
    @FXML Label avisoLabel;
    
    private int cont;
    private int posicionEnTabla;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        inicializarTablaLibro();
        llenarComboBox();    
        tipoObraComboBox.getItems().addAll("Ninguno", "Libro", "Revista", "Tesis", "Periódico", "Memoria", "Otro");
        obrasComboBox.setValue("Selecione una opción");
        
        
        
        final ObservableList<Autor> tablaLibroSel = autorTableView.getSelectionModel().getSelectedItems();
        tablaLibroSel.addListener(selectorTablaAutores);
        
    } 
    
    /**
     * On Action ---------------------------------------- 
     */
    
    @Override
    public void agregarButton() {

        Autor autor = new Autor(obrasComboBox.getValue().toString(), 
                                nombreUsuarioTextField.getText(), 
                                contraseñaTextField.getText(), 
                                nombreTextField.getText(), 
                                tipoIDTextField.getText(), 
                                iDTextField.getText(), 
                                tipoUsuarioTextField.getText());
        if(verificaInformacion() == true)
            if(verificaUsuarioExistente() == false){
            super.listaAutores.add(autor);
            super.listaUsuarios.add(autor);
            limpiarButton();
            }
        
    }

    @Override
    public void modificarButton() {
        Autor autor = new Autor(obrasComboBox.getValue().toString(), 
                                nombreUsuarioTextField.getText(), 
                                contraseñaTextField.getText(), 
                                nombreTextField.getText(), 
                                tipoIDTextField.getText(), 
                                iDTextField.getText(), 
                                tipoUsuarioTextField.getText());
        listaAutores.set(posicionEnTabla, autor);
    }

    @Override
    public void eliminarButton() {
        if(verificaUsuarioActivo() == false){
            final Autor autor = getTablaLibrosSeleccionado();
            for (int i = 0; i < listaUsuarios.size(); i++) {
                if(autor.getNombreUsuario().equals(listaUsuarios.get(i).getNombreUsuario()))
                    listaUsuarios.remove(i);
            }
            listaAutores.remove(posicionEnTabla);
            limpiarButton();
            
        }        
    }

    @Override
    public void limpiarButton() {
        nombreTextField.setText("");
        nombreUsuarioTextField.setText("");
        iDTextField.setText("");
        tipoIDTextField.setText("");
        contraseñaTextField.setText("");
    }

    @Override
    public void volverButton(ActionEvent event) throws IOException {
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    public void llenarComboBox(){
        obrasComboBox.getItems().addAll("Selecione una opción", "Ninguno");
//        for (int i = 0; i < listaLibros.size(); i++) {
//            obrasComboBox.getItems().add(listaLibros.get(i).getTitulo());
//        }
    }
    
    /**
     * Metodos ---------------------------------------- 
     */
    
    private boolean verificaInformacion(){
        if(nombreTextField.getText().equals("") ||
           nombreUsuarioTextField.getText().equals("") ||
           contraseñaTextField.getText().equals("") ||
           iDTextField.getText().equals("") ||
           tipoIDTextField.equals("") ||
           obrasComboBox.getValue().toString().equals("Selecione una opción")){
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
    
    private boolean verificaUsuarioActivo(){
        final Autor autor = getTablaLibrosSeleccionado();
        if(autor.getEstado().equals("activo")){
//            avisoLabel.setText("Este usuario está activo\nNo puede ser eliminado");
            return true;
        }
        return false;
    }
    
    //Inicializa la tabla
    private void inicializarTablaLibro(){
        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombre"));
        nombreUsuarioTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombreUsuario"));
        contraseñaTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("contraseña"));
        iDTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("identificacion"));
        tipoIDTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("tipoDeIdentificacion"));
        tipoUsuarioTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("tipoDeUsuario"));
        obrasTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("listaObras"));
        
        autorTableView.setItems(super.listaAutores);
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

    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Autor> selectorTablaAutores =
            new ListChangeListener<Autor>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Autor> c) {
                    ponerAutorSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Autor getTablaLibrosSeleccionado() {
        if (autorTableView != null) {
            List<Autor> tabla = autorTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Autor competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerAutorSeleccionado() {
        final Autor autor = getTablaLibrosSeleccionado();
        posicionEnTabla = listaAutores.indexOf(autor);

        if (autor != null) {

            // Pongo los textFields con los datos correspondientes
            nombreTextField.setText(autor.getNombre());
            nombreUsuarioTextField.setText(autor.getNombreUsuario());
            contraseñaTextField.setText(autor.getContraseña());
            iDTextField.setText(autor.getIdentificacion());
            tipoIDTextField.setText(autor.getTipoDeIdentificacion());
            tipoUsuarioTextField.setText(autor.getTipoDeUsuario());
            obrasComboBox.setValue(autor.getListaObrasEscritas());

            // Pongo los botones en su estado correspondiente
//            libroButtonModificar.setDisable(false);
//            libroButtonEliminar.setDisable(false);

        }
    }
}
