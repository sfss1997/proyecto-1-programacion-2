/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Datos.Listas;
import static Datos.Listas.listaLibros;
import Domain.Libro;
import Domain.OnAction;
import Domain.Revistas;
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
public class IBRevistaController extends Listas implements Initializable,OnAction {

    //Tabla
    @FXML TableView   revistaTableView;
    @FXML TableColumn issnTableColumn;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn edicionTableColumn;
    @FXML TableColumn autorTableColumn;
    @FXML TableColumn fechaTableColumn;
    
    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField issnTextField;
    @FXML TextField edicionTextField;
    
    //DatePicker
    @FXML DatePicker fechaDatePicker;
    
    //ChoiceBox
    @FXML ChoiceBox autorChoiceBox;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Inicializa la tabla y las columnas para que funcione
        inicializarTablaRevista();
        
        //Llena el choiceBox 
        llenarChoiceBox();
        
        //Este setValue del ChoiceBox lo que hace es que se seleccione lo que se pone entre parentecis
        //en este caso puse "Autor" y cuando entre a esta interfaz va a aparecer "Autor" en el ChoiceBox como si
        //se hubiera seleccionado
        //SOLO SE PUEDE HACER ESO CON ELEMENTOS QUE YA ESTÁN AGREGADOS AL CHOICEBOX 
        autorChoiceBox.setValue("Autor");
        
        //Esto ni lo vea jaja solo se agrega y ya
        //Ni yo se como funciona, pero es para que sirva lo de posicionEnTabla, osea, para que reconozca
        //la fila de la tabla que se seleccionó y para que cargue los valores de la fila alos TextFields y al ChoiceBox
        final ObservableList<Libro> tablaLibroSel = revistaTableView.getSelectionModel().getSelectedItems();
        tablaLibroSel.addListener(selectorTablaRevista);
    }    
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
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

    @Override
    public void agregarButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiarButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void inicializarTablaRevista() {
        //Solo hay que hacerlo con las columnas
        //Ejemplo:
//  nombre del TableColumb.setCellValueFactory(new PropertyValueFactory
//  < El objeto que se va a usar en la tabla, El tipo del elemnto >( El nombre de la variable, tiene que ser igual al que está en la clase del objeto ));
        
        issnTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("issn"));
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
        edicionTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("edición"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Libro, LocalDate>("fecha"));
        
        
        revistaTableView.setItems(super.listaRevistas);
    }

    private void llenarChoiceBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        final Revistas revistas = getTablaRevistaSeleccionado();
        posicionEnTabla = listaRevistas.indexOf(revistas);

        if (revistas != null) {

            // Pongo los textFields con los datos correspondientes
            tituloTextField.setText(revistas.getTitulo());
            autorChoiceBox.setValue(revistas.getListaAutores());
            fechaDatePicker.setValue(revistas.getFecha());
            issnTextField.setText(revistas.getIssn());

            // Pongo los botones en su estado correspondiente
//            libroButtonModificar.setDisable(false);
//            libroButtonEliminar.setDisable(false);
        }
    }
}
