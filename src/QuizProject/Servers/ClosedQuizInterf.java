/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

/**
 *
 * @author Esha
 */
public interface ClosedQuizInterf {

    /**
     * For closed quiz
     * @return quiz ID
     */
    int getClosedQuizId();

    /**
     *
     * @return highest score
     */
    int getHighestScore();

    /**
     * For closed quiz
     * @return player name
     */
    String getPlayerName();

    /**
     * set quiz id for closed quiz
     * @param id
     */
    void setClosedQuizId(int id);

    /**
     * set highest score for closed quiz
     * @param id
     */
    void setHighestScore(int id);

    /**
     * set player name for closed quiz
     * @param name
     */
    void setPlayerName(String name);
    
}
