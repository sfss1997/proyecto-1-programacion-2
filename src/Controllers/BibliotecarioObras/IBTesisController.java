/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Datos.Listas;
import Domain.Tesis;
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
import javafx.scene.control.ChoiceBox;
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
public class IBTesisController extends Listas implements Initializable {
    
    //Tabla
    @FXML TableView tesisTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn resumenTableColumn;
    @FXML TableColumn abstractTableColumn;
    @FXML TableColumn fechaTableColumn;
    @FXML TableColumn autoresTableColumn;
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField resumenTextField;
    @FXML TextField abstractTextField;
   
    
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
        inicializarTablaTesis();
        
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
        final ObservableList<Tesis> tablaTesisSel = tesisTableView.getSelectionModel().getSelectedItems();
        tablaTesisSel.addListener(selectorTablaTesis);
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
        Tesis tesis = new Tesis(resumenTextField.getText(), 
                                  abstractTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorComboBox.getValue().toString());
        if(validarInformacion() == true){
            //Se utiliza la listaLibros de la clase Listas
            super.listaTesis.add(tesis);
            limpiarButton();  
        }
        
    }
    
    //Modifica un elemento seleccionado en la tabla
    public void modificarButton(){
        Tesis tesis = new Tesis(resumenTextField.getText(),  
                                abstractTextField.getText(),
                                tituloTextField.getText(), 
                                fechaDatePicker.getValue(), 
                                autorComboBox.getValue().toString());
        if(validarInformacion() == true){
            super.listaTesis.set(posicionEnTabla, tesis);
            limpiarButton();  
        }
    }
    
    //Elimina el elemento seleccionado en la tabla
    public void eliminarButton(){
        listaTesis.remove(posicionEnTabla);
    }
    
    //Limpia lo que hay en los TextFields
    //Asigna al ChoiceBox el elemento de "Autor"
    //Asigna al DatePicker la fecha actual
    public void limpiarButton(){
        resumenTextField.setText("");
        abstractTextField.setText("");
        tituloTextField.setText("");
        fechaDatePicker.setValue(LocalDate.now());
        autorComboBox.setValue("Autor");
    }
    
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
    private void inicializarTablaTesis(){
        //Solo hay que hacerlo con las columnas
        //Ejemplo:
//  nombre del TableColumb.setCellValueFactory(new PropertyValueFactory
//  < El objeto que se va a usar en la tabla, El tipo del elemnto >( El nombre de la variable, tiene que ser igual al que está en la clase del objeto ));
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Tesis, String>("titulo"));
        resumenTableColumn.setCellValueFactory(new PropertyValueFactory<Tesis, String>("resumen"));
        abstractTableColumn.setCellValueFactory(new PropertyValueFactory<Tesis, String>("abstract"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Tesis, LocalDate>("fecha"));
        autoresTableColumn.setCellValueFactory(new PropertyValueFactory<Tesis, String>("autores"));
        
        tesisTableView.setItems(super.listaTesis);
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
    
    //Llena el ChoiceBox con todos los autores existentes (pero todavia no llena con autores :'v)
    private void llenarChoiceBox(){
        //El addAll es para agregar más de un elemento a la ves
        autorComboBox.getItems().addAll("Autor","aaaa");
    }
    
    //Valida que los TextField esten con algo y que el ChoiceBox no sea "Autor"
    private boolean validarInformacion(){
        if(tituloTextField.getText().equals("") ||
           resumenTextField.getText().equals("") ||
           abstractTextField.getText().equals("") ||
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
    private final ListChangeListener<Tesis> selectorTablaTesis =
            new ListChangeListener<Tesis>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Tesis> c) {
                    ponerTesisSeleccionada();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Tesis getTablaTesisSeleccionado() {
        if (tesisTableView != null) {
            List<Tesis> tabla = tesisTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Tesis competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerTesisSeleccionada() {
        final Tesis tesis = getTablaTesisSeleccionado();
        posicionEnTabla = listaTesis.indexOf(tesis);

        if (tesis != null) {

            // Pongo los textFields con los datos correspondientes
            tituloTextField.setText(tesis.getTitulo());
            resumenTextField.setText(tesis.getResumen());
            autorComboBox.setValue(tesis.getListaAutores());
            fechaDatePicker.setValue(tesis.getFecha());
            abstractTextField.setText(tesis.getAbstracto());

            // Pongo los botones en su estado correspondiente
//            libroButtonModificar.setDisable(false);
//            libroButtonEliminar.setDisable(false);

        }
    }
    
}
