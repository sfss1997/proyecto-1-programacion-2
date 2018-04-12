/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Datos.Listas;
import static Datos.Listas.listaAutores;
import static Datos.Listas.listaLibros;
import static Datos.Listas.listaRelacion;
import Domain.Otro;
import Domain.Relacion;
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
public class IBOtroController extends Listas implements Initializable {

    //Tabla
    @FXML TableView otroTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn tipoTableColumn;
    @FXML TableColumn autorTableColumn;
    @FXML TableColumn fechaTableColumn;
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField tipoTextField;
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
    
    FilteredList filter = new FilteredList(listaOtros, e -> true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        
        inicializarTablaLibro();

        llenarAutorComboBox();
        llenarBusquedaComboBox();

        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        
        final ObservableList<Otro> tablaLibroSel = otroTableView.getSelectionModel().getSelectedItems();
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
        Otro otro = new Otro(tipoTextField.getText(), 
                             tituloTextField.getText(), 
                             fechaDatePicker.getValue(), 
                             autorComboBox.getValue().toString());
        
        Relacion relacion = new Relacion(tituloTextField.getText(),
                                        autorComboBox.getValue().toString(),
                                        "Otro");
           
        if(validarInformacion() == true){
            super.listaOtros.add(otro);
            super.listaRelacion.add(relacion);
            acualizaAutor();
            limpiarButton();  
        }
        
    }

    @FXML
    public void modificarButton(){
        Otro otro = new Otro(tipoTextField.getText(), 
                             tituloTextField.getText(), 
                             fechaDatePicker.getValue(), 
                             autorComboBox.getValue().toString());

        if(validarInformacion() == true){
            modificarRelacion(otro);
            super.listaOtros.set(posicionEnTabla, otro);
            acualizaAutor();
            limpiarButton();  
        }
    }

    @FXML
    public void eliminarButton(){
        if(verificaObraPrestada() == false){
            eliminaRelacion();
            listaOtros.remove(posicionEnTabla); 

            acualizaAutor();
            limpiarButton();
        }
    }

    @FXML
    public void limpiarButton(){
        tipoTextField.setText("");
        tituloTextField.setText("");
        fechaDatePicker.setValue(LocalDate.now());
        autorComboBox.setValue("Seleccione una opción");
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
    
    private boolean verificaObraPrestada(){
        for (int i = 0; i < listaPrestamo.size(); i++) {
            for (int j = 0; j < listaOtros.size(); j++) {
                if(listaPrestamo.get(i).getTituloObra().equals(listaOtros.get(j).getTitulo())){
                    JOptionPane.showMessageDialog(null, "Esta obra está prestada, no puede ser eliminada.");
                    return true;
                }
            }
        }
        return false;
    }
    
    public void llenarBusquedaComboBox(){
        busquedaComboBox.getItems().addAll("Título", "Autor");
        busquedaComboBox.setValue("Seleccione una opción");
    }
    
    public void llenarAutorComboBox(){
        autorComboBox.setValue("Seleccione una opción");
        for (int i = 0; i < listaAutores.size(); i++) {
            autorComboBox.getItems().add(listaAutores.get(i).getNombre());
        }
    }
    
    private void modificarRelacion(Otro nuevoOtro){
        Otro otro= listaOtros.get(posicionEnTabla);
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(otro.getTitulo())){
                listaRelacion.get(i).setTituloObra(nuevoOtro.getTitulo());
                listaRelacion.get(i).setNombreUnico(nuevoOtro.getListaAutores());
            }
        }
    }
    
    private void eliminaRelacion(){
        String titulo= listaOtros.get(posicionEnTabla).getTitulo();
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(titulo)){
                listaRelacion.remove(i);
            }
        }
    }

    private void inicializarTablaLibro(){

        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Otro, String>("titulo"));
        tipoTableColumn.setCellValueFactory(new PropertyValueFactory<Otro, String>("tipo"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Otro, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Otro, LocalDate>("fecha"));
        
        otroTableView.setItems(super.listaOtros);
    }

    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    private boolean verificaTituloExistente(){
        for (int i = 0; i < listaOtros.size(); i++) {
            if(tituloTextField.getText().equals(listaOtros.get(i).getTitulo()))
                return true;
        }
        return false;
    }

    private boolean validarInformacion(){
        if(tituloTextField.getText().equals("") ||
           tipoTextField.getText().equals("") ||
           autorComboBox.getValue().equals("Selecione una opción") ||
           fechaDatePicker.getValue() == null){
//            avisoLabel.setText("Complete todos los\nespacios.");
            JOptionPane.showMessageDialog(null, "Complete todos los espacios.");
            return false;
        } else if(agregarButton.isDisable() == false && verificaTituloExistente() == true){
//            avisoLabel.setText("Ya existe un libro con el\ntítulo sugerido.\nIngrese otro.");
            JOptionPane.showMessageDialog(null, "Ya existe un libro con el título sugerido.\nIngrese otro.");
            return false;
        }
        return true;
    }
    
    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Otro> selectorTablaLibros =
            new ListChangeListener<Otro>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Otro> c) {
                    ponerLibroSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Otro getTablaLibrosSeleccionado() {
        if (otroTableView != null) {
            List<Otro> tabla = otroTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Otro competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerLibroSeleccionado() {
        final Otro otro = getTablaLibrosSeleccionado();
        posicionEnTabla = listaOtros.indexOf(otro);

        if (otro != null) {

            // Pongo los textFields con los datos correspondientes
            tituloTextField.setText(otro.getTitulo());
            tipoTextField.setText(otro.getTipo());
            autorComboBox.setValue(otro.getListaAutores());
            fechaDatePicker.setValue(otro.getFecha());
            
            agregarButton.setDisable(true);
            modificarButton.setDisable(false);
            eliminarButton.setDisable(false);

        }
    }

    @FXML
    private void buscar(KeyEvent event) {
            buscarTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate((Predicate<? super Otro>) (Otro libro)->{
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
                    return false;
                });
            });
            SortedList sort = new SortedList(filter);
            sort.comparatorProperty().bind(otroTableView.comparatorProperty());
            otroTableView.setItems(sort);
     
    }
    
    
}
