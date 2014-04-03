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
public class Player implements PlayerInterf {
    
    String playerName;
    
    int playerScore;
    
    @Override
    public void setPlayerName(String name){
        this.playerName = name;
    }
    
    @Override
    public void setPlayerScore(int score){
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


}
