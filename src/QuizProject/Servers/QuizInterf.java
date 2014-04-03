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
public interface QuizInterf extends Serializable {

    int getHighestScore();

    String[] getQuesAns();

    int getQuizID();

    String getQuizName();

    void setHighestScore(int score);

    void setQuesAns(String[] QA);

    void setQuizID(int idOfQuiz);

    void setQuizName(String nameOfQuiz);
    
}
