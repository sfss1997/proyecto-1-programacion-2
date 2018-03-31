/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers.BibliotecarioObras;

import Datos.Listas;
import static Datos.Listas.listaAutores;
import Domain.Memoria;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
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
public class IBMemoriaController extends Listas implements Initializable {

    

    //Tabla
    @FXML TableView memoriaTableView;
    @FXML TableColumn resumenTableColumn;
    @FXML TableColumn abstractoTableColumn;
    @FXML TableColumn conferenciaTableColumn;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn fechaTableColumn;
    @FXML TableColumn autoresTableColumn;
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField resumenTextField;
    @FXML TextField conferenciaTextField;
    @FXML TextField abstractoTextField;
    
    //DatePicker
    @FXML DatePicker fechaDatePicker;
    
    //ChoiceBox
    @FXML ComboBox autorComboBox;
    
    //Esto es para reconocer el numero de la fila que se selecicona en la tabla
    private int posicionEnTabla;
    
    
    /**
     * Este metodo es el que se ejecuta apenas entra a la interfaz.
     * Es como un constructor
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializa la tabla y las columnas para que funcione
        inicializarTablaMemoria();
        
        //Llena el choiceBox 
        llenarComboBox();
        
        //Este setValue del ChoiceBox lo que hace es que se seleccione lo que se pone entre parentecis
        //en este caso puse "Autor" y cuando entre a esta interfaz va a aparecer "Autor" en el ChoiceBox como si
        //se hubiera seleccionado
        //SOLO SE PUEDE HACER ESO CON ELEMENTOS QUE YA ESTÁN AGREGADOS AL CHOICEBOX 
        autorComboBox.setValue("Autor");
        
        //Esto ni lo vea jaja solo se agrega y ya
        //Ni yo se como funciona, pero es para que sirva lo de posicionEnTabla, osea, para que reconozca
        //la fila de la tabla que se seleccionó y para que cargue los valores de la fila alos TextFields y al ChoiceBox
        final ObservableList<Memoria> tablaMemoriaSel = memoriaTableView.getSelectionModel().getSelectedItems();
        tablaMemoriaSel.addListener(selectorTablaMemoria);
    }
    
    /**
     * On Antion ----------------------------- Metodos que se van a utilizar como On Action
     */
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    //Agrega un nuevo libro
    public void agregarButton(){
        Memoria memoria = new Memoria(resumenTextField.getText(), 
                                  abstractoTextField.getText(), 
                                  conferenciaTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorComboBox.getValue().toString());
        if(validarInformacion() == true){
            //Se utiliza la listaLibros de la clase Listas
            super.listaMemorias.add(memoria);
            limpiarButton();  
        }
        
    }
    
    //Modifica un elemento seleccionado en la tabla
    public void modificarButton(){
        Memoria memoria = new Memoria(resumenTextField.getText(), 
                                  abstractoTextField.getText(), 
                                  conferenciaTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorComboBox.getValue().toString());
        if(validarInformacion() == true){
            super.listaMemorias.set(posicionEnTabla, memoria);
            limpiarButton();  
        }
    }
    
    //Elimina el elemento seleccionado en la tabla
    public void eliminarButton(){
        listaMemorias.remove(posicionEnTabla);
    }
    
    //Limpia lo que hay en los TextFields
    //Asigna al ChoiceBox el elemento de "Autor"
    //Asigna al DatePicker la fecha actual
    public void limpiarButton(){
        resumenTextField.setText("");
        abstractoTextField.setText("");
        conferenciaTextField.setText("");
        tituloTextField.setText("");
        fechaDatePicker.setValue(LocalDate.now());
        autorComboBox.setValue("Autor");
    }
    
    //Llena el ChoiceBox con todos los autores existentes (pero todavia no llena con autores :'v)
    public void llenarComboBox(){
        //El addAll es para agregar más de un elemento a la ves
        autorComboBox.getItems().add("Autor");
        for (int i = 0; i < listaAutores.size(); i++) {
            autorComboBox.getItems().add(listaAutores.get(i).getNombre());
        }
    }
    
    public void agregarAutorButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/BibliotecarioUsuarios/IBAutor.fxml");
    }
    
    /**
     * Metodos ----------------------------- Metodos que se utilizan para otras funcionalidades que no son On Action
     */
    
    //Inicializa la tabla
    private void inicializarTablaMemoria(){
        //Solo hay que hacerlo con las columnas
        //Ejemplo:
//  nombre del TableColumb.setCellValueFactory(new PropertyValueFactory
//  < El objeto que se va a usar en la tabla, El tipo del elemnto >( El nombre de la variable, tiene que ser igual al que está en la clase del objeto ));
        resumenTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("resumen"));
        abstractoTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("abstracto"));
        conferenciaTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("conferencia"));
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("titulo"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, LocalDate>("fecha"));
        autoresTableColumn.setCellValueFactory(new PropertyValueFactory<Memoria, String>("listaAutores"));
        
        memoriaTableView.setItems(super.listaMemorias);
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
        if(tituloTextField.getText().equals("") ||
           resumenTextField.getText().equals("") ||
           abstractoTextField.getText().equals("") ||
           conferenciaTextField.getText().equals("") ||
           autorComboBox.getValue().equals("Autor"))
            return false;
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
    private final ListChangeListener<Memoria> selectorTablaMemoria =
            new ListChangeListener<Memoria>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Memoria> c) {
                    ponerMemoriaSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Memoria getTablaMemoriaSeleccionado() {
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
    private void ponerMemoriaSeleccionado() {
        final Memoria memoria = getTablaMemoriaSeleccionado();
        posicionEnTabla = listaMemorias.indexOf(memoria);

        if (memoria != null) {

            // Pongo los textFields con los datos correspondientes
            resumenTextField.setText(memoria.getResumen());
            abstractoTextField.setText(memoria.getAbstracto());
            conferenciaTextField.setText(memoria.getConferencia());
            tituloTextField.setText(memoria.getTitulo());
            fechaDatePicker.setValue(memoria.getFecha());
            autorComboBox.setValue(memoria.getListaAutores());
            
            

            // Pongo los botones en su estado correspondiente
//            libroButtonModificar.setDisable(false);
//            libroButtonEliminar.setDisable(false);

        }
    }
    
    
    
}
