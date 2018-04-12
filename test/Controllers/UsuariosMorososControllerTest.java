/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
public class UsuariosMorososControllerTest {
    
    public UsuariosMorososControllerTest() {
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
     * Test of initialize method, of class UsuariosMorososController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        UsuariosMorososController instance = new UsuariosMorososController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisaMorosos method, of class UsuariosMorososController.
     */
    @Test
    public void testRevisaMorosos() {
        System.out.println("revisaMorosos");
        UsuariosMorososController instance = new UsuariosMorososController();
        instance.revisaMorosos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class UsuariosMorososController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        UsuariosMorososController instance = new UsuariosMorososController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adminUsuariosButton method, of class UsuariosMorososController.
     */
    @Test
    public void testAdminUsuariosButton() throws Exception {
        System.out.println("adminUsuariosButton");
        ActionEvent event = null;
        UsuariosMorososController instance = new UsuariosMorososController();
        instance.adminUsuariosButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
