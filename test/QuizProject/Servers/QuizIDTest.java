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
public class QuizIDTest {
    
    public QuizIDTest() {
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
     * Test of getQuizIDNumber method, of class QuizID.
     */
    @Test
    public void testGetQuizIDNumber() {
        System.out.println("getQuizIDNumber");
        QuizID instance = new QuizID();
        int expResult = 5;
        instance.setQuizIDNumber(5);
        int result = instance.getQuizIDNumber();
        assertEquals(expResult, result);
        
    }
    
}
