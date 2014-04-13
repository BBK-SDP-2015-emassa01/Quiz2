/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.PlayerClient;


import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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
public class QuizPlayerClientTest {
    
    public QuizPlayerClientTest() {
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
     * Test of terminateQuiz method, of class QuizPlayerClient.
     *  @throws java.rmi.NotBoundException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.RemoteException
     */
    @Test
    public void testTerminateQuiz() throws NotBoundException, MalformedURLException, RemoteException {
        System.out.println("terminateQuiz");
        QuizPlayerClient instance = new QuizPlayerClient();
        System.out.println("Requires Scanner Object...");
        instance.terminateQuiz();
        assertFalse(instance.running);
        
    }

    /**
     * Test of menu method, of class QuizPlayerClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testMenu() throws Exception {
        System.out.println("menu");
        QuizPlayerClient instance = new QuizPlayerClient();
        int expResult = 1;
        int result = instance.menu();
        System.out.println("Tesing '1' ");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
//     * Test of selectQuizToPlay method, of class QuizPlayerClient.
//     * @throws java.rmi.NotBoundException
//     * @throws java.net.MalformedURLException
//     * @throws java.rmi.RemoteException
//     */
//    @Test
//    public void testSelectQuizToPlay() throws NotBoundException, MalformedURLException, RemoteException{
//        System.out.println("selectQuizToPlay");
//        QuizPlayerClient instance = new QuizPlayerClient();
//        int expResult = 0;
//        int result = instance.selectQuizToPlay();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of printOutQuizList method, of class QuizPlayerClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testPrintOutQuizList() throws Exception {
        System.out.println("printOutQuizList");
        QuizPlayerClient instance = new QuizPlayerClient();
        instance.printOutQuizList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighestScoreForPlayer method, of class QuizPlayerClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetHighestScoreForPlayer() throws Exception {
        System.out.println("getHighestScoreForPlayer");
        int quizID = 1;
        
        QuizPlayerClient instance = new QuizPlayerClient();
        int expResult = 5;
        int result = instance.getHighestScoreForPlayer(quizID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of playSelectedQuiz method, of class QuizPlayerClient.
     * @throws java.lang.Exception
     */
    @Test
    public void testPlaySelectedQuiz() throws Exception {
        System.out.println("playSelectedQuiz");
        int selectedQuizID = 0;
        QuizPlayerClient instance = new QuizPlayerClient();
        instance.playSelectedQuiz(selectedQuizID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
