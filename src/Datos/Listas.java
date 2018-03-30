/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Domain.Autor;
import Domain.Cliente;
import Domain.Libro;
import Domain.Usuarios;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author fabian
 */
public class Listas {
    
    
    public static ObservableList<Usuarios> listaUsuarios = FXCollections.observableArrayList();
    public static ObservableList<Autor> listaAutores = FXCollections.observableArrayList();
    public static ObservableList<Object> listaBibliotecarios = FXCollections.observableArrayList();
    public static ObservableList<Object> listaRevistas = FXCollections.observableArrayList();
    public static ObservableList<Object> listaTesis = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaLibros = FXCollections.observableArrayList();
    public static ObservableList<Object> listaPeriodicos = FXCollections.observableArrayList();
    public static ObservableList<Object> listaMemorias = FXCollections.observableArrayList();
    public static ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    
    public Listas() {
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

    
    
    
    
    
}
