/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Domain.Periodico;
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
public class IBPeriodicoControllerTest {
    
    public IBPeriodicoControllerTest() {
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
     * Test of initialize method, of class IBPeriodicoController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class IBPeriodicoController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarButton method, of class IBPeriodicoController.
     */
    @Test
    public void testAgregarButton() {
        System.out.println("agregarButton");
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.agregarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarButton method, of class IBPeriodicoController.
     */
    @Test
    public void testModificarButton() {
        System.out.println("modificarButton");
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.modificarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarButton method, of class IBPeriodicoController.
     */
    @Test
    public void testEliminarButton() {
        System.out.println("eliminarButton");
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.eliminarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarButton method, of class IBPeriodicoController.
     */
    @Test
    public void testLimpiarButton() {
        System.out.println("limpiarButton");
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.limpiarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAutorButton method, of class IBPeriodicoController.
     */
    @Test
    public void testAgregarAutorButton() throws Exception {
        System.out.println("agregarAutorButton");
        ActionEvent event = null;
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.agregarAutorButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarBusquedaComboBox method, of class IBPeriodicoController.
     */
    @Test
    public void testLlenarBusquedaComboBox() {
        System.out.println("llenarBusquedaComboBox");
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.llenarBusquedaComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarAutorComboBox method, of class IBPeriodicoController.
     */
    @Test
    public void testLlenarAutorComboBox() {
        System.out.println("llenarAutorComboBox");
        IBPeriodicoController instance = new IBPeriodicoController();
        instance.llenarAutorComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablaLibrosSeleccionado method, of class IBPeriodicoController.
     */
    @Test
    public void testGetTablaLibrosSeleccionado() {
        System.out.println("getTablaLibrosSeleccionado");
        IBPeriodicoController instance = new IBPeriodicoController();
        Periodico expResult = null;
        Periodico result = instance.getTablaLibrosSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
