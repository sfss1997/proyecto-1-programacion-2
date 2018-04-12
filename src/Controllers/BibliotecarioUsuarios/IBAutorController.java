/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioUsuarios;

import Datos.Listas;
import static Datos.Listas.listaBibliotecarios;
import static Datos.Listas.listaUsuarios;
import Domain.Autor;
import Domain.Libro;
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
public class IBAutorController extends Listas implements Initializable, OnAction{

    //Tabla
    @FXML TableView autorTableView;
    @FXML TableColumn nombreTableColumn;
    @FXML TableColumn nombreUsuarioTableColumn;
    @FXML TableColumn contraseñaTableColumn;
    @FXML TableColumn iDTableColumn;
    @FXML TableColumn tipoIDTableColumn;
    @FXML TableColumn tipoUsuarioTableColumn;
    @FXML TableColumn obrasTableColumn;
    
    
    
    //TextFields
    @FXML TextField nombreTextField;
    @FXML TextField nombreUsuarioTextField;
    @FXML TextField contraseñaTextField;
    @FXML TextField iDTextField;
    
    //ChoiceBox
    @FXML ComboBox tipoIDComboBox;
    @FXML ComboBox obrasComboBox;
    
    //Label
    @FXML Label avisoLabel;
    @FXML Label tipoUsuarioLabel;
    
    //Buttons
    @FXML Button agregarButton;
    @FXML Button modificarButton;
    @FXML Button eliminarButton;
    
    
    //Reconoce posicion en tabla
    private int posicionEnTabla;
    
    FilteredList filter = new FilteredList(listaAutores, e -> true);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        
        inicializarTablaLibro();

        llenaTipoIDComboBox();
        
        reestablecerObrasComboBox();

        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        
        final ObservableList<Autor> tablaLibroSel = autorTableView.getSelectionModel().getSelectedItems();
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

        Autor autor = new Autor(nombreTextField.getText(), 
                                nombreUsuarioTextField.getText(), 
                                contraseñaTextField.getText(), 
                                iDTextField.getText(), 
                                tipoIDComboBox.getValue().toString(), 
                                tipoUsuarioLabel.getText(), 
                                obrasComboBox.getValue().toString());
        
        if(validarInformacion() == true){
            super.listaAutores.add(autor);
            super.listaUsuarios.add(autor);
            limpiarButton();  
        }
        
    }

    @FXML
    public void modificarButton(){
        Autor autor = new Autor(nombreTextField.getText(), 
                                nombreUsuarioTextField.getText(), 
                                contraseñaTextField.getText(), 
                                iDTextField.getText(), 
                                tipoIDComboBox.getValue().toString(), 
                                tipoUsuarioLabel.getText(), 
                                obrasComboBox.getValue().toString());

        if(validarInformacion() == true){
            modificaUsuario(autor);
            super.listaAutores.set(posicionEnTabla, autor);
            limpiarButton();  
        }
    }

    @FXML
    public void eliminarButton(){
        if(validarPrestamoObras() == false){
            eliminaObras();
            eliminaUsuario();
            listaAutores.remove(posicionEnTabla); 

            limpiarButton();
        }
    }

    @FXML
    public void limpiarButton(){
        iDTextField.setText("");
        nombreUsuarioTextField.setText("");
        contraseñaTextField.setText("");
        nombreTextField.setText("");
        tipoIDComboBox.setValue("Seleccione una opción");
        avisoLabel.setText("");
        obrasComboBox.setValue("Seleccione una opción");
        
        agregarButton.setDisable(false);
        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        contraseñaTextField.setEditable(true);
    }
    
    @FXML
    public void agregarAutorButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/IBAutor.fxml");
    }
    
    /**
     * Metodos ----------------------------- 
     */
    
    public boolean validarPrestamoObras(){
        Autor autor= listaAutores.get(posicionEnTabla);
        for (int i = 0; i < listaPrestamo.size(); i++) {
            if(listaPrestamo.get(i).getNombreUnico().equals(autor.getNombreUsuario())){
                JOptionPane.showMessageDialog(null, "El usuario que desea eliminar tiene una obra prestada.\nNo puede ser eliminado");
                return true;
            }
        }
        return false;
    }
    
    private void eliminaObras(){
        String nombre= listaAutores.get(posicionEnTabla).getNombre();
        
        for (int i = 0; i < listaRelacion.size(); i++) {
            switch(listaRelacion.get(i).getTipoObra()){
                case "Libro":
                    for (int j = 0; j < listaLibros.size(); j++) {
                        if(listaLibros.get(j).getListaAutores().equals(nombre))
                            listaLibros.remove(j);
                    }
                    break;
                case "Revista":
                    for (int k = 0; k < listaRevistas.size(); k++) {
                        if(listaRevistas.get(k).getListaAutores().equals(nombre))
                            listaRevistas.remove(k);
                    }
                    break;
                case "Tesis":
                    for (int l = 0; l < listaTesis.size(); l++) {
                        if(listaTesis.get(l).getListaAutores().equals(nombre))
                            listaTesis.remove(l);
                    }
                    break;
                case "Periódico":
                    for (int m = 0; m < listaPeriodicos.size(); m++) {
                        if(listaPeriodicos.get(m).getListaAutores().equals(nombre))
                            listaPeriodicos.remove(m);
                    }
                    break;
                case "Memoria":
                    for (int n = 0; n < listaMemorias.size(); n++) {
                        if(listaMemorias.get(n).getListaAutores().equals(nombre))
                            listaMemorias.remove(n);
                    }
                    break;
                case "Otro":
                    for (int p = 0; p < listaOtros.size(); p++) {
                        if(listaOtros.get(p).getListaAutores().equals(nombre))
                            listaOtros.remove(p);
                    }
                    break;
            }
            if(listaRelacion.get(i).getNombreUnico().equals(nombre))
                listaRelacion.remove(i);
        }
    }
    
    private void reestablecerObrasComboBox(){
        obrasComboBox.getItems().clear();
        obrasComboBox.getItems().add("Ningona");
        obrasComboBox.setValue("Seleccione una opción");
    }
    
    private void llenarObrasComboBox(){
        obrasComboBox.getItems().clear();
        String nombre= listaAutores.get(posicionEnTabla).getNombre();
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getNombreUnico().equals(nombre))
                obrasComboBox.getItems().add(listaRelacion.get(i).getTituloObra());
        }
        obrasComboBox.setValue("Seleccione una opción");
    }
    
    
    public void llenaTipoIDComboBox(){
        tipoIDComboBox.setValue("Seleccione una opción");
        tipoIDComboBox.getItems().addAll("Nacional", "Internacional", "Otro");
    }
    
    private void modificaUsuario(Autor nuevoAutor){
        Autor autor= listaAutores.get(posicionEnTabla);
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getNombreUsuario().equals(nuevoAutor.getNombreUsuario())){
                listaUsuarios.get(i).setNombre(nuevoAutor.getNombre());
                listaUsuarios.get(i).setNombreUsuario(nuevoAutor.getNombreUsuario());
                listaUsuarios.get(i).setContraseña(nuevoAutor.getContraseña());
                listaUsuarios.get(i).setIdentificacion(nuevoAutor.getIdentificacion());
                listaUsuarios.get(i).setTipoDeIdentificacion(nuevoAutor.getTipoDeIdentificacion());
                listaUsuarios.get(i).setTipoDeUsuario(nuevoAutor.getTipoDeUsuario());
            }
        }
    }
    
    private void eliminaUsuario(){
        String nombreUsuario= listaAutores.get(posicionEnTabla).getNombreUsuario();
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)){
                listaUsuarios.remove(i);
            }
        }
    }

    private void inicializarTablaLibro(){

        nombreTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombre"));
        nombreUsuarioTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombreUsuario"));
        contraseñaTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("contraseña"));
        iDTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("identificacion"));
        tipoIDTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, LocalDate>("tipoDeIdentificacion"));
        tipoUsuarioTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("tipoDeUsuario"));
        obrasTableColumn.setCellValueFactory(new PropertyValueFactory<Autor, String>("listaObras"));
        
        autorTableView.setItems(super.listaAutores);
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
           tipoIDComboBox.getValue().equals("Seleccione una opción") ||
           obrasComboBox.getValue().equals("Seleccione una opción")){
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
    private final ListChangeListener<Autor> selectorTablaLibros =
            new ListChangeListener<Autor>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Autor> c) {
                    ponerLibroSeleccionado();
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
    private void ponerLibroSeleccionado() {
        final Autor autor = getTablaLibrosSeleccionado();
        posicionEnTabla = listaAutores.indexOf(autor);

        if (autor != null) {

            // Pongo los textFields con los datos correspondientes
            nombreTextField.setText(autor.getNombre());
            nombreUsuarioTextField.setText(autor.getNombreUsuario());
            contraseñaTextField.setText(autor.getContraseña());
            tipoIDComboBox.setValue(autor.getTipoDeIdentificacion());
            iDTextField.setText(autor.getIdentificacion());
            llenarObrasComboBox();
            
            agregarButton.setDisable(true);
            modificarButton.setDisable(false);
            eliminarButton.setDisable(false);
            contraseñaTextField.setEditable(false);

        }
    }
    
}
