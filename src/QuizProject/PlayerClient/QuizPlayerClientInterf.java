/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.PlayerClient;

import java.rmi.RemoteException;

/**
 * A class for the player Client
 * @author Esha
 */
public interface QuizPlayerClientInterf {

    /**
     * Gets the highestScore int for a Quiz using the QuizID.
     * @param quizID
     * @return highest score for that Quiz
     * @throws RemoteException
     */
    int getHighestScoreForPlayer(int quizID) throws RemoteException;

    /**
     * Until the user terminates, the menu() will keep presenting after each action.
     * @throws RemoteException
     */
    void keepLooping() throws RemoteException;

    /**
     * launches the main from outside of a static context.
     * @throws RemoteException
     */
    void launch() throws RemoteException;

    /**
     * Presents options for what the player can do.
     * @return the choice that the player selects
     * @throws RemoteException
     */
    int menu() throws RemoteException;

    /**
     * Allows the user to play the Quiz.
     * Presents the Questions and reads the user Answer, and accumulates the score if correct
     * for a given Quiz ID
     * @param selectedQuizID
     * @throws RemoteException
     */
    void playSelectedQuiz(int selectedQuizID) throws RemoteException;
    
    /**
     * Prints to screen the current set of Quizzes Names and IDs in the set. 
     * @throws RemoteException
     */
    void printOutQuizList() throws RemoteException;

    /**
     * Sets the running boolean value to false.
     * The menu will no longer be presented and the system exits.
     */
    void terminateQuiz();
    
}
