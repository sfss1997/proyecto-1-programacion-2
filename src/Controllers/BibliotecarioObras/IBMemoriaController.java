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
import Domain.Memoria;
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
public class IBMemoriaController extends Listas implements Initializable {

    //Tabla
    @FXML TableView memoriaTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn resumenTableColumn;
    @FXML TableColumn abstractTableColumn;
    @FXML TableColumn conferenciaTableColumn;
    @FXML TableColumn autorTableColumn;
    @FXML TableColumn fechaTableColumn;
    
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField resumenTextField;
    @FXML TextField abstractTextField;
    @FXML TextField conferenciaTextField;
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
    
    FilteredList filter = new FilteredList(listaMemorias, e -> true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        
        inicializarTablaLibro();

        llenarAutorComboBox();
        llenarBusquedaComboBox();

        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        
        final ObservableList<Memoria> tablaLibroSel = memoriaTableView.getSelectionModel().getSelectedItems();
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
        Memoria memoria = new Memoria(resumenTextField.getText(), 
                                      abstractTextField.getText(), 
                                      conferenciaTextField.getText(), 
                                      tituloTextField.getText(), 
                                      fechaDatePicker.getValue(), 
                                      autorComboBox.getValue().toString());
        
        Relacion relacion = new Relacion(tituloTextField.getText(),
                                        autorComboBox.getValue().toString(),
                                        "Memoria");
           
        if(validarInformacion() == true){
            super.listaMemorias.add(memoria);
            super.listaRelacion.add(relacion);
            acualizaAutor();
            limpiarButton();  
        }
        
    }

    @FXML
    public void modificarButton(){
        Memoria memoria = new Memoria(resumenTextField.getText(), 
                                      abstractTextField.getText(), 
                                      conferenciaTextField.getText(), 
                                      tituloTextField.getText(), 
                                      fechaDatePicker.getValue(), 
                                      autorComboBox.getValue().toString());

        if(validarInformacion() == true){
            modificarRelacion(memoria);
            super.listaMemorias.set(posicionEnTabla, memoria);
            acualizaAutor();
            limpiarButton();  
        }
    }

    @FXML
    public void eliminarButton(){
        
        eliminaRelacion();
        listaMemorias.remove(posicionEnTabla); 

        acualizaAutor();
        limpiarButton();
    }

    @FXML
    public void limpiarButton(){
        conferenciaTextField.setText("");
        resumenTextField.setText("");
        abstractTextField.setText("");
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
    
    private void modificarRelacion(Memoria nuevaMemoria){
        Memoria meoria= listaMemorias.get(posicionEnTabla);
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(meoria.getTitulo())){
                listaRelacion.get(i).setTituloObra(nuevaMemoria.getTitulo());
                listaRelacion.get(i).setNombreUnico(nuevaMemoria.getListaAutores());
            }
        }
    }
    
    private void eliminaRelacion(){
        String titulo= listaMemorias.get(posicionEnTabla).getTitulo();
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(titulo)){
                listaRelacion.remove(i);
            }
        }
    }

    private void inicializarTablaLibro(){

        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("titulo"));
        resumenTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("resumen"));
        abstractTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("abstracto"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, LocalDate>("fecha"));
        conferenciaTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("conferencia"));
        
        memoriaTableView.setItems(super.listaMemorias);
    }

    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    private boolean verificaTituloExistente(){
        for (int i = 0; i < listaMemorias.size(); i++) {
            if(tituloTextField.getText().equals(listaMemorias.get(i).getTitulo()))
                return true;
        }
        return false;
    }

    private boolean validarInformacion(){
        if(tituloTextField.getText().equals("") ||
           resumenTextField.getText().equals("") ||
           abstractTextField.getText().equals("") ||
           conferenciaTextField.getText().equals("") ||
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
    private final ListChangeListener<Memoria> selectorTablaLibros =
            new ListChangeListener<Memoria>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Memoria> c) {
                    ponerLibroSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Memoria getTablaLibrosSeleccionado() {
        if (memoriaTableView != null) {
            List<Memoria> tabla = memoriaTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Memoria competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerLibroSeleccionado() {
        final Memoria memoria = getTablaLibrosSeleccionado();
        posicionEnTabla = listaMemorias.indexOf(memoria);

        if (memoria != null) {

            // Pongo los textFields con los datos correspondientes
            tituloTextField.setText(memoria.getTitulo());
            resumenTextField.setText(memoria.getResumen());
            abstractTextField.setText(memoria.getAbstracto());
            autorComboBox.setValue(memoria.getListaAutores());
            fechaDatePicker.setValue(memoria.getFecha());
            conferenciaTextField.setText(memoria.getConferencia());
            
            agregarButton.setDisable(true);
            modificarButton.setDisable(false);
            eliminarButton.setDisable(false);

        }
    }

    @FXML
    private void buscar(KeyEvent event) {
            buscarTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate((Predicate<? super Memoria>) (Memoria libro)->{
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
            sort.comparatorProperty().bind(memoriaTableView.comparatorProperty());
            memoriaTableView.setItems(sort);
     
    }
    
    
    
}
