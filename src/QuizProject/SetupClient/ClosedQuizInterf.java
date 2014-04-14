/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.SetupClient;

import QuizProject.Servers.*;

/**
 *
 * @author Esha
 */
public interface ClosedQuizInterf {

    /**
     * Get Id for closed quiz
     * @return quiz ID
     */
    int getClosedQuizId();

    /**
     * Get the highest score for closed quiz
     * @return highest score
     */
    int getHighestScore();

    /**
     * Get player name for closed quiz
     * @return player name
     */
    String getPlayerName();

    /**
     * Set quiz id for closed quiz
     * @param id
     */
    void setClosedQuizId(int id);

    /**
     * Set highest score for closed quiz
     * @param id
     */
    void setHighestScore(int id);

    /**
     * Set player name for closed quiz
     * @param name
     */
    void setPlayerName(String name);
    
}
