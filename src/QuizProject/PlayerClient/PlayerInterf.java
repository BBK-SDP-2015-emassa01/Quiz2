/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.PlayerClient;

import java.io.Serializable;

/**
 *
 * @author Esha
 */
public interface PlayerInterf extends Serializable {

    String getPlayerName();

    int getPlayerScore();

    void setPlayerName(String name);

    void setPlayerScore(int score);   
}
