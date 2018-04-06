/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Datos.Listas;
import static Datos.Listas.listaAutores;
import static Datos.Listas.listaLibros;

import Domain.Otro;
import Domain.Relacion;
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
public class IBOtroController extends Listas implements Initializable {

     //Tabla
    @FXML TableView otroTableView;
    @FXML TableColumn tituloTableColumn;
    @FXML TableColumn tipoTableColumn;
    @FXML TableColumn autorTableColumn;
    @FXML TableColumn fechaTableColumn;

    
    //TextFields
    @FXML TextField tituloTextField;
    @FXML TextField tipoTextField;
    
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
        inicializarTablaLibro();
        
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
        final ObservableList<Otro> tablaOtroSel = otroTableView.getSelectionModel().getSelectedItems();
        tablaOtroSel.addListener(selectorTablaOtros);
    }
    
    /**
     * On Antion ----------------------------- Metodos que se van a utilizar como On Action
     */
    
    //Cambiar a la ventada de bibliotecario
    public void volverButton(ActionEvent event) throws IOException{
        cambioScene(event, "/GUI/InterfazBibliotecario.fxml");
    }
    
    //Agrega un nuevo otro
    public void agregarButton(){
        Otro otro = new Otro(tipoTextField.getText(), 
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorComboBox.getValue().toString());
        Relacion relacion = new Relacion(tituloTextField.getText(),
                                        autorComboBox.getValue().toString(),
                                        "Otro");
        if(validarInformacion() == true){
            //Se utiliza la listaOtros de la clase Listas
            super.listaOtros.add(otro);
            super.listaRelacion.add(relacion);
            acualizaAutor();
            limpiarButton();  
        }
        
    }
    
    //Modifica un elemento seleccionado en la tabla
    public void modificarButton(){
        Otro otro = new Otro(tipoTextField.getText(),
                                  tituloTextField.getText(), 
                                  fechaDatePicker.getValue(), 
                                  autorComboBox.getValue().toString());
        if(validarInformacion() == true){
            super.listaOtros.set(posicionEnTabla, otro);
            limpiarButton();  
        }
    }
    
    //Elimina el elemento seleccionado en la tabla
    public void eliminarButton(){
        listaOtros.remove(posicionEnTabla);
        listaRelacion.remove(posicionRelacion());
        acualizaAutor();
    }
    
    //Limpia lo que hay en los TextFields
    //Asigna al ChoiceBox el elemento de "Autor"
    //Asigna al DatePicker la fecha actual
    public void limpiarButton(){
        tipoTextField.setText("");
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
    
    private int posicionRelacion(){
        int salida = 0;
        Otro otro = getTablaOtrosSeleccionado();
        for (int i = 0; i < listaRelacion.size(); i++) {
            if(listaRelacion.get(i).getTituloObra().equals(otro.getTitulo()))
                salida = i;
        }
        return salida+1;
    }
    
    private void acualizaAutor(){
        String salida = "";
        for (int i = 0; i < listaAutores.size(); i++) {
            for (int j = 0; j < listaRelacion.size(); j++) {
                if(listaAutores.get(i).getNombre().equals(listaRelacion.get(j).getNombreUnico()))
                    salida += listaRelacion.get(j).getTituloObra() + " - ";
                    listaAutores.get(i).setListaObras(salida);
            }
        }
    }
    
    //Inicializa la tabla
    private void inicializarTablaLibro(){
        //Solo hay que hacerlo con las columnas
        //Ejemplo:
//  nombre del TableColumb.setCellValueFactory(new PropertyValueFactory
//  < El objeto que se va a usar en la tabla, El tipo del elemnto >( El nombre de la variable, tiene que ser igual al que está en la clase del objeto ));
        tituloTableColumn.setCellValueFactory(new PropertyValueFactory<Otro, String>("titulo")); 
        tipoTableColumn.setCellValueFactory(new PropertyValueFactory<Otro, String>("tipo"));
        autorTableColumn.setCellValueFactory(new PropertyValueFactory<Otro, String>("listaAutores"));
        fechaTableColumn.setCellValueFactory(new PropertyValueFactory<Otro, LocalDate>("fecha"));
        
        
        otroTableView.setItems(super.listaOtros);
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
           tipoTextField.getText().equals("") ||
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
    private final ListChangeListener<Otro> selectorTablaOtros =
            new ListChangeListener<Otro>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Otro> c) {
                    ponerOtroSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Otro getTablaOtrosSeleccionado() {
        if (otroTableView != null) {
            List<Otro> tabla = otroTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Otro competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerOtroSeleccionado() {
        final Otro otro = getTablaOtrosSeleccionado();
        posicionEnTabla = listaOtros.indexOf(otro);

        if (otro != null) {

            // Pongo los textFields con los datos correspondientes
            
            tipoTextField.setText(otro.getTipo());
            tituloTextField.setText(otro.getTitulo());
            autorComboBox.setValue(otro.getListaAutores());
            fechaDatePicker.setValue(otro.getFecha());

            // Pongo los botones en su estado correspondiente
//            libroButtonModificar.setDisable(false);
//            libroButtonEliminar.setDisable(false);

        }
    }
    
    
}
