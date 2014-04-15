/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

import java.rmi.RemoteException;
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
public class QuizServerLauncherTest {
    
    public QuizServerLauncherTest() {
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
     * Test of close method, of class QuizServerLauncher.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        QuizServerLauncher instance = new QuizServerLauncher();
        instance.close();
        boolean test = instance.getRunningVariable();
        assertFalse(test);
    }

    /**
     * Test of main method, of class QuizServerLauncher.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        QuizServerLauncher.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of launch method, of class QuizServerLauncher.
     */
    @Test
    public void testLaunch() throws Exception {
        System.out.println("launch");
        QuizServerLauncher instance = new QuizServerLauncher();
        instance.launch();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRunningVariable method, of class QuizServerLauncher.
     */
    @Test
    public void testGetRunningVariable() throws RemoteException {
        System.out.println("getRunningVariable");
        QuizServerLauncher instance = new QuizServerLauncher();
        boolean expResult = false;
        boolean result = instance.getRunningVariable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
