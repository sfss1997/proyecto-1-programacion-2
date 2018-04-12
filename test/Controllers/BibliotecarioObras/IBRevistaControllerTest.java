/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Domain.Revistas;
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
public class IBRevistaControllerTest {
    
    public IBRevistaControllerTest() {
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
     * Test of initialize method, of class IBRevistaController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        IBRevistaController instance = new IBRevistaController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class IBRevistaController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        IBRevistaController instance = new IBRevistaController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarButton method, of class IBRevistaController.
     */
    @Test
    public void testAgregarButton() {
        System.out.println("agregarButton");
        IBRevistaController instance = new IBRevistaController();
        instance.agregarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarButton method, of class IBRevistaController.
     */
    @Test
    public void testModificarButton() {
        System.out.println("modificarButton");
        IBRevistaController instance = new IBRevistaController();
        instance.modificarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarButton method, of class IBRevistaController.
     */
    @Test
    public void testEliminarButton() {
        System.out.println("eliminarButton");
        IBRevistaController instance = new IBRevistaController();
        instance.eliminarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarButton method, of class IBRevistaController.
     */
    @Test
    public void testLimpiarButton() {
        System.out.println("limpiarButton");
        IBRevistaController instance = new IBRevistaController();
        instance.limpiarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAutorButton method, of class IBRevistaController.
     */
    @Test
    public void testAgregarAutorButton() throws Exception {
        System.out.println("agregarAutorButton");
        ActionEvent event = null;
        IBRevistaController instance = new IBRevistaController();
        instance.agregarAutorButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarBusquedaComboBox method, of class IBRevistaController.
     */
    @Test
    public void testLlenarBusquedaComboBox() {
        System.out.println("llenarBusquedaComboBox");
        IBRevistaController instance = new IBRevistaController();
        instance.llenarBusquedaComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarAutorComboBox method, of class IBRevistaController.
     */
    @Test
    public void testLlenarAutorComboBox() {
        System.out.println("llenarAutorComboBox");
        IBRevistaController instance = new IBRevistaController();
        instance.llenarAutorComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablaLibrosSeleccionado method, of class IBRevistaController.
     */
    @Test
    public void testGetTablaLibrosSeleccionado() {
        System.out.println("getTablaLibrosSeleccionado");
        IBRevistaController instance = new IBRevistaController();
        Revistas expResult = null;
        Revistas result = instance.getTablaLibrosSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
