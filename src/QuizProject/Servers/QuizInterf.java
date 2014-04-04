/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author Esha
 */
public interface QuizInterf extends Serializable {

    /**
     * getter
     * @return highest score for quiz so far.
     */
    int getHighestScore();

    /**
     * getter
     * @return String[] holding Question at position[0], multiple choice answers at position[1-4] and correct answer at position[5]. 
     */
    String[] getQuesAns();
    
    /**
     * Checks the input is not null and prints a NullPointer message to screen if it is.
     * @param obj
     * @throws java.rmi.RemoteException
     */
    void checkObjectIsNotNull(Object obj)throws RemoteException;

    /**
     * getter
     * @return QuizID
     */
    int getQuizID();

    /** getter 
     *
     * @return QuizName
     */
    String getQuizName();

    /**
     * Sets the highest score for this Quiz
     * @param score
     */
    void setHighestScore(int score);

    /**
     * Sets the Questions and Answers array for the Quiz
     * @param QA
     */
    void setQuesAns(String[] QA);

    /**
     * Sets the QuizID
     * @param idOfQuiz
     */
    void setQuizID(int idOfQuiz);

    /**
     * Sets the name of the QuizName
     * @param nameOfQuiz
     */
    void setQuizName(String nameOfQuiz);
    
}
