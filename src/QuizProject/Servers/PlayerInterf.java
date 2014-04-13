/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;


/**
 * Player Object holds players name, score.
 * @author Esha
 */
public interface PlayerInterf {

    /**
     * getter for player name
     * @return player name
     */
    String getPlayerName();

    /**
     * getter for player score
     * @return player score
     */
    int getPlayerScore();

    /**
     * setter for player name
     * @param name
     */
    void setPlayerName(String name);

    /**
     * setter for player score
     * @param score
     */
    void setPlayerScore(int score);
    
        /**
     * Checks the input is not null and prints a NullPointer message to screen if it is.
     * @param obj
     */
    void checkObjectIsNotNull(Object obj);
    
}
