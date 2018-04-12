/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Domain.Memoria;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fabian
 */
public class IBMemoriaControllerTest {
    
    public IBMemoriaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class IBMemoriaController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        IBMemoriaController instance = new IBMemoriaController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class IBMemoriaController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        IBMemoriaController instance = new IBMemoriaController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarButton method, of class IBMemoriaController.
     */
    @Test
    public void testAgregarButton() {
        System.out.println("agregarButton");
        IBMemoriaController instance = new IBMemoriaController();
        instance.agregarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarButton method, of class IBMemoriaController.
     */
    @Test
    public void testModificarButton() {
        System.out.println("modificarButton");
        IBMemoriaController instance = new IBMemoriaController();
        instance.modificarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarButton method, of class IBMemoriaController.
     */
    @Test
    public void testEliminarButton() {
        System.out.println("eliminarButton");
        IBMemoriaController instance = new IBMemoriaController();
        instance.eliminarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarButton method, of class IBMemoriaController.
     */
    @Test
    public void testLimpiarButton() {
        System.out.println("limpiarButton");
        IBMemoriaController instance = new IBMemoriaController();
        instance.limpiarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAutorButton method, of class IBMemoriaController.
     */
    @Test
    public void testAgregarAutorButton() throws Exception {
        System.out.println("agregarAutorButton");
        ActionEvent event = null;
        IBMemoriaController instance = new IBMemoriaController();
        instance.agregarAutorButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarBusquedaComboBox method, of class IBMemoriaController.
     */
    @Test
    public void testLlenarBusquedaComboBox() {
        System.out.println("llenarBusquedaComboBox");
        IBMemoriaController instance = new IBMemoriaController();
        instance.llenarBusquedaComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarAutorComboBox method, of class IBMemoriaController.
     */
    @Test
    public void testLlenarAutorComboBox() {
        System.out.println("llenarAutorComboBox");
        IBMemoriaController instance = new IBMemoriaController();
        instance.llenarAutorComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablaLibrosSeleccionado method, of class IBMemoriaController.
     */
    @Test
    public void testGetTablaLibrosSeleccionado() {
        System.out.println("getTablaLibrosSeleccionado");
        IBMemoriaController instance = new IBMemoriaController();
        Memoria expResult = null;
        Memoria result = instance.getTablaLibrosSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
