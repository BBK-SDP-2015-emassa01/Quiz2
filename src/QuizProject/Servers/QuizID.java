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
public class QuizID implements QuizIDInterf, Serializable {
    
    private static int QuizIDNumber;
    
    public QuizID(){
        QuizIDNumber++;
    }
    
    @Override
    public int getQuizIDNumber(){
        return QuizID.QuizIDNumber;
    }
    
    //for testing only.
    public void setQuizIDNumber(int number){
         QuizID.QuizIDNumber = number;
    }
    
    
}
