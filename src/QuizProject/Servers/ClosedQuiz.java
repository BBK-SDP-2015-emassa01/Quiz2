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
public class ClosedQuiz implements ClosedQuizInterf, Serializable   {

    private int highestScore;
    private int closedQuizId;
    private String playerName;
    
    @Override
    public void setHighestScore(int id){
        this.highestScore = id;
    }
    
    @Override
    public void setClosedQuizId(int id){
        this.closedQuizId = id;
    }
    
    @Override
    public void setPlayerName(String name){
        this.playerName = name;
    }
    
    @Override
    public int getHighestScore(){
        return this.highestScore;
    }
    
    @Override
    public int getClosedQuizId(){
        return this.closedQuizId;
    }
    
    @Override
    public String getPlayerName(){
        return this.playerName;
    }
    
}
