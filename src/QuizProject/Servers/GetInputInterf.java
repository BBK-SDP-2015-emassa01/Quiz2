/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

import java.io.Serializable;

/**
 * StreamLines the process of Scanner in (and parsing to integer for int inputs).
 * @author Esha
 */
public interface GetInputInterf  {

    /**
     * Parses a String from keyboard to an int input.
     * @return int
     */
    int getIntInput();

    /**
     *
     * @returns String representation of keyboard input.
     */
    String getStringInput();
      
}
