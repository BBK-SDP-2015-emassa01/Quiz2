/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

import java.io.Serializable;

/**
 * Player Object holds players name, score.
 * @author Esha
 */
public interface PlayerInterf {

    /**
     * getter 
     * @return player name
     */
    String getPlayerName();

    /**
     * getter
     * @return player score
     */
    int getPlayerScore();

    /**
     * setter
     * @param name
     */
    void setPlayerName(String name);

    /**
     * setter
     * @param score
     */
    void setPlayerScore(int score);
    
        /**
     * Checks the input is not null and prints a NullPointer message to screen if it is.
     * @param obj
     */
    void checkObjectIsNotNull(Object obj);
    
}
