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
import Domain.Relacion;
import Domain.Revistas;
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
public class IBRevistaController extends Listas implements Initializable {

    ///Tabla
    @FXML TableView   revistaTableView;
    @FXML TableColumn isbnTableColumn;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn edicionTableColumn;
    @FXML TableColumn autorTableColumn;
    @FXML TableColumn fechaTableColumn;
    
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField isbnTextField;
    @FXML TextField edicionTextField;
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
        
    //Esto es para reconocer el numero de la fila que se selecicona en la tabla
    private int posicionEnTabla;

    FilteredList filter = new FilteredList(listaRevistas, e -> true);
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {


        
        inicializarTablaLibro();

        llenarAutorComboBox();
        llenarBusquedaComboBox();

        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        
        final ObservableList<Revistas> tablaLibroSel = revistaTableView.getSelectionModel().getSelectedItems();
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
        Revistas revista = new Revistas(isbnTextField.getText(), 
                                        edicionTextField.getText(), 
                                        tituloTextField.getText(), 
                                        fechaDatePicker.getValue(), 
                                        autorComboBox.getValue().toString());
        
        Relacion relacion = new Relacion(tituloTextField.getText(),
                                        autorComboBox.getValue().toString(),
                                        "Revista");
           
        if(validarInformacion() == true){
            super.listaRevistas.add(revista);
            super.listaRelacion.add(relacion);
            acualizaAutor();
            limpiarButton();  
        }
        
    }

    @FXML
    public void modificarButton(){
        Revistas revista = new Revistas(isbnTextField.getText(), 
                                        edicionTextField.getText(), 
                                        tituloTextField.getText(), 
                                        fechaDatePicker.getValue(), 
                                        autorComboBox.getValue().toString());

        if(validarInformacion() == true){
            modificarRelacion(revista);
            super.listaRevistas.set(posicionEnTabla, revista);
            acualizaAutor();
            limpiarButton();  
        }
    }

    @FXML
    public void eliminarButton(){
        if(verificaObraPrestada() == false){ 
            eliminaRelacion();
            listaRevistas.remove(posicionEnTabla); 

            acualizaAutor();
            limpiarButton();
        }
    }

    @FXML
    public void limpiarButton(){
        isbnTextField.setText("");
        tituloTextField.setText("");
        edicionTextField.setText("");
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
            for (int j = 0; j < listaRevistas.size(); j++) {
                if(listaPrestamo.get(i).getTituloObra().equals(listaRevistas.get(j).getTitulo())){
                    JOptionPane.showMessageDialog(null, "Esta obra está prestada, no puede ser eliminada.");
                    return true;
                }
            }
        }
        return false;
    }
    
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
    
    private void modificarRelacion(Revistas nuevaRevista){
        Revistas revista= listaRevistas.get(posicionEnTabla);
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(revista.getTitulo())){
                listaRelacion.get(i).setTituloObra(nuevaRevista.getTitulo());
                listaRelacion.get(i).setNombreUnico(nuevaRevista.getListaAutores());
            }
        }
    }
    
    private void eliminaRelacion(){
        String titulo= listaRevistas.get(posicionEnTabla).getTitulo();
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(titulo)){
                listaRelacion.remove(i);
            }
        }
    }

    private void inicializarTablaLibro(){

        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Revistas, String>("titulo"));
        edicionTableColumn.setCellValueFactory(new PropertyValueFactory<Revistas, String>("edicion"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Revistas, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Revistas, LocalDate>("fecha"));
        isbnTableColumn.setCellValueFactory(new PropertyValueFactory<Revistas, String>("isbn"));
        
        revistaTableView.setItems(super.listaRevistas);
    }

    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    private boolean verificaTituloExistente(){
        for (int i = 0; i < listaRevistas.size(); i++) {
            if(tituloTextField.getText().equals(listaRevistas.get(i).getTitulo()))
                return true;
        }
        return false;
    }

    private boolean validarInformacion(){
        if(tituloTextField.getText().equals("") ||
           edicionTextField.getText().equals("") ||
           isbnTextField.getText().equals("") ||
           autorComboBox.getValue().equals("Seleccione una opción") ||
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
    private final ListChangeListener<Revistas> selectorTablaLibros =
            new ListChangeListener<Revistas>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Revistas> c) {
                    ponerLibroSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Revistas getTablaLibrosSeleccionado() {
        if (revistaTableView != null) {
            List<Revistas> tabla = revistaTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Revistas competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerLibroSeleccionado() {
        final Revistas revista = getTablaLibrosSeleccionado();
        posicionEnTabla = listaRevistas.indexOf(revista);

        if (revista != null) {

            // Pongo los textFields con los datos correspondientes
            tituloTextField.setText(revista.getTitulo());
            edicionTextField.setText(revista.getEdicion());
            autorComboBox.setValue(revista.getListaAutores());
            fechaDatePicker.setValue(revista.getFecha());
            isbnTextField.setText(revista.getIsbn());
            
            agregarButton.setDisable(true);
            modificarButton.setDisable(false);
            eliminarButton.setDisable(false);

        }
    }

    @FXML
    private void buscar(KeyEvent event) {
            buscarTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate((Predicate<? super Revistas>) (Revistas revista)->{
                    if(busquedaComboBox.getValue().toString().equals("Seleccione una opción")){
                        return false;
                    }
                    else if(newValue.isEmpty() || newValue==null){
                        return true;
                    }
                    else if(busquedaComboBox.getValue().toString().equals("Título") && revista.getTitulo().contains(newValue)){
                        return true;
                    }
                    else if(busquedaComboBox.getValue().toString().equals("Autor") && revista.getListaAutores().contains(newValue)){
                        return true;
                    }
                    else if(busquedaComboBox.getValue().toString().equals("Código") && revista.getIsbn().contains(newValue)){
                        return true;
                    }
                    return false;
                });
            });
            SortedList sort = new SortedList(filter);
            sort.comparatorProperty().bind(revistaTableView.comparatorProperty());
            revistaTableView.setItems(sort);
     
    }
}
