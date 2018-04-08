/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Domain.Autor;
import Domain.Bibliotecario;
import Domain.Cliente;
import Domain.Libro;
import Domain.Otro;
import Domain.Prestamo;
import Domain.Relacion;
import Domain.Usuarios;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author fabian
 */
public class Listas {
    
    public static ObservableList<Prestamo> listaPrestamo = FXCollections.observableArrayList();
    public static ObservableList<Relacion> listaRelacion = FXCollections.observableArrayList();
    public static ObservableList<Usuarios> listaUsuarios = FXCollections.observableArrayList();
    public static ObservableList<Autor> listaAutores = FXCollections.observableArrayList();
    public static ObservableList<Object> listaBibliotecarios = FXCollections.observableArrayList();
    public static ObservableList<Object> listaRevistas = FXCollections.observableArrayList();
    public static ObservableList<Object> listaTesis = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaLibros = FXCollections.observableArrayList();
    public static ObservableList<Object> listaPeriodicos = FXCollections.observableArrayList();
    public static ObservableList<Object> listaMemorias = FXCollections.observableArrayList();
    public static ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    public static ObservableList<Otro> listaOtros = FXCollections.observableArrayList();
    
    public static int x = 0;
    
    public Listas() {
        if(x==0){
            autoresPorDefecto();
            bibliotecariosPorDefecto();
            libroPorDefecto();
            
            acualizaAutor();
            x++;
        }
    }
    
    public void acualizaAutor(){
        String salida = "";
        for (int i = 0; i < listaAutores.size(); i++) {
            for (int j = 0; j < listaRelacion.size(); j++) {
                if(listaAutores.get(i).getNombre().equals(listaRelacion.get(j).getNombreUnico())){                   
                    salida += listaRelacion.get(j).getTituloObra() + " - ";
                    listaAutores.get(i).setListaObras(salida);
                }
            }
            salida = "";
        }
    }
    
    private void autoresPorDefecto(){
        Autor a = new Autor("Autor 1", "a1", "a1", "1234", "Cedula", "Autor", "Ninguna");
        Autor b = new Autor("Autor 2", "a2", "a2", "4567", "Cedula", "Autor", "Ninguna");
        Autor c = new Autor("Autor 3", "a3", "a3", "6789", "Cedula", "Autor", "Ninguna");
        listaAutores.addAll(a,b,c);
        listaUsuarios.addAll(a,b,c);
    }
    
    private void bibliotecariosPorDefecto(){
        Bibliotecario a = new Bibliotecario("Hans", "hansinho", "hans21", "3-0512-0587", "Cedula", "Bibliotecario");
        listaBibliotecarios.add(a);
        listaUsuarios.add(a);
    }
    
    private void libroPorDefecto(){
        Libro a = new Libro("1", "Ciencia Ficción", ":v", "El Señor de los Anillos", LocalDate.now(), "Autor 1");
        Libro b = new Libro("2", "Ciencia Ficción", ":v", "Harry Potter", LocalDate.now(), "Autor 2");
        Libro c = new Libro("3", "Terror", ":v", "It", LocalDate.now(), "Autor 3");
        Libro d = new Libro("4", "Ciencia Ficción", ":v", "El Hobbit", LocalDate.now(), "Autor 1");
        Libro e = new Libro("5", "Ciencia Ficción", ":v", "Animales Fantasticos", LocalDate.now(), "Autor 2");
        listaLibros.addAll(a,b,c,d,e);
        
        Relacion aR = new Relacion("El Señor de los Anillos", "Autor 1", "Libro");
        Relacion bR = new Relacion("Harry Potter", "Autor 2", "Libro");
        Relacion cR = new Relacion("It", "Autor 3", "Libro");
        Relacion dR = new Relacion("El Hobbit", "Autor 1", "Libro");
        Relacion eR = new Relacion("Animales Fantasticos", "Autor 2", "Libro");
        listaRelacion.addAll(aR,bR,cR,dR,eR);
    }

    public static ObservableList<Prestamo> getListaPrestamo() {
        return listaPrestamo;
    }

    public static void setListaPrestamo(ObservableList<Prestamo> listaPrestamo) {
        Listas.listaPrestamo = listaPrestamo;
    }
    
    public static ObservableList<Relacion> getListaRelacion() {
        return listaRelacion;
    }

    public static void setListaRelacion(ObservableList<Relacion> listaRelacion) {
        Listas.listaRelacion = listaRelacion;
    }

    public static ObservableList<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setListaUsuarios(ObservableList<Usuarios> listaUsuarios) {
        Listas.listaUsuarios = listaUsuarios;
    }

    public static ObservableList<Autor> getListaAutores() {
        return listaAutores;
    }

    public static void setListaAutores(ObservableList<Autor> listaAutores) {
        Listas.listaAutores = listaAutores;
    }

    public static ObservableList<Object> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public static void setListaBibliotecarios(ObservableList<Object> listaBibliotecarios) {
        Listas.listaBibliotecarios = listaBibliotecarios;
    }

    public static ObservableList<Object> getListaRevistas() {
        return listaRevistas;
    }

    public static void setListaRevistas(ObservableList<Object> listaRevistas) {
        Listas.listaRevistas = listaRevistas;
    }

    public static ObservableList<Object> getListaTesis() {
        return listaTesis;
    }

    public static void setListaTesis(ObservableList<Object> listaTesis) {
        Listas.listaTesis = listaTesis;
    }

    public static ObservableList<Libro> getListaLibros() {
        return listaLibros;
    }

    public static void setListaLibros(ObservableList<Libro> listaLibros) {
        Listas.listaLibros = listaLibros;
    }

    public static ObservableList<Object> getListaPeriodicos() {
        return listaPeriodicos;
    }

    public static void setListaPeriodicos(ObservableList<Object> listaPeriodicos) {
        Listas.listaPeriodicos = listaPeriodicos;
    }

    public static ObservableList<Object> getListaMemorias() {
        return listaMemorias;
    }

    public static void setListaMemorias(ObservableList<Object> listaMemorias) {
        Listas.listaMemorias = listaMemorias;
    }

    public static ObservableList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void setListaClientes(ObservableList<Cliente> listaClientes) {
        Listas.listaClientes = listaClientes;
    }

    public static ObservableList<Otro> getListaOtros() {
        return listaOtros;
    }

    public static void setListaOtros(ObservableList<Otro> listaOtros) {
        Listas.listaOtros = listaOtros;
    }
    

    
    
    
    
    
    
    
    
    
}
