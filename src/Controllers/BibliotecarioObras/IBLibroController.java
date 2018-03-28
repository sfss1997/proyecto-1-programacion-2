/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Domain.Libro;
import Domain.Listas;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.DatePicker;
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
    
    //DatePicker
    @FXML DatePicker fechaDatePicker;
    
    //ChoiceBox
    @FXML ChoiceBox autorChoiceBox;
    
    //Lista para la tabla
    private ObservableList<Libro> listaLibros = FXCollections.observableArrayList();
    
    private int posicionEnTabla;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTablaLibro();
        llenarChoiceBox();
        autorChoiceBox.setValue("Autor");
        
        final ObservableList<Libro> tablaLibroSel = libroTableView.getSelectionModel().getSelectedItems();
        tablaLibroSel.addListener(selectorTablaLibros);
    }
    
    /**
     * On Antion
     */
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    public void agregarButton(){
        Libro libro = new Libro(codigoTextField.getText(), 
                                  temaTextField.getText(), 
                                  subTemaTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorChoiceBox.getValue().toString());
        if(validarInformacion() == true){
            super.listaLibros.add(libro);
            limpiarButton();  
        }
        
    }
    
    public void modificarButton(){
        Libro libro = new Libro(codigoTextField.getText(), 
                                  temaTextField.getText(), 
                                  subTemaTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorChoiceBox.getValue().toString());
        if(validarInformacion() == true){
            super.listaLibros.set(posicionEnTabla, libro);
            limpiarButton();  
        }
    }
    
    public void eliminarButton(){
        listaLibros.remove(posicionEnTabla);
    }
    
    public void limpiarButton(){
        codigoTextField.setText("");
        temaTextField.setText("");
        subTemaTextField.setText("");
        tituloTextField.setText("");
        fechaDatePicker.setValue(LocalDate.now());
        autorChoiceBox.setValue("Autor");
    }
    
    /**
     * Metodos
     */
    
    //Inicializa la tabla
    private void inicializarTablaLibro(){
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
        temaTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("tema"));
        subTemaTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("subtema"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, LocalDate>("fecha"));
        codigoTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("isbn"));
        
        libroTableView.setItems(super.listaLibros);
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
    
    //Llena el ChoiceBox con todos los autores existentes
    private void llenarChoiceBox(){
        autorChoiceBox.getItems().addAll("Autor","aaaa");
    }
    
    private boolean validarInformacion(){
        if(tituloTextField.getText().equals("") ||
           temaTextField.getText().equals("") ||
           subTemaTextField.getText().equals("") ||
           autorChoiceBox.getValue().equals("Autor"))
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
            autorChoiceBox.setValue(libro.getListaAutores());
            fechaDatePicker.setValue(libro.getFecha());
            codigoTextField.setText(libro.getIsbn());

            // Pongo los botones en su estado correspondiente
//            libroButtonModificar.setDisable(false);
//            libroButtonEliminar.setDisable(false);

        }
    }
    
}
