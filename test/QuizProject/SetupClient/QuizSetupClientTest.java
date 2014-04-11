/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.SetupClient;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
public class QuizSetupClientTest {
    
    public QuizSetupClientTest() {
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
     * Test of launch method, of class QuizSetupClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testLaunch() throws Exception {
        System.out.println("launch");
        QuizSetupClient instance = new QuizSetupClient();
        instance.launch();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class QuizSetupClient.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        QuizSetupClient.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menu method, of class QuizSetupClient.
     * @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testMenu() throws NotBoundException, MalformedURLException, RemoteException {
        System.out.println("menu");
        QuizSetupClient instance = new QuizSetupClient();
        int expResult = 0;
        int result = instance.menu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keepLooping method, of class QuizSetupClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testKeepLooping() throws Exception {
        System.out.println("keepLooping");
        QuizSetupClient instance = new QuizSetupClient();
        instance.keepLooping();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clientAddsSetOfQuestions method, of class QuizSetupClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testClientAddsSetOfQuestions() throws Exception {
        System.out.println("clientAddsSetOfQuestions");
        int id = 0;
        QuizSetupClient instance = new QuizSetupClient();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.clientAddsSetOfQuestions(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clientAddsAnswers method, of class QuizSetupClient.
     * @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testClientAddsAnswers() throws NotBoundException, MalformedURLException, RemoteException {
        System.out.println("clientAddsAnswers");
        String question = "";
        QuizSetupClient instance = new QuizSetupClient();
        String[] expResult = null;
        String[] result = instance.clientAddsAnswers(question);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dealWithSwitchRequest method, of class QuizSetupClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testDealWithSwitchRequest() throws Exception {
        System.out.println("dealWithSwitchRequest");
        int choice = 0;
        QuizSetupClient instance = new QuizSetupClient();
        instance.dealWithSwitchRequest(choice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeDown method, of class QuizSetupClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testCloseDown() throws Exception {
        System.out.println("closeDown");
        QuizSetupClient instance = new QuizSetupClient();
        instance.closeDown();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
