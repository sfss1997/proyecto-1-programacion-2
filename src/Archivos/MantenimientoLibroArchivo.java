/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Domain.Libro;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hvill
 */
public class MantenimientoLibroArchivo {

    private ManejoDeArchivos manejo;
    private String nombreArchivo = "Mantenimiento Libros.dat";

    public MantenimientoLibroArchivo() {
        manejo = new ManejoDeArchivos(nombreArchivo);
    }

    /*
     Método que se encarga de pasar la  lista de parqueos
     al archivo
     */
    public void insertarLibro(ObservableList listaLibro) {
        manejo.insertarObjeto(listaLibro);

    }//insertarParqueos()

    /*
     Método que se encarga de devolver la lista circular enlazada
     doble con los parqueos que se encuentran en el archivo
     */
    public ObservableList getListaLibro() {
        ObservableList<Libro> nuevaLista  = FXCollections.observableArrayList();
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            return nuevaLista;
        }//if
        else {
            Object ob = manejo.cargarArchivo();
            if (ob != null) {
                return (ObservableList<Libro>) manejo.cargarArchivo();//Convierte el objeto en una lista enlazada simple,realiza un cast
            } else {
                return nuevaLista;
            }
        }//else

    }
}
