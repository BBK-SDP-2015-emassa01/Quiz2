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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of setPlayerName method, of class Player.
     */
    @Test
    public void testSetPlayerName() {
        System.out.println("setPlayerName");
        String name = "Esha";
        Player instance = new Player();
        instance.setPlayerName(name);
        assertEquals(name, instance.getPlayerName());
        
    }

    /**
     * Test of setPlayerScore method, of class Player.
     */
    @Test
    public void testSetPlayerScore() {
        System.out.println("setPlayerScore");
        int expResult = 3;
        Player instance = new Player();
        instance.setPlayerScore(expResult);
        int result = instance.getPlayerScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerName method, of class Player.
     */
    @Test
    public void testGetPlayerName() {
        System.out.println("getPlayerName");
        Player instance = new Player();
        instance.setPlayerName("Esha");
        String expResult = "Esha";
        String result = instance.getPlayerName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPlayerScore method, of class Player.
     */
    @Test
    public void testGetPlayerScore() {
        System.out.println("getPlayerScore");
        Player instance = new Player();
        int expResult = 1;
        instance.setPlayerScore(1);
        int result = instance.getPlayerScore();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkObjectIsNotNull method, of class Player.
     */
    @Test
    public void testCheckObjectIsNotNull() {
        System.out.println("checkObjectIsNotNull");
        Object obj = 2; //change to null to test null condition
        Player instance = new Player();
        instance.checkObjectIsNotNull(obj);
        //message to screen different message when 'obj' is null vs not null.
    }
    
}
