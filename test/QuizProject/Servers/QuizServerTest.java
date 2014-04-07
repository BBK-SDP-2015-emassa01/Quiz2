/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Esha
 */
public class QuizServerTest {
    
    public QuizServerTest() {
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
     * Test of serialize method, of class QuizServer.
     */
    @Test
    public void testSerialize() throws Exception {
        System.out.println("serialize");
        Set<Quiz> quizzes = new HashSet<>();
        Map<Integer, ArrayList<String>> quizMap = new HashMap<>();
        Map<String, String[]> questionAnswers = new HashMap<>();
        Map<Integer, Player> highestScorePlayerIDMap = new HashMap<>();
        String fileName = "testQuizData.txt";
        int quizIDValue = 2;
        QuizServer instance = new QuizServer();
        instance.serialize(quizzes, quizMap, questionAnswers, highestScorePlayerIDMap, fileName, quizIDValue);
        //serializes fine.
    }

    /**
     * Test of getWinnerForQuiz method, of class QuizServer.
     */
    @Test
    public void testGetWinnerForQuiz() throws Exception {
        System.out.println("getWinnerForQuiz");
        int quizID = 3;
        QuizServer instance = new QuizServer();
        Player winner = new Player();
        winner.setPlayerName("winner");
        instance.setHighestScorePlayerIDMap(quizID, winner);
        String expResult = "THE WINNER FOR QUIZ 3 IS WINNER\nHIGHEST SCORE: 0";
        String result = instance.getWinnerForQuiz(quizID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHighestScorePlayerIDMap method, of class QuizServer.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetHighestScorePlayerIDMap() throws Exception {
        System.out.println("getHighestScorePlayerIDMap");
        QuizServer instance = new QuizServer();
        Player winner = new Player();
        instance.setHighestScorePlayerIDMap(2, winner);
        Map<Integer, Player> expResult = null;
        Map<Integer, Player> result = instance.getHighestScorePlayerIDMap();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setHighestScorePlayerIDMap method, of class QuizServer.
     */
    @Test
    public void testSetHighestScorePlayerIDMap() throws Exception {
        System.out.println("setHighestScorePlayerIDMap");
        int id = 0;
        Player player = null;
        QuizServer instance = new QuizServer();
        instance.setHighestScorePlayerIDMap(id, player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuizzes method, of class QuizServer.
     */
    @Test
    public void testGetQuizzes() throws Exception {
        System.out.println("getQuizzes");
        QuizServer instance = new QuizServer();
        Set<Quiz> expResult = null;
        Set<Quiz> result = instance.getQuizzes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuizMap method, of class QuizServer.
     */
    @Test
    public void testGetQuizMap() throws Exception {
        System.out.println("getQuizMap");
        QuizServer instance = new QuizServer();
        Map<Integer, ArrayList<String>> expResult = null;
        Map<Integer, ArrayList<String>> result = instance.getQuizMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionsAndAnswers method, of class QuizServer.
     */
    @Test
    public void testGetQuestionsAndAnswers() throws Exception {
        System.out.println("getQuestionsAndAnswers");
        QuizServer instance = new QuizServer();
        Map expResult = null;
        Map result = instance.getQuestionsAndAnswers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileName method, of class QuizServer.
     */
    @Test
    public void testGetFileName() throws Exception {
        System.out.println("getFileName");
        QuizServer instance = new QuizServer();
        String expResult = "";
        String result = instance.getFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class QuizServer.
     */
    @Test
    public void testGetID() throws Exception {
        System.out.println("getID");
        QuizServer instance = new QuizServer();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighestScoreForQuiz method, of class QuizServer.
     */
    @Test
    public void testGetHighestScoreForQuiz() throws Exception {
        System.out.println("getHighestScoreForQuiz");
        int QuizID = 0;
        QuizServer instance = new QuizServer();
        int expResult = 0;
        int result = instance.getHighestScoreForQuiz(QuizID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighestScoreForQuiz method, of class QuizServer.
     */
    @Test
    public void testSetHighestScoreForQuiz() throws Exception {
        System.out.println("setHighestScoreForQuiz");
        int QuizID = 0;
        int score = 0;
        QuizServer instance = new QuizServer();
        instance.setHighestScoreForQuiz(QuizID, score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addQuiz method, of class QuizServer.
     */
    @Test
    public void testAddQuiz() throws Exception {
        System.out.println("addQuiz");
        String s = "";
        QuizServer instance = new QuizServer();
        int expResult = 0;
        int result = instance.addQuiz(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentQuizList method, of class QuizServer.
     */
    @Test
    public void testGetCurrentQuizList() throws Exception {
        System.out.println("getCurrentQuizList");
        QuizServer instance = new QuizServer();
        Object[] expResult = null;
        Object[] result = instance.getCurrentQuizList();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfQuestionsInQuiz method, of class QuizServer.
     */
    @Test
    public void testGetListOfQuestionsInQuiz() throws Exception {
        System.out.println("getListOfQuestionsInQuiz");
        int id = 0;
        QuizServer instance = new QuizServer();
        Object[] expResult = null;
        Object[] result = instance.getListOfQuestionsInQuiz(id);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfQuizIDExists method, of class QuizServer.
     */
    @Test
    public void testCheckIfQuizIDExists() throws Exception {
        System.out.println("checkIfQuizIDExists");
        int ID = 0;
        QuizServer instance = new QuizServer();
        String expResult = "";
        String result = instance.checkIfQuizIDExists(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serverAddsSetOfQuestions method, of class QuizServer.
     */
    @Test
    public void testServerAddsSetOfQuestions() throws Exception {
        System.out.println("serverAddsSetOfQuestions");
        int ID = 0;
        ArrayList<String> newListOfQuestions = null;
        QuizServer instance = new QuizServer();
        instance.serverAddsSetOfQuestions(ID, newListOfQuestions);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serverAddsAnswers method, of class QuizServer.
     */
    @Test
    public void testServerAddsAnswers() throws Exception {
        System.out.println("serverAddsAnswers");
        String question = "";
        String[] answers = null;
        QuizServer instance = new QuizServer();
        instance.serverAddsAnswers(question, answers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkObjectIsNotNull method, of class QuizServer.
     */
    @Test
    public void testCheckObjectIsNotNull() throws Exception {
        System.out.println("checkObjectIsNotNull");
        Object obj = null;
        QuizServer instance = new QuizServer();
        instance.checkObjectIsNotNull(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
