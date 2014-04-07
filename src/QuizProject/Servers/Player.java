/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

import java.io.Serializable;

/**
 *
 * @author Esha
 */
public class Player implements PlayerInterf, Serializable {
    
    String playerName;
    int playerScore;
    
    @Override
    public void setPlayerName(String name){
        checkObjectIsNotNull(name);
        this.playerName = name;
    }
    
    @Override
    public void setPlayerScore(int score){
        checkObjectIsNotNull(score);
        this.playerScore = score;
    }
    
    @Override
    public String getPlayerName(){
        return this.playerName;
    }
    
    @Override
    public int getPlayerScore(){
        return this.playerScore;
    }
    
    @Override
    public void checkObjectIsNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("THE ARGUMENT WAS NULL. ");
        }
    }


}
