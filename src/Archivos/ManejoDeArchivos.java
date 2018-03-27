package Archivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ManejoDeArchivos implements Serializable {

    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String nombreArchivo;

    public ManejoDeArchivos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    //Obtiene el nombre del archivo

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    //Crea el archivo
    private void crearArchivo() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(this.nombreArchivo));
        } catch (Exception ex) {
        }
    }//crearArchivo

    /*
     Escribe la informacion en el archivo
     */
    private void escribirArchivo(Object objeto) {
        try {

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(this.nombreArchivo));

            oos.writeObject(objeto);
            oos.close();

        } catch (Exception ex) {

        }
    }//escribirArchivo

    /*
     Inserta el objeto en el archivo
     Hace uso del escribir archivo para 
     poder escribir el objeto en la lista
     Además hace uso del crear archivo para 
     crear un archivo en caso de no existir
     */
    public void insertarObjeto(Object obj) {
        File file = new File(this.nombreArchivo);
        if (!file.exists()) {
            crearArchivo();
            escribirArchivo(obj);//para escribir en el archivo
        } else {
            escribirArchivo(obj);
        }

    }//fin insertarObjeto()

    /*
     Se encarga de cargar el archivo en la estructura de datos nuevamente
     */
    public Object cargarArchivo() {
        Object aux = null;
        try {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(this.nombreArchivo));

            // Se lee el primer objeto
            aux = ois.readObject();  //objeto leído
            ois.close();
           return aux;
        } catch (EOFException ex) {
            //System.out.println(ex.getMessage());
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
        return aux;
    }//cargarArchivo()

}//Fin de la clase