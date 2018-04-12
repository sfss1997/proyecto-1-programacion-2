/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Domain.Prestamo;
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
public class ObrasPrestamosControllerTest {
    
    public ObrasPrestamosControllerTest() {
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
     * Test of initialize method, of class ObrasPrestamosController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        ObrasPrestamosController instance = new ObrasPrestamosController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class ObrasPrestamosController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        ObrasPrestamosController instance = new ObrasPrestamosController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarButton method, of class ObrasPrestamosController.
     */
    @Test
    public void testAgregarButton() {
        System.out.println("agregarButton");
        ObrasPrestamosController instance = new ObrasPrestamosController();
        instance.agregarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarButton method, of class ObrasPrestamosController.
     */
    @Test
    public void testModificarButton() {
        System.out.println("modificarButton");
        ObrasPrestamosController instance = new ObrasPrestamosController();
        instance.modificarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarButton method, of class ObrasPrestamosController.
     */
    @Test
    public void testEliminarButton() {
        System.out.println("eliminarButton");
        ObrasPrestamosController instance = new ObrasPrestamosController();
        instance.eliminarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarButton method, of class ObrasPrestamosController.
     */
    @Test
    public void testLimpiarButton() {
        System.out.println("limpiarButton");
        ObrasPrestamosController instance = new ObrasPrestamosController();
        instance.limpiarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarComboBox method, of class ObrasPrestamosController.
     */
    @Test
    public void testLlenarComboBox() {
        System.out.println("llenarComboBox");
        ObrasPrestamosController instance = new ObrasPrestamosController();
        instance.llenarComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarClienteButton method, of class ObrasPrestamosController.
     */
    @Test
    public void testAgregarClienteButton() throws Exception {
        System.out.println("agregarClienteButton");
        ActionEvent event = null;
        ObrasPrestamosController instance = new ObrasPrestamosController();
        instance.agregarClienteButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablaPrestamoSeleccionado method, of class ObrasPrestamosController.
     */
    @Test
    public void testGetTablaPrestamoSeleccionado() {
        System.out.println("getTablaPrestamoSeleccionado");
        ObrasPrestamosController instance = new ObrasPrestamosController();
        Prestamo expResult = null;
        Prestamo result = instance.getTablaPrestamoSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
