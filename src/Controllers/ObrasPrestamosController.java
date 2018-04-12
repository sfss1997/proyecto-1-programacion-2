/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Datos.Listas;
import static Datos.Listas.listaAutores;
import static Datos.Listas.listaClientes;
import static Datos.Listas.listaLibros;
import static Datos.Listas.listaPrestamo;
import static Datos.Listas.listaRelacion;
import Domain.Prestamo;
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
 * @author fabian
 */
public class ObrasPrestamosController extends Listas implements Initializable {

    
     //Tabla
    @FXML TableView prestamosTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn tipoTableColumn;
    @FXML TableColumn clienteTableColumn;
    @FXML TableColumn fechaPrestamoTableColumn;
    @FXML TableColumn fechaVencimientoTableColumn;
    @FXML TableColumn estadoTableColumn;
    
    //DatePicker
    @FXML DatePicker fechaPrestamoDatePicker;
    @FXML DatePicker fechaVencimientoDatePicker;
    
    //TextField
    @FXML TextField buscarTextField;
    
    //Button
    @FXML Button agregarButton;
    @FXML Button modificarButton;
    @FXML Button eliminarButton;
    
    //ChoiceBox
    @FXML ComboBox obrasComboBox;
    @FXML ComboBox usuariosComboBox;
    
    //Esto es para reconocer el numero de la fila que se selecicona en la tabla
    private int posicionEnTabla;
    
   
    
    
    /**
     * Este metodo es el que se ejcuta apenas entra a la interfaz.
     * Es como un constructor
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializa la tabla y las columnas para que funcione
        inicializarTablaLibro();
        
        //Llena el choiceBox 
        llenarComboBox();

        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
        
        final ObservableList<Prestamo> tablaLibroSel = prestamosTableView.getSelectionModel().getSelectedItems();
        tablaLibroSel.addListener(selectorTablaLibros);
    }
    
    /**
     * On Antion ----------------------------- Metodos que se van a utilizar como On Action
     */
    
    //Cambiar a la ventada de bibliotecario
    @FXML
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    //Agrega un nuevo prestamo
    @FXML
    public void agregarButton(){
        
        String tipo="";
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(obrasComboBox.getValue().equals(listaRelacion.get(i).getTituloObra())){
                tipo=listaRelacion.get(i).getTipoObra();
            }
        }
        String estado="Vigente";
        
       if (LocalDate.now().isAfter(fechaVencimientoDatePicker.getValue())) {
                   estado = "Vencido";
            }
        
        Prestamo prestamo = new Prestamo(obrasComboBox.getValue().toString(), 
                                  usuariosComboBox.getValue().toString(), 
                                  tipo,
                                  estado,
                                  fechaPrestamoDatePicker.getValue(),
                                  fechaVencimientoDatePicker.getValue()); 
                                  
        
        
       
           
        if(validarInformacion() == true){
            if(verificaObrasPrestadas() == false){
                super.listaPrestamo.add(prestamo);

                limpiarButton();  
            }
        }
        
    }
    
    //Modifica un elemento seleccionado en la tabla
    @FXML
    public void modificarButton(){
        
        String tipo="";
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(obrasComboBox.getValue().equals(listaRelacion.get(i).getTituloObra())){
                tipo=listaRelacion.get(i).getTipoObra();
            }
        }
        String estado="Vigente";
         if (LocalDate.now().isAfter(fechaVencimientoDatePicker.getValue())) {
                   estado = "Vencido";
            }
        Prestamo prestamo = new Prestamo(obrasComboBox.getValue().toString(), 
                                  usuariosComboBox.getValue().toString(), 
                                  tipo,
                                  estado,
                                  fechaPrestamoDatePicker.getValue(),
                                  fechaVencimientoDatePicker.getValue()); 
                                  
        
        
        if(validarInformacion() == true){
            super.listaPrestamo.set(posicionEnTabla, prestamo);
//            super.listaRelacion.set(posicionRelacion(), relacion);
//            acualizaAutor();
            limpiarButton();  
        }
    }
    
    //Elimina el elemento seleccionado en la tabla
    @FXML
    public void eliminarButton(){
        listaPrestamo.remove(posicionEnTabla);
    
//        acualizaAutor();
    }
    
    //Limpia lo que hay en los TextFields
    //Asigna al ChoiceBox el elemento de "Autor"
    //Asigna al DatePicker la fecha actual
    @FXML
    public void limpiarButton(){
        
       
       
        fechaVencimientoDatePicker.setValue(LocalDate.now());
        fechaPrestamoDatePicker.setValue(LocalDate.now());
        usuariosComboBox.setValue("Seleccione una opción");
        obrasComboBox.setValue("Seleccione una opción");
        
        agregarButton.setDisable(false);
        modificarButton.setDisable(true);
        eliminarButton.setDisable(true);
    }
    
    //Llena el ChoiceBox con todos los autores existentes
    @FXML
    public void llenarComboBox(){
        //El addAll es para agregar más de un elemento a la ves
//        autorComboBox.getItems().add("Autor");
        for (int i = 0; i < listaRelacion.size(); i++) {
            obrasComboBox.getItems().add(listaRelacion.get(i).getTituloObra());
        }
        
        for (int i = 0; i < listaUsuarios.size(); i++) {
            usuariosComboBox.getItems().add(listaUsuarios.get(i).getNombreUsuario());
        }
        obrasComboBox.setValue("Seleccione una opción");
        usuariosComboBox.setValue("Seleccione una opción");
    }
    
    @FXML
    public void agregarClienteButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/IBCliente.fxml");
    }
    
    /**
     * Metodos ----------------------------- Metodos que se utilizan para otras funcionalidades que no son On Action
     */
    
    private boolean verificaObrasPrestadas(){
            for (int i = 0; i < listaPrestamo.size(); i++) {
                if(listaPrestamo.get(i).getTituloObra().equals(obrasComboBox.getValue().toString())){
                    JOptionPane.showMessageDialog(null, "Esta obra ya ha sido prestada.");
                    return true;
                }
            }
        return false;
    }
    
    //Inicializa la tabla
    private void inicializarTablaLibro(){
        //Solo hay que hacerlo con las columnas
        //Ejemplo:
//  nombre del TableColumb.setCellValueFactory(new PropertyValueFactory
//  < El objeto que se va a usar en la tabla, El tipo del elemnto >( El nombre de la variable, tiene que ser igual al que está en la clase del objeto ));
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("tituloObra"));
        tipoTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("nombreUnico"));
        clienteTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("tipoObra"));
        fechaPrestamoTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, LocalDate>("fechaPrestamo"));
        fechaVencimientoTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, LocalDate>("fechaVencimiento"));
        estadoTableColumn.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("estado"));
        
        prestamosTableView.setItems(super.listaPrestamo);
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
    
    
    
    //Valida que los TextField esten con algo y que el ChoiceBox no sea "Autor"
    private boolean validarInformacion(){
        if(obrasComboBox.getValue().equals("Seleccione una opción")||
           usuariosComboBox.getValue().equals("Seleccione una opción") ||
           fechaPrestamoDatePicker.getValue() == null ||
           fechaVencimientoDatePicker.getValue() == null){ 
            JOptionPane.showMessageDialog(null, "Complete todos los espacios.");
            return false;
        }
        return true;
    }
    
    //********* IMPORTANTE *********
    
    /**
     * Estos metodos de aquí abajo no sé muy bien como funcionan, pero se necesitan para que sirva lo de eliminar
     * y modificar.
     * Estos metodos sirven para reconocer la fila que se seleccionó y los elementos de la fila.
     * Estos metodos van junto al tablaLibroSel, que es la línea de codigo que está en el metodo initialize (la que
     * empieza con final)
     * Nada más tenga mucho cuidado a la hora de copiar y pegar, mucho ojo a lo que hay que cambiarle
     */
    
    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Prestamo> selectorTablaLibros =
            new ListChangeListener<Prestamo>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Prestamo> c) {
                    ponerPrestamoSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Prestamo getTablaPrestamoSeleccionado() {
        if (prestamosTableView != null) {
            List<Prestamo> tabla = prestamosTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Prestamo competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerPrestamoSeleccionado() {
        final Prestamo prestamo = getTablaPrestamoSeleccionado();
        posicionEnTabla = listaPrestamo.indexOf(prestamo);

        if (prestamo != null) {

            // Pongo los textFields con los datos correspondientes
            
            
            obrasComboBox.setValue(prestamo.getTituloObra());
            usuariosComboBox.setValue(prestamo.getNombreUnico());
            fechaPrestamoDatePicker.setValue(prestamo.getFechaPrestamo());
            fechaVencimientoDatePicker.setValue(prestamo.getFechaVencimiento());
            

            agregarButton.setDisable(true);
            modificarButton.setDisable(false);
            eliminarButton.setDisable(false);

        }
    }

//  
    
    
    
}
