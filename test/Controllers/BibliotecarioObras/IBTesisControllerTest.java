/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioObras;

import Domain.Tesis;
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
public class IBTesisControllerTest {
    
    public IBTesisControllerTest() {
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
     * Test of initialize method, of class IBTesisController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        IBTesisController instance = new IBTesisController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class IBTesisController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        IBTesisController instance = new IBTesisController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarButton method, of class IBTesisController.
     */
    @Test
    public void testAgregarButton() {
        System.out.println("agregarButton");
        IBTesisController instance = new IBTesisController();
        instance.agregarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarButton method, of class IBTesisController.
     */
    @Test
    public void testModificarButton() {
        System.out.println("modificarButton");
        IBTesisController instance = new IBTesisController();
        instance.modificarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarButton method, of class IBTesisController.
     */
    @Test
    public void testEliminarButton() {
        System.out.println("eliminarButton");
        IBTesisController instance = new IBTesisController();
        instance.eliminarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarButton method, of class IBTesisController.
     */
    @Test
    public void testLimpiarButton() {
        System.out.println("limpiarButton");
        IBTesisController instance = new IBTesisController();
        instance.limpiarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAutorButton method, of class IBTesisController.
     */
    @Test
    public void testAgregarAutorButton() throws Exception {
        System.out.println("agregarAutorButton");
        ActionEvent event = null;
        IBTesisController instance = new IBTesisController();
        instance.agregarAutorButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarBusquedaComboBox method, of class IBTesisController.
     */
    @Test
    public void testLlenarBusquedaComboBox() {
        System.out.println("llenarBusquedaComboBox");
        IBTesisController instance = new IBTesisController();
        instance.llenarBusquedaComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarAutorComboBox method, of class IBTesisController.
     */
    @Test
    public void testLlenarAutorComboBox() {
        System.out.println("llenarAutorComboBox");
        IBTesisController instance = new IBTesisController();
        instance.llenarAutorComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablaLibrosSeleccionado method, of class IBTesisController.
     */
    @Test
    public void testGetTablaLibrosSeleccionado() {
        System.out.println("getTablaLibrosSeleccionado");
        IBTesisController instance = new IBTesisController();
        Tesis expResult = null;
        Tesis result = instance.getTablaLibrosSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
