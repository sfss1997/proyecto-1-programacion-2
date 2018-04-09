 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Datos.Listas;
import static Datos.Listas.listaAutores;
import static Datos.Listas.listaRelacion;
import static Datos.Listas.listaRevistas;
import Domain.Periodico;
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
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author hvill
 */
public class IBPeriodicoController extends Listas implements Initializable {
    
    ///Tabla
    @FXML TableView   periodicoTableView;
    @FXML TableColumn issnTableColumn;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn edicionTableColumn;
    @FXML TableColumn autorTableColumn;
    @FXML TableColumn fechaTableColumn;
    
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField issnTextField;
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

    FilteredList filter = new FilteredList(listaPeriodicos, e -> true);
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {


        
        inicializarTablaLibro();

        llenarAutorComboBox();
        llenarBusquedaComboBox();

        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        
        final ObservableList<Periodico> tablaLibroSel = periodicoTableView.getSelectionModel().getSelectedItems();
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
        Periodico periodico = new Periodico(issnTextField.getText(), 
                                            edicionTextField.getText(), 
                                            tituloTextField.getText(), 
                                            fechaDatePicker.getValue(), 
                                            autorComboBox.getValue().toString());
        
        Relacion relacion = new Relacion(tituloTextField.getText(),
                                        autorComboBox.getValue().toString(),
                                        "Periódico");
           
        if(validarInformacion() == true){
            super.listaPeriodicos.add(periodico);
            super.listaRelacion.add(relacion);
            acualizaAutor();
            limpiarButton();  
        }
        
    }

    @FXML
    public void modificarButton(){
        Periodico periodico = new Periodico(issnTextField.getText(), 
                                            edicionTextField.getText(), 
                                            tituloTextField.getText(), 
                                            fechaDatePicker.getValue(), 
                                            autorComboBox.getValue().toString());

        if(validarInformacion() == true){
            modificarRelacion(periodico);
            super.listaPeriodicos.set(posicionEnTabla, periodico);
            acualizaAutor();
            limpiarButton();  
        }
    }

    @FXML
    public void eliminarButton(){
        eliminaRelacion();
        listaPeriodicos.remove(posicionEnTabla); 

        acualizaAutor();
        limpiarButton();
    }

    @FXML
    public void limpiarButton(){
        issnTextField.setText("");
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
    
    private void modificarRelacion(Periodico nuevoPeriodico){
        Periodico periodico= listaPeriodicos.get(posicionEnTabla);
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(periodico.getTitulo())){
                listaRelacion.get(i).setTituloObra(nuevoPeriodico.getTitulo());
                listaRelacion.get(i).setNombreUnico(nuevoPeriodico.getListaAutores());
            }
        }
    }
    
    private void eliminaRelacion(){
        String titulo= listaPeriodicos.get(posicionEnTabla).getTitulo();
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(titulo)){
                listaRelacion.remove(i);
            }
        }
    }

    private void inicializarTablaLibro(){

        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Periodico, String>("titulo"));
        edicionTableColumn.setCellValueFactory(new PropertyValueFactory<Periodico, String>("edicion"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Periodico, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Periodico, LocalDate>("fecha"));
        issnTableColumn.setCellValueFactory(new PropertyValueFactory<Periodico, String>("isbn"));
        
        periodicoTableView.setItems(super.listaPeriodicos);
    }

    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    private boolean verificaTituloExistente(){
        for (int i = 0; i < listaPeriodicos.size(); i++) {
            if(tituloTextField.getText().equals(listaPeriodicos.get(i).getTitulo()))
                return true;
        }
        return false;
    }

    private boolean validarInformacion(){
        if(tituloTextField.getText().equals("") ||
           edicionTextField.getText().equals("") ||
           issnTextField.getText().equals("") ||
           autorComboBox.getValue().equals("Seleccione una opción") ||
           fechaDatePicker.getValue() == null){
//            avisoLabel.setText("Complete todos los\nespacios.");
            JOptionPane.showMessageDialog(null, "Complete todos los espacios.");
            return false;
        } else if(verificaTituloExistente() == true){
//            avisoLabel.setText("Ya existe un libro con el\ntítulo sugerido.\nIngrese otro.");
            JOptionPane.showMessageDialog(null, "Ya existe un libro con el título sugerido.\nIngrese otro.");
            return false;
        }
        return true;
    }
    
    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Periodico> selectorTablaLibros =
            new ListChangeListener<Periodico>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Periodico> c) {
                    ponerLibroSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Periodico getTablaLibrosSeleccionado() {
        if (periodicoTableView != null) {
            List<Periodico> tabla = periodicoTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Periodico competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerLibroSeleccionado() {
        final Periodico periodico = getTablaLibrosSeleccionado();
        posicionEnTabla = listaPeriodicos.indexOf(periodico);

        if (periodico != null) {

            // Pongo los textFields con los datos correspondientes
            tituloTextField.setText(periodico.getTitulo());
            edicionTextField.setText(periodico.getEdicion());
            autorComboBox.setValue(periodico.getListaAutores());
            fechaDatePicker.setValue(periodico.getFecha());
            issnTextField.setText(periodico.getIsbn());
            
            agregarButton.setDisable(true);
            modificarButton.setDisable(false);
            eliminarButton.setDisable(false);

        }
    }

    @FXML
    private void buscar(KeyEvent event) {
            buscarTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filter.setPredicate((Predicate<? super Periodico>) (Periodico revista)->{
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
            sort.comparatorProperty().bind(periodicoTableView.comparatorProperty());
            periodicoTableView.setItems(sort);
     
    }
}
