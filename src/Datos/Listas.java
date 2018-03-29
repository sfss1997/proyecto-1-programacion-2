/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Domain.Libro;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author fabian
 */
public class Listas {
    
    
    public static ObservableList<Libro> listaUsuarios = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaAutores = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaBibliotecarios = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaRevistas = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaTesis = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaLibros = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaPeriodicos = FXCollections.observableArrayList();
    public static ObservableList<Libro> listaMemorias = FXCollections.observableArrayList();
    
    public Listas() {
    }

    public static ObservableList<Libro> getListaUsuarios() {
        return listaUsuarios;
    }

    public static void setListaUsuarios(ObservableList<Libro> listaUsuarios) {
        Listas.listaUsuarios = listaUsuarios;
    }

    public static ObservableList<Libro> getListaAutores() {
        return listaAutores;
    }

    public static void setListaAutores(ObservableList<Libro> listaAutores) {
        Listas.listaAutores = listaAutores;
    }

    public static ObservableList<Libro> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public static void setListaBibliotecarios(ObservableList<Libro> listaBibliotecarios) {
        Listas.listaBibliotecarios = listaBibliotecarios;
    }

    public static ObservableList<Libro> getListaRevistas() {
        return listaRevistas;
    }

    public static void setListaRevistas(ObservableList<Libro> listaRevistas) {
        Listas.listaRevistas = listaRevistas;
    }

    public static ObservableList<Libro> getListaTesis() {
        return listaTesis;
    }

    public static void setListaTesis(ObservableList<Libro> listaTesis) {
        Listas.listaTesis = listaTesis;
    }

    public static ObservableList<Libro> getListaLibros() {
        return listaLibros;
    }

    public static void setListaLibros(ObservableList<Libro> listaLibros) {
        Listas.listaLibros = listaLibros;
    }

    public static ObservableList<Libro> getListaPeriodicos() {
        return listaPeriodicos;
    }

    public static void setListaPeriodicos(ObservableList<Libro> listaPeriodicos) {
        Listas.listaPeriodicos = listaPeriodicos;
    }

    public static ObservableList<Libro> getListaMemorias() {
        return listaMemorias;
    }

    public static void setListaMemorias(ObservableList<Libro> listaMemorias) {
        Listas.listaMemorias = listaMemorias;
    }

    
    
    
    
}
