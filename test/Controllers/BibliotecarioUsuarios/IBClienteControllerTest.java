/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.BibliotecarioUsuarios;

import Domain.Cliente;
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
public class IBClienteControllerTest {
    
    public IBClienteControllerTest() {
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
     * Test of initialize method, of class IBClienteController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        IBClienteController instance = new IBClienteController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class IBClienteController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        IBClienteController instance = new IBClienteController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarButton method, of class IBClienteController.
     */
    @Test
    public void testAgregarButton() {
        System.out.println("agregarButton");
        IBClienteController instance = new IBClienteController();
        instance.agregarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarButton method, of class IBClienteController.
     */
    @Test
    public void testModificarButton() {
        System.out.println("modificarButton");
        IBClienteController instance = new IBClienteController();
        instance.modificarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarButton method, of class IBClienteController.
     */
    @Test
    public void testEliminarButton() {
        System.out.println("eliminarButton");
        IBClienteController instance = new IBClienteController();
        instance.eliminarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarButton method, of class IBClienteController.
     */
    @Test
    public void testLimpiarButton() {
        System.out.println("limpiarButton");
        IBClienteController instance = new IBClienteController();
        instance.limpiarButton();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarAutorButton method, of class IBClienteController.
     */
    @Test
    public void testAgregarAutorButton() throws Exception {
        System.out.println("agregarAutorButton");
        ActionEvent event = null;
        IBClienteController instance = new IBClienteController();
        instance.agregarAutorButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarPrestamoObras method, of class IBClienteController.
     */
    @Test
    public void testValidarPrestamoObras() {
        System.out.println("validarPrestamoObras");
        IBClienteController instance = new IBClienteController();
        boolean expResult = false;
        boolean result = instance.validarPrestamoObras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenaTipoIDComboBox method, of class IBClienteController.
     */
    @Test
    public void testLlenaTipoIDComboBox() {
        System.out.println("llenaTipoIDComboBox");
        IBClienteController instance = new IBClienteController();
        instance.llenaTipoIDComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTablaLibrosSeleccionado method, of class IBClienteController.
     */
    @Test
    public void testGetTablaLibrosSeleccionado() {
        System.out.println("getTablaLibrosSeleccionado");
        IBClienteController instance = new IBClienteController();
        Cliente expResult = null;
        Cliente result = instance.getTablaLibrosSeleccionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
