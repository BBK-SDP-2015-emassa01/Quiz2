/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Esha
 */
public class GetInputTest {
    
    public GetInputTest() {
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
     * Test of getIntInput method, of class GetInput.
     */
    @Test
    public void testGetIntInput() {
        System.out.println("getIntInput");
        GetInput instance = new GetInput();
        int expResult = 0;
        int result = instance.getIntInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("The test requires Scanner Class and KeyBoard input.");
    }

    /**
     * Test of getStringInput method, of class GetInput.
     */
    @Test
    public void testGetStringInput() {
        System.out.println("getStringInput");
        GetInput instance = new GetInput();
        String expResult = "";
        String result = instance.getStringInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("The test requires Scanner Class and KeyBoard input.");
    }
}
