/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.PlayerClient;

import QuizProject.Servers.*;
import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author Esha
 */
public interface QuizInterf extends Serializable {

    /**
     * getter for highest score of a quiz
     * @return highest score for quiz so far.
     */
    int getHighestScore();

    /**
     * getter for the Question and Answers array for a Quiz Question
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
     * getter for Quiz ID
     * @return QuizID
     */
    int getQuizID();

    /** getter for Quiz name
     *
     * @return QuizName
     */
    String getQuizName();

    /**
     * Sets the highest score for the Quiz
     * @param score
     */
    void setHighestScore(int score);

    /**
     * Sets the Questions and Answers array for the Quiz
     * @param QA is an array of length 6. The pos[0] is the Question, 
     * pos 1-4 are the answers (multiple choice) and pos [5] is the correct answer. 
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
