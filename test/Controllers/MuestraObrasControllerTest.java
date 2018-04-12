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
public class MuestraObrasControllerTest {
    
    public MuestraObrasControllerTest() {
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
     * Test of initialize method, of class MuestraObrasController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        MuestraObrasController instance = new MuestraObrasController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverButton method, of class MuestraObrasController.
     */
    @Test
    public void testVolverButton() throws Exception {
        System.out.println("volverButton");
        ActionEvent event = null;
        MuestraObrasController instance = new MuestraObrasController();
        instance.volverButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adminObrasButton method, of class MuestraObrasController.
     */
    @Test
    public void testAdminObrasButton() throws Exception {
        System.out.println("adminObrasButton");
        ActionEvent event = null;
        MuestraObrasController instance = new MuestraObrasController();
        instance.adminObrasButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of llenarComboBox method, of class MuestraObrasController.
     */
    @Test
    public void testLlenarComboBox() {
        System.out.println("llenarComboBox");
        MuestraObrasController instance = new MuestraObrasController();
        instance.llenarComboBox();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
