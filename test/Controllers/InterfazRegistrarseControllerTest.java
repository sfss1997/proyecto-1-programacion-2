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
public class InterfazRegistrarseControllerTest {
    
    public InterfazRegistrarseControllerTest() {
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
     * Test of initialize method, of class InterfazRegistrarseController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        InterfazRegistrarseController instance = new InterfazRegistrarseController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarseButton method, of class InterfazRegistrarseController.
     */
    @Test
    public void testRegistrarseButton() throws Exception {
        System.out.println("registrarseButton");
        ActionEvent event = null;
        InterfazRegistrarseController instance = new InterfazRegistrarseController();
        instance.registrarseButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class InterfazRegistrarseController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        InterfazRegistrarseController instance = new InterfazRegistrarseController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
