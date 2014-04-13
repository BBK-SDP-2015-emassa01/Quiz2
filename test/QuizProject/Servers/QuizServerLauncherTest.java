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
    
}
