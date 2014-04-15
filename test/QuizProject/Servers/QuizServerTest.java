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
     * Test of serialize method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testSerialize() throws Exception {
        System.out.println("serialize");
        Set<Quiz> quizzes = new HashSet<>();
        Map<Integer, ArrayList<String>> quizMap = new HashMap<>();
        Map<String, String[]> questionAnswers = new HashMap<>();
        Map<Integer, Player> highestScorePlayerIDMap = new HashMap<>();
        ArrayList<ClosedQuiz> closedQuizList = new ArrayList<>();
        String fileName = "testQuizData.txt";
        int quizIDValue = 2;
        QuizServerData instance = new QuizServerData();
        instance.serialize(quizzes, quizMap, questionAnswers, highestScorePlayerIDMap, fileName, quizIDValue, closedQuizList);
        //serializes fine.
    }

    /**
     * Test of getWinnerForQuiz method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetWinnerForQuiz() throws Exception {
        System.out.println("getWinnerForQuiz");
        int quizID = 3;
        QuizServerData instance = new QuizServerData();
        Player winner = new Player();
        winner.setPlayerName("winner");
        instance.setHighestScorePlayerIDMap(quizID, winner);
        String expResult = "THE WINNER FOR QUIZ 3 IS WINNER!!!\nHIGHEST SCORE: 0";
        String result = instance.getWinnerForQuiz(quizID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHighestScorePlayerIDMap method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetHighestScorePlayerIDMap() throws Exception {
        System.out.println("getHighestScorePlayerIDMap");
        QuizServerData instance = new QuizServerData();
        Player winner = new Player();
        Map<Integer, Player> expResult = new HashMap<>();
        Map<Integer, Player> result = instance.getHighestScorePlayerIDMap();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setHighestScorePlayerIDMap method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetHighestScorePlayerIDMap() throws Exception {
        System.out.println("setHighestScorePlayerIDMap");
        int id = 3;
        Player player = new Player();
        QuizServerData instance = new QuizServerData();
        instance.setHighestScorePlayerIDMap(id, player);

    }

    /**
     * Test of getQuizzes method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetQuizzes() throws Exception {
        System.out.println("getQuizzes");
        QuizServerData instance = new QuizServerData();
        Set<Quiz> expResult = new HashSet<>();
        Set<Quiz> result = instance.getQuizzes();
        for (Quiz a: result){
            System.out.println(a.toString());
        }
    }

    /**
     * Test of getQuizMap method, of class QuizServerData.
     */
    @Test
    public void testGetQuizMap() throws Exception {
        System.out.println("getQuizMap");
        QuizServerData instance = new QuizServerData();
        Map<Integer, ArrayList<String>> expResult = new HashMap<>();
        Map<Integer, ArrayList<String>> result = instance.getQuizMap();
        assertEquals(expResult, result);

    }

    /**
     * Test of getQuestionsAndAnswers method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetQuestionsAndAnswers() throws Exception {
        System.out.println("getQuestionsAndAnswers");
        QuizServerData instance = new QuizServerData();
        Map expResult = new HashMap<>();
        Map result = instance.getQuestionsAndAnswers();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFileName method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetFileName() throws Exception {
        System.out.println("getFileName");
        QuizServerData instance = new QuizServerData();
        String expResult = "quizData.txt";
        String result = instance.getFileName();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of getID method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetID() throws Exception {
        System.out.println("getID");
        QuizServerData instance = new QuizServerData();
        int expResult = 1;
        int result = instance.getID();
        assertEquals(expResult, result);
        /* sometimes the test fails because the tests create the 
        *QuizID class and a quizData.txt files that they serialize and deserialize that data..
        *if a quizData.txt file exists, the tests read data from that.
        *These tests pass when you delete all quizData.txt files and imagine a clean startup.
        */
        }

    /**
     * Test of getHighestScoreForQuiz method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetHighestScoreForQuiz() throws Exception {
        System.out.println("getHighestScoreForQuiz");
        int QuizID = 0;
        QuizServerData instance = new QuizServerData();
        int expResult = 0;
        int result = instance.getHighestScoreForQuiz(QuizID);
        assertEquals(expResult, result);
    }

    /**
     * Test of setHighestScoreForQuiz method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetHighestScoreForQuiz() throws Exception {
        System.out.println("setHighestScoreForQuiz");
        int QuizID = 0;
        int score = 0;
        QuizServerData instance = new QuizServerData();
        instance.setHighestScoreForQuiz(QuizID, score);
    }

    /**
     * Test of addQuiz method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddQuiz() throws Exception {
        System.out.println("addQuiz");
        String s = "Hi";
        boolean expResult = false;
        QuizServerData instance = new QuizServerData();
        instance.addQuiz(s);
        for (Quiz a: instance.getQuizzes()){
            if (a.getQuizName().equals(s)){
                expResult = true;
            }
        }
        assertTrue(expResult);

    }

    /**
     * Test of getCurrentQuizList method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCurrentQuizList() throws Exception {
        System.out.println("getCurrentQuizList");
        QuizServerData instance = new QuizServerData();
        Object[] expResult = null;
        Object[] result = instance.getCurrentQuizList();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getListOfQuestionsInQuiz method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetListOfQuestionsInQuiz() throws Exception {
        System.out.println("getListOfQuestionsInQuiz");
        int id = 0;
        QuizServerData instance = new QuizServerData();
        Object[] expResult = new Object[1];
        expResult[0] = "CLIENT TRIED TO ACCESS ID THAT DOES NOT EXIST";
        Object[] result = instance.getListOfQuestionsInQuiz(id);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of checkIfQuizIDExists method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testCheckIfQuizIDExists() throws Exception {
        System.out.println("checkIfQuizIDExists");
        int ID = 0;
        QuizServerData instance = new QuizServerData();
        String expResult = "CREATING QUIZ: 0";
        String result = instance.checkIfQuizIDExists(ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of serverAddsSetOfQuestions method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testServerAddsSetOfQuestions() throws Exception {
        System.out.println("serverAddsSetOfQuestions");
        int ID = 0;
        ArrayList<String> newListOfQuestions = null;
        QuizServerData instance = new QuizServerData();
        instance.serverAddsSetOfQuestions(ID, newListOfQuestions);
    }

    /**
     * Test of serverAddsAnswers method, of class QuizServerData.
     * @throws java.lang.Exception
     */
    @Test
    public void testServerAddsAnswers() throws Exception {
        System.out.println("serverAddsAnswers");
        String question = "";
        String[] answers = null;
        QuizServerData instance = new QuizServerData();
        instance.serverAddsAnswers(question, answers);
    }
    
}
