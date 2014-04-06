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
public class QuizID implements QuizIDInterf {
    
    private static int QuizIDNumber = 0;
    
    public QuizID(){
        QuizIDNumber++;
    }
    
    @Override
    public int getQuizIDNumber(){
        return this.QuizIDNumber;
    }
    
}
