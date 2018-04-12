/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioUsuarios;

import Domain.Bibliotecario;
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
public class IBBibliotecarioControllerTest {
    
    public IBBibliotecarioControllerTest() {
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
     * Test of initialize method, of class IBBibliotecarioController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        IBBibliotecarioController instance = new IBBibliotecarioController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class IBBibliotecarioController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        IBBibliotecarioController instance = new IBBibliotecarioController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarButton method, of class IBBibliotecarioController.
     */
    @Test
    public void testAgregarButton() {
        System.out.println("agregarButton");
        IBBibliotecarioController instance = new IBBibliotecarioController();
        instance.agregarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarButton method, of class IBBibliotecarioController.
     */
    @Test
    public void testModificarButton() {
        System.out.println("modificarButton");
        IBBibliotecarioController instance = new IBBibliotecarioController();
        instance.modificarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarButton method, of class IBBibliotecarioController.
     */
    @Test
    public void testEliminarButton() {
        System.out.println("eliminarButton");
        IBBibliotecarioController instance = new IBBibliotecarioController();
        instance.eliminarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarButton method, of class IBBibliotecarioController.
     */
    @Test
    public void testLimpiarButton() {
        System.out.println("limpiarButton");
        IBBibliotecarioController instance = new IBBibliotecarioController();
        instance.limpiarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAutorButton method, of class IBBibliotecarioController.
     */
    @Test
    public void testAgregarAutorButton() throws Exception {
        System.out.println("agregarAutorButton");
        ActionEvent event = null;
        IBBibliotecarioController instance = new IBBibliotecarioController();
        instance.agregarAutorButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarPrestamoObras method, of class IBBibliotecarioController.
     */
    @Test
    public void testValidarPrestamoObras() {
        System.out.println("validarPrestamoObras");
        IBBibliotecarioController instance = new IBBibliotecarioController();
        boolean expResult = false;
        boolean result = instance.validarPrestamoObras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenaTipoIDComboBox method, of class IBBibliotecarioController.
     */
    @Test
    public void testLlenaTipoIDComboBox() {
        System.out.println("llenaTipoIDComboBox");
        IBBibliotecarioController instance = new IBBibliotecarioController();
        instance.llenaTipoIDComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablaLibrosSeleccionado method, of class IBBibliotecarioController.
     */
    @Test
    public void testGetTablaLibrosSeleccionado() {
        System.out.println("getTablaLibrosSeleccionado");
        IBBibliotecarioController instance = new IBBibliotecarioController();
        Bibliotecario expResult = null;
        Bibliotecario result = instance.getTablaLibrosSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
