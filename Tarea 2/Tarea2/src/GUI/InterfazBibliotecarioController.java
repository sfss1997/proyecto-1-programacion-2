/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.Autor;
import domain.Libro;
import domain.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class InterfazBibliotecarioController implements Initializable {

    private int posicionEnTabla;
    
    /**
     * Libros
     */
    
    //TableView y TableColumns
    @FXML TableView libroTableView;
    @FXML TableColumn libroTableColumnNombre;
    @FXML TableColumn libroTableColumnAutor;
    @FXML TableColumn libroTableColumnCategoria;
    
    //TextFields
    @FXML TextField libroTextFieldNombre;
    @FXML TextField libroTextFieldAutor;
    @FXML TextField libroTextFieldCategoria;
    
    //Button
    @FXML Button libroButtonEliminar;
    @FXML Button libroButtonModificar;
    
    private ObservableList<Libro> listaLibros = FXCollections.observableArrayList();
    
    /**
     * Autores
     */
    
    private int posicionEnTablaAutor;
    
    //TableView y TableColumns
    @FXML TableView autorTableView;
    @FXML TableColumn autorTableColumnNombre;
    @FXML TableColumn autorTableColumnApellido;
    @FXML TableColumn autorTableColumnLibro;
    
    //TextFields
    @FXML TextField autorTextFieldNombre;
    @FXML TextField autorTextFieldApellido;
    @FXML TextField autorTextFieldLibro;
    
    //Button
    @FXML Button autorButtonEliminar;
    @FXML Button autorButtonModificar;
    
    private ObservableList<Autor> listaAutores = FXCollections.observableArrayList();
   
    
    /**
     * Usuarios
     */
    
    private int posicionEnTablaUsuario;
    
    //TableView y TableColumns
    @FXML TableView usuarioTableView;
    @FXML TableColumn usuarioTableColumnNombre;
    @FXML TableColumn usuarioTableColumnContraseña;
    @FXML TableColumn usuarioTableColumnNombreCompleto;
    @FXML TableColumn usuarioTableColumnID;
    @FXML TableColumn usuarioTableColumnTipo;
    
    //TextFields
    @FXML TextField usuarioTextFieldNombre;
    @FXML TextField usuarioTextFieldContraseña;
    @FXML TextField usuarioTextFieldNombreCompleto;
    @FXML TextField usuarioTextFieldID;
//    @FXML TextField usuarioTextFieldTipo;
    
    //Button
    @FXML Button usuarioButtonEliminar;
    @FXML Button usuarioButtonModificar;
    
    @FXML ChoiceBox usuarioChoiceBoxTipo;
    
    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class. -----------------------------------------------------------------------------
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    /**
     * Libro
     */
        //Inicializar Tabla
        inicializarTablaLibro();
        
        //Deshabilitar botones
        this.libroButtonEliminar.setDisable(true);
        this.libroButtonModificar.setDisable(true);
        
        final ObservableList<Libro> tablaLibroSel = libroTableView.getSelectionModel().getSelectedItems();
        tablaLibroSel.addListener(selectorTablaLibros);
        
    /**
     * Autor
     */
    
    //Inicializar Tabla
        inicializarTablaAutor();
        
        
        
        //Deshabilitar botones
        this.autorButtonEliminar.setDisable(true);
        this.autorButtonModificar.setDisable(true);
        
        final ObservableList<Autor> tablaAutorSel = autorTableView.getSelectionModel().getSelectedItems();
        tablaAutorSel.addListener(selectorTablaAutores);
        
    
    /**
     * Usuario
     */
    
        //Inicializar Tabla
        inicializarTablaUsuario();
        
        llenarChoiceBox();
        
        //Deshabilitar botones
        this.usuarioButtonEliminar.setDisable(true);
        this.usuarioButtonModificar.setDisable(true);
        
        final ObservableList<Usuario> tablaUsuarioSel = usuarioTableView.getSelectionModel().getSelectedItems();
        tablaUsuarioSel.addListener(selectorTablaUsuarios);           

        
    }
    
    public void salir(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    public ObservableList listaLibros(){
        return this.listaLibros;
    }
    
    public ObservableList listaAutores(){
        return this.listaAutores;
    }
    
    public ObservableList listaUsuarios(){
        return this.listaUsuarios;
    }
    
    /**
     * Libro
     */
    
    /**
     * ------------------- Main -------------------
     */
    
    public void agregarButtonLibro(){
        Libro nuevoLibro = new Libro(libroTextFieldNombre.getText(), 
                                     libroTextFieldAutor.getText(), 
                                     libroTextFieldCategoria.getText());
        if(validaciones() == true){
            listaLibros.add(nuevoLibro);
            limpiarTextFieldLibro();
        }
        
    }
    
    public void eliminarButtonLibro(){
        listaLibros.remove(posicionEnTabla);
    }
    
    public void modificarButtonLibro(){
        Libro nuevoLibro = new Libro(libroTextFieldNombre.getText(), 
                                     libroTextFieldAutor.getText(), 
                                     libroTextFieldCategoria.getText());
        if(validaciones() == true){
            listaLibros.set(posicionEnTabla, nuevoLibro);
            limpiarTextFieldLibro();
        }
        
    }
    
    public void limpiarTextFieldLibro(){
        libroTextFieldNombre.setText("");
        libroTextFieldAutor.setText("");
        libroTextFieldCategoria.setText("");
    }
    
    /**
     * ------------------- Mouse -------------------
     */
    
    public void clicEnTablaLibro(){
        this.libroButtonEliminar.setDisable(false);
        this.libroButtonModificar.setDisable(false);
    }
    
    /**
     * ------------------- Metodos -------------------
     */
    
    private boolean validaciones(){
        if(libroTextFieldNombre.getText().equals("") ||
           libroTextFieldAutor.getText().equals("") ||
           libroTextFieldCategoria.getText().equals(""))
            return false;
        return true;
    }
    
    private void inicializarTablaLibro(){
        libroTableColumnNombre.setCellValueFactory(new PropertyValueFactory<Libro, String>("nombre"));
        libroTableColumnAutor.setCellValueFactory(new PropertyValueFactory<Libro, String>("autor"));
        libroTableColumnCategoria.setCellValueFactory(new PropertyValueFactory<Libro, String>("categoria"));
        
        libroTableView.setItems(llenarTablaLibro());
    }

    private ObservableList llenarTablaLibro(){
        listaLibros.add(new Libro("Harry Potter (saga)", "J.K. Rowling", "Ciencia Ficción"));
        listaLibros.add(new Libro("EL Señor de los Anillos (saga)", "J.R.R. Tolkien", "Ciencia Ficción"));
        listaLibros.add(new Libro("It", "Stephen King", "Terror"));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Marquez", "Realismo Mágico"));
        listaLibros.add(new Libro("El Hobbit", "J.R.R. Tolkien", "Ciencia Ficción"));
        listaLibros.add(new Libro("El código Da Vinvi", "Dan Brown", "Misterio"));
        listaLibros.add(new Libro("Los Hijos de Durin", "J.R.R. Tolkien", "Ciencia Ficción"));
        listaLibros.add(new Libro("Canciones de Hielo y Fuego (saga)", "George R.R. Martin", "Ciencia Ficción"));
        listaLibros.add(new Libro("El Silmarillion", "J.R.R. Tolkien", "Ciencia Ficción"));
        return listaLibros;
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
            libroTextFieldNombre.setText(libro.getNombre());
            libroTextFieldAutor.setText(libro.getAutor());
            libroTextFieldCategoria.setText(libro.getCategoria());

            // Pongo los botones en su estado correspondiente
            libroButtonModificar.setDisable(false);
            libroButtonEliminar.setDisable(false);

        }
    }
    
    /**
     * Autor
     */
    
    /**
     * ------------------- Main -------------------
     */
    
    public void agregarButtonAutor(){
        Autor nuevoAutor = new Autor(autorTextFieldNombre.getText(), 
                                     autorTextFieldApellido.getText(), 
                                     autorTextFieldLibro.getText());
        if(validacionesAutor() == true){
            listaAutores.add(nuevoAutor);
            limpiarTextFieldAutor();
        }
    }
    
    public void eliminarButtonAutor(){
        listaAutores.remove(posicionEnTablaAutor);
    }
    
    public void modificarButtonAutor(){
        Autor nuevoAutor = new Autor(autorTextFieldNombre.getText(), 
                                     autorTextFieldApellido.getText(), 
                                     autorTextFieldLibro.getText());
        
        if(validacionesAutor() == true){
            listaAutores.set(posicionEnTablaAutor, nuevoAutor);
            limpiarTextFieldAutor();
        }
    }
    
    public void limpiarTextFieldAutor(){
        autorTextFieldNombre.setText("");
        autorTextFieldApellido.setText("");
        autorTextFieldLibro.setText("");
    }
    
    /**
     * ------------------- Mouse -------------------
     */
    
    public void clicEnTablaAutor(){
        this.autorButtonEliminar.setDisable(false);
        this.autorButtonModificar.setDisable(false);
    }
    
    /**
     * ------------------- Metodos -------------------
     */
    
    private boolean validacionesAutor(){
        if(autorTextFieldNombre.getText().equals("") ||
           autorTextFieldApellido.getText().equals("") ||
           autorTextFieldLibro.getText().equals(""))
            return false;
        return true;
    }
    
    private void inicializarTablaAutor(){
        autorTableColumnNombre.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombre"));
        autorTableColumnApellido.setCellValueFactory(new PropertyValueFactory<Autor, String>("apellido"));
        autorTableColumnLibro.setCellValueFactory(new PropertyValueFactory<Autor, String>("libro"));
        
        autorTableView.setItems(llenarTablaAutor());
    }

    private ObservableList llenarTablaAutor(){
        
        listaAutores.add(new Autor("J.R.R.", "Tolkien", "EL Señor de los Anillos (saga)"));
        listaAutores.add(new Autor("J.R.R.", "Tolkien", "El Hobbit"));
        listaAutores.add(new Autor("J.R.R.", "Tolkien", "Los Hijos de Durin"));
        listaAutores.add(new Autor("J.R.R.", "Tolkien", "El Silmarillion"));
        listaAutores.add(new Autor("J.K.", "Rowling", "Harry Potter (saga)"));
        listaAutores.add(new Autor("Stephen", "King", "It"));
        listaAutores.add(new Autor("Gabriel", "García Marquez", "Cien años de soledad"));
        listaAutores.add(new Autor("Dan", "Brown", "El código Da Vinvi"));
        listaAutores.add(new Autor("George R.R.", "Martin", "Canciones de Hielo y Fuego (saga)"));
        return listaAutores;
    }
    
    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Autor> selectorTablaAutores =
            new ListChangeListener<Autor>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Autor> c) {
                    ponerAutorSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Autor getTablaAutorSeleccionado() {
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
    private void ponerAutorSeleccionado() {
        final Autor autor = getTablaAutorSeleccionado();
        posicionEnTablaAutor = listaAutores.indexOf(autor);

        if (autor != null) {

            // Pongo los textFields con los datos correspondientes
            autorTextFieldNombre.setText(autor.getNombre());
            autorTextFieldApellido.setText(autor.getApellido());
            autorTextFieldLibro.setText(autor.getLibro());

            // Pongo los botones en su estado correspondiente
            autorButtonModificar.setDisable(false);
            autorButtonEliminar.setDisable(false);

        }
    }
   
    
    /**
     * Usuario
     */
    
    /**
     * ------------------- Main -------------------
     */
    
    public void agregarButtonUsuario(){
        Usuario nuevoUsuario = new Usuario(usuarioTextFieldNombre.getText(), 
                                           usuarioTextFieldContraseña.getText(), 
                                           usuarioTextFieldNombreCompleto.getText(), 
                                           usuarioTextFieldID.getText(), 
                                           usuarioChoiceBoxTipo.getValue().toString());
        
        listaUsuarios.add(nuevoUsuario);
        limpiarTextFieldUsuario();
        
    }
    
    public void eliminarButtonUsuario(){
        listaUsuarios.remove(posicionEnTablaUsuario);
    }
    
    public void modificarButtonUsuario(){
        Usuario nuevoUsuario = new Usuario(usuarioTextFieldNombre.getText(), 
                                           usuarioTextFieldContraseña.getText(), 
                                           usuarioTextFieldNombreCompleto.getText(), 
                                           usuarioTextFieldID.getText(), 
                                           usuarioChoiceBoxTipo.getValue().toString());
        listaUsuarios.set(posicionEnTablaUsuario, nuevoUsuario);
    }
    
    public void limpiarTextFieldUsuario(){
        usuarioTextFieldNombre.setText("");
        usuarioTextFieldContraseña.setText("");
        usuarioTextFieldNombreCompleto.setText("");
        usuarioTextFieldID.setText("");
    }
    
    /**
     * ------------------- Mouse -------------------
     */
    
    public void clicEnTablaUsuario(){
        this.usuarioButtonEliminar.setDisable(false);
        this.usuarioButtonModificar.setDisable(false);
    }
    
    /**
     * ------------------- Metodos -------------------
     */
    
    private boolean validacionesUsuario(){
        if(usuarioTextFieldNombre.getText().equals("") ||
           usuarioTextFieldContraseña.getText().equals("") ||
           usuarioTextFieldNombreCompleto.getText().equals("") ||
           usuarioTextFieldID.getText().equals("") ||
           usuarioChoiceBoxTipo.getValue().toString().equals(""))
            return false;
        return true;
    }
    
    private void llenarChoiceBox(){
        usuarioChoiceBoxTipo.getItems().addAll("Bibliotecario", "Autor", "Usuario");
    }
    
    private void inicializarTablaUsuario(){
        usuarioTableColumnNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombreUsuario"));
        usuarioTableColumnContraseña.setCellValueFactory(new PropertyValueFactory<Usuario, String>("contraseña"));
        usuarioTableColumnNombreCompleto.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombreCompleto"));
        usuarioTableColumnID.setCellValueFactory(new PropertyValueFactory<Usuario, String>("id"));
        usuarioTableColumnTipo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("tipoUsuario"));
        usuarioTableView.setItems(llenarTablaUsuario());
    }

    private ObservableList llenarTablaUsuario(){
        listaUsuarios.add(new Usuario("hans", "123", "Hans Villalobos", "1-1234-5678", "Bibliotecario"));
        listaUsuarios.add(new Usuario("laura", "111", "Laura Sanchez", "3-0987-7654", "Cliente"));
        listaUsuarios.add(new Usuario("tolkien", "1234", "J.R.R. Tolkien", "1-2342-4364", "Autor"));
        return listaUsuarios;
    }
    
    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Usuario> selectorTablaUsuarios =
            new ListChangeListener<Usuario>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Usuario> c) {
                    ponerUsuarioSeleccionado();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Usuario getTablaUsuariosSeleccionado() {
        if (usuarioTableView != null) {
            List<Usuario> tabla = usuarioTableView.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Usuario competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerUsuarioSeleccionado() {
        final Usuario usuario = getTablaUsuariosSeleccionado();
        posicionEnTablaUsuario = listaUsuarios.indexOf(usuario);

        if (usuario != null) {

            // Pongo los textFields con los datos correspondientes
            usuarioTextFieldNombre.setText(usuario.getNombreUsuario());
            usuarioTextFieldContraseña.setText(usuario.getContraseña());
            usuarioTextFieldNombreCompleto.setText(usuario.getNombreCompleto());
            usuarioTextFieldID.setText(usuario.getId());
            usuarioChoiceBoxTipo.setValue(usuario.getTipoUsuario());
            

            // Pongo los botones en su estado correspondiente
            this.usuarioButtonEliminar.setDisable(false);
            this.usuarioButtonModificar.setDisable(false);

        }
    }
    
}
