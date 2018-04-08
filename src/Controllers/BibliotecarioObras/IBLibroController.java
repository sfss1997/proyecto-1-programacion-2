/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Domain.Libro;
import Domain.Relacion;
import Datos.Listas;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hvill
 */
public class IBLibroController extends Listas implements Initializable{

    //Tabla
    @FXML TableView libroTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn temaTableColumn;
    @FXML TableColumn subTemaTableColumn;
    @FXML TableColumn autorTableColumn;
    @FXML TableColumn fechaTableColumn;
    @FXML TableColumn codigoTableColumn;
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField temaTextField;
    @FXML TextField subTemaTextField;
    @FXML TextField codigoTextField;
    @FXML TextField buscarTextField;
    
    //DatePicker
    @FXML DatePicker fechaDatePicker;
    
    //ChoiceBox
    @FXML ComboBox autorComboBox;
    @FXML ComboBox busquedaComboBox;
    
    //Label
    @FXML Label avisoLabel;
    
    //Buttons
    @FXML Button agregarButton;
    @FXML Button modificarButton;
    @FXML Button eliminarButton;
    
    
    //Reconoce posicion en tabla
    private int posicionEnTabla;
    
    FilteredList filter = new FilteredList(listaLibros, e -> true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        
        inicializarTablaLibro();

        llenarAutorComboBox();
        llenarBusquedaComboBox();

        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        
        final ObservableList<Libro> tablaLibroSel = libroTableView.getSelectionModel().getSelectedItems();
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
        Libro libro = new Libro(codigoTextField.getText(), 
                                  temaTextField.getText(), 
                                  subTemaTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorComboBox.getValue().toString());
        
        Relacion relacion = new Relacion(tituloTextField.getText(),
                                        autorComboBox.getValue().toString(),
                                        "Libro");
           
        if(validarInformacion() == true){
            super.listaLibros.add(libro);
            super.listaRelacion.add(relacion);
            acualizaAutor();
            limpiarButton();  
        }
        
    }

    @FXML
    public void modificarButton(){
        Libro libro = new Libro(codigoTextField.getText(), 
                                  temaTextField.getText(), 
                                  subTemaTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorComboBox.getValue().toString());

        if(validarInformacion() == true){
            modificarRelacion(libro);
            super.listaLibros.set(posicionEnTabla, libro);
            acualizaAutor();
            limpiarButton();  
        }
    }

    @FXML
    public void eliminarButton(){
        
        eliminaRelacion();
        listaLibros.remove(posicionEnTabla); 

        acualizaAutor();
        limpiarButton();
    }

    @FXML
    public void limpiarButton(){
        codigoTextField.setText("");
        temaTextField.setText("");
        subTemaTextField.setText("");
        tituloTextField.setText("");
        fechaDatePicker.setValue(LocalDate.now());
        autorComboBox.setValue("Seleccione una opción");
        busquedaComboBox.setValue("Seleccione una opción");
        
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
        busquedaComboBox.getItems().addAll("Título", "Autor", "Código");
        busquedaComboBox.setValue("Seleccione una opción");
    }
    
    public void llenarAutorComboBox(){
        autorComboBox.setValue("Seleccione una opción");
        for (int i = 0; i < listaAutores.size(); i++) {
            autorComboBox.getItems().add(listaAutores.get(i).getNombre());
        }
    }
    
    private void modificarRelacion(Libro nuevoLibro){
        Libro libro= listaLibros.get(posicionEnTabla);
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra()==libro.getTitulo()){
                listaRelacion.get(i).setTituloObra(nuevoLibro.getTitulo());
                listaRelacion.get(i).setNombreUnico(nuevoLibro.getListaAutores());
            }
        }
    }
    
    private void eliminaRelacion(){
        String titulo= listaLibros.get(posicionEnTabla).getTitulo();
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra()==titulo){
                listaRelacion.remove(i);
            }
        }
    }

    private void inicializarTablaLibro(){

        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
        temaTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("tema"));
        subTemaTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("subtema"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, LocalDate>("fecha"));
        codigoTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("isbn"));
        
        libroTableView.setItems(super.listaLibros);
    }

    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    private boolean validarInformacion(){
        if(tituloTextField.getText().equals("") ||
           temaTextField.getText().equals("") ||
           subTemaTextField.getText().equals("") ||
           autorComboBox.getValue().equals("Autor"))
            return false;
        return true;
    }
    
    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Libro> selectorTablaLibros =
            new ListChangeListener<Libro>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Libro> c) {
                    ponerLibroSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Libro getTablaLibrosSeleccionado() {
        if (libroTableView != null) {
            List<Libro> tabla = libroTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Libro competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerLibroSeleccionado() {
        final Libro libro = getTablaLibrosSeleccionado();
        posicionEnTabla = listaLibros.indexOf(libro);

        if (libro != null) {

            // Pongo los textFields con los datos correspondientes
            tituloTextField.setText(libro.getTitulo());
            temaTextField.setText(libro.getTema());
            subTemaTextField.setText(libro.getSubtema());
            autorComboBox.setValue(libro.getListaAutores());
            fechaDatePicker.setValue(libro.getFecha());
            codigoTextField.setText(libro.getIsbn());
            
            agregarButton.setDisable(true);
            modificarButton.setDisable(false);
            eliminarButton.setDisable(false);

        }
    }

    @FXML
    private void buscar(KeyEvent event) {
            buscarTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate((Predicate<? super Libro>) (Libro libro)->{
                    if(busquedaComboBox.getValue().toString().equals("Seleccione una opción")){
                        return false;
                    }
                    else if(newValue.isEmpty() || newValue==null){
                        return true;
                    }
                    else if(busquedaComboBox.getValue().toString().equals("Título") && libro.getTitulo().contains(newValue)){
                        return true;
                    }
                    else if(busquedaComboBox.getValue().toString().equals("Autor") && libro.getListaAutores().contains(newValue)){
                        return true;
                    }
                    else if(busquedaComboBox.getValue().toString().equals("Código") && libro.getIsbn().contains(newValue)){
                        return true;
                    }
                    return false;
                });
            });
            SortedList sort = new SortedList(filter);
            sort.comparatorProperty().bind(libroTableView.comparatorProperty());
            libroTableView.setItems(sort);
     
    }
    
}
