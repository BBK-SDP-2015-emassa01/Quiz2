/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.PlayerClient;

import java.io.Serializable;

/**
 * Player Object holds players name, score.
 * @author Esha
 */
public interface PlayerInterf extends Serializable {

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
    
}
