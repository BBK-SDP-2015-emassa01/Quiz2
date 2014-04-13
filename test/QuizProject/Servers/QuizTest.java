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
public class QuizTest {
    
    public QuizTest() {
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
     * Test of setQuizName method, of class Quiz.
     */
    @Test
    public void testSetQuizName() {
        System.out.println("setQuizName");
        String nameOfQuiz = "Esha's Quiz";
        Quiz instance = new Quiz();
        instance.setQuizName(nameOfQuiz);
        assertEquals(nameOfQuiz, instance.getQuizName());
    }

    /**
     * Test of getQuizName method, of class Quiz.
     */
    @Test
    public void testGetQuizName() {
        System.out.println("getQuizName");
        Quiz instance = new Quiz();
        String expResult = "Esha's Quiz";
        instance.setQuizName(expResult);
        String result = instance.getQuizName();
        assertEquals(expResult, result);
    }
    /**
     * Test of checkObjectIsNotNull method, of class Quiz.
     */
    @Test
    public void testCheckObjectIsNotNull() {
        System.out.println("checkObjectIsNotNull");
        Object obj = 2;
        Quiz instance = new Quiz();
        instance.checkObjectIsNotNull(obj);
    }

    /**
     * Test of setQuizID method, of class Quiz.
     */
    @Test
    public void testSetQuizID() {
        System.out.println("setQuizID");
        int idOfQuiz = 3;
        Quiz instance = new Quiz();
        instance.setQuizID(idOfQuiz);
        System.out.println(instance.getQuizID());
    }

    /**
     * Test of getQuizID method, of class Quiz.
     */
    @Test
    public void testGetQuizID() {
        System.out.println("getQuizID");
        Quiz instance = new Quiz();
        int expResult = 3;
        instance.setQuizID(expResult);
        int result = instance.getQuizID();
        assertEquals(expResult, result);

    }

    /**
     * Test of setHighestScore method, of class Quiz.
     */
    @Test
    public void testSetHighestScore() {
        System.out.println("setHighestScore");
        int score = 5;
        Quiz instance = new Quiz();
        instance.setHighestScore(score);
        System.out.println(instance.getHighestScore());

    }

    /**
     * Test of getHighestScore method, of class Quiz.
     */
    @Test
    public void testGetHighestScore() {
        System.out.println("getHighestScore");
        Quiz instance = new Quiz();
        int expResult = 5;
        instance.setHighestScore(expResult);
        int result = instance.getHighestScore();
        assertEquals(expResult, result);

    }

    /**
     * Test of getQuesAns method, of class Quiz.
     */
    @Test
    public void testGetQuesAns() {
        System.out.println("getQuesAns");
        Quiz instance = new Quiz();
        String[] expResult = {"1", "2","3"};
        instance.setQuesAns(expResult);
        String[] result = instance.getQuesAns();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of setQuesAns method, of class Quiz.
     */
    @Test
    public void testSetQuesAns() {
        System.out.println("setQuesAns");
        String[] QA = {"1", "2","3"};
        Quiz instance = new Quiz();
        instance.setQuesAns(QA);
        System.out.println(instance.getQuesAns());
    }
    
}
