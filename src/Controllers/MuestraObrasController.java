/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Datos.Listas.listaRelacion;
import Domain.Relacion;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fabian
 */
public class MuestraObrasController implements Initializable {

 
    ///Tabla
    @FXML TableView  obrasTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn tipoTableColumn;
    @FXML TableColumn autorTableColumn;
    
    //ChoiceBox
    @FXML ComboBox tiposComboBox;
    
    
    //Esto es para reconocer el numero de la fila que se selecicona en la tabla
//    private int posicionEnTabla;

    
//    FilteredList filter = new FilteredList(listaRelacion, e -> true);
   /**
     * Este metodo es el que se ejecuta apenas entra a la interfaz.
     * Es como un constructor
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializa la tabla y las columnas para que funcione
        inicializarTablaRevista();
        
        //Llena el choiceBox 
        
        llenarComboBox();
        
        //Este setValue del ChoiceBox lo que hace es que se seleccione lo que se pone entre parentecis
        //en este caso puse "Autor" y cuando entre a esta interfaz va a aparecer "Autor" en el ChoiceBox como si
        //se hubiera seleccionado
        //SOLO SE PUEDE HACER ESO CON ELEMENTOS QUE YA ESTÁN AGREGADOS AL CHOICEBOX 
       
        
        //Esto ni lo vea jaja solo se agrega y ya
        //Ni yo se como funciona, pero es para que sirva lo de posicionEnTabla, osea, para que reconozca
        //la fila de la tabla que se seleccionó y para que cargue los valores de la fila alos TextFields y al ChoiceBox
//        final ObservableList<Relacion> tablaRelacionSel = obrasTableView.getSelectionModel().getSelectedItems();
//        tablaRelacionSel.addListener(selectorTablaObras);
    }    
    
     /**
     * On Antion ----------------------------- Metodos que se van a utilizar como On Action
     */
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    
    public void adminObrasButton(ActionEvent event) throws IOException{
                
        switch(tiposComboBox.getValue().toString()){
            case "Libros":
                cambioScene(event, "/GUI/BibliotecarioObras/IBLibro.fxml");
                break;
            case "Revistas":
                cambioScene(event, "/GUI/BibliotecarioObras/IBRevista.fxml");
                break;
            case "Tesis":
                cambioScene(event, "/GUI/BibliotecarioObras/IBTesis.fxml");
                break;
            case "Periódicos":
                cambioScene(event, "/GUI/BibliotecarioObras/IBPeriodico.fxml");
                break;
            case "Memorias":
                cambioScene(event, "/GUI/BibliotecarioObras/IBMemoria.fxml");
                break;
            case "Otras":
                cambioScene(event, "/GUI/BibliotecarioObras/IBOtro.fxml");
                break;
        }
    }

    
    
    //Inicializa la tabla
    private void inicializarTablaRevista() {
        //Solo hay que hacerlo con las columnas
        //Ejemplo:
//  nombre del TableColumb.setCellValueFactory(new PropertyValueFactory
//  < El objeto que se va a usar en la tabla, El tipo del elemnto >( El nombre de la variable, tiene que ser igual al que está en la clase del objeto ));
        
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("tituloObra"));
        tipoTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("nombreUnico"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Relacion, String>("tipoObra"));
        
        obrasTableView.setItems(listaRelacion);
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
    
    public void llenarComboBox(){
        
        tiposComboBox.getItems().add("Libros");
        tiposComboBox.getItems().add("Revistas");
        tiposComboBox.getItems().add("Tesis");
        tiposComboBox.getItems().add("Periódicos");
        tiposComboBox.getItems().add("Memorias");
        tiposComboBox.getItems().add("Otras");
      
    }
   
  
    
    //Valida que los TextField esten con algo y que el ChoiceBox no sea "Autor"
   
    
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
//    private final ListChangeListener<Relacion> selectorTablaObras =
//            new ListChangeListener<Relacion>() {
//                @Override
//                public void onChanged(ListChangeListener.Change<? extends Relacion> c) {
//                    ponerRelacionSeleccionada();
//                }
//            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
//    public Relacion getTablaRelacionSeleccionada() {
//        if (obrasTableView != null) {
//            List<Relacion> tabla = obrasTableView.getSelectionModel().getSelectedItems();
//            if (tabla.size() == 1) {
//                final Relacion competicionSeleccionada = tabla.get(0);
//                return competicionSeleccionada;
//            }
//        }
//        return null;
//    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
//    private void ponerRelacionSeleccionada() {
//        final Relacion relacion = getTablaRelacionSeleccionada();
//        posicionEnTabla = listaRelacion.indexOf(relacion);

    
            // Pongo los botones en su estado correspondiente
//            libroButtonModificar.setDisable(false);
//            libroButtonEliminar.setDisable(false);
        
//    }

}
