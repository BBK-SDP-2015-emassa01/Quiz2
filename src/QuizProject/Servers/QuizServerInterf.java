/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.Servers;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * This is an interface for the QuizServer class.
 * QuizServer is the Orchestrator of the Quiz (on the Server side).
 * @author Esha
 */
public interface QuizServerInterf extends Remote {
    
    /**
     * Adds a new quiz to the quizMap and quizSet.
     * @param s the String name of the Quiz
     * @return quizID
     * @throws RemoteException
     */
    int addQuiz(String s) throws RemoteException;

    /**
     * Checks that the quizMap holds this Quiz ID and throws a message to the Setup Client if that 
     * id does not exist.
     * @param ID of Quiz
     * @returns String message to screen
     * @throws RemoteException
     */
    String checkIfQuizIDExists(int ID) throws RemoteException;

    /**
     * Reads quizData.txt file (persisted on the server) and constructs a QuizServer object. 
     * @return deserialized QuizServer object
     * @throws RemoteException
     */
    QuizServer deserialize() throws RemoteException;

    /**
     * Prints to screen the current quiz set.
     * @return Object[] array to be cast into Quiz.
     * @throws RemoteException
     */
    Object[] getCurrentQuizList() throws RemoteException;

    /**
     * Searches quizzes to find ID QuizID and retrieves highest score for that Quiz.
     * @param QuizID
     * @return highest score
     * @throws RemoteException
     */
    int getHighestScoreForQuiz(int QuizID) throws RemoteException;

    /**
     * Getter
     * @returns highestScorePlayerIDMap 
     * @throws RemoteException
     */
    Map<Integer, Player> getHighestScorePlayerIDMap() throws RemoteException;

    /**
     * Returns questions for quiz with ID = 'id'.
     * @param id
     * @return Object[] with questions
     * @throws RemoteException
     */
    Object[] getListOfQuestionsInQuiz(int id) throws RemoteException;

    /**
     * getter for Questions and Answers
     * @returns Hash Map with QuestionsAndAnswers in String array
     * @throws RemoteException
     */
    Map<String, String[]> getQuestionsAndAnswers() throws RemoteException;

    /**
     * Getter for Quiz ID and Questions
     * @return Hash map of quiz IDs and questions
     * @throws RemoteException
     */
    Map<Integer, ArrayList<String>> getQuizMap() throws RemoteException;

    /**
     * Getter for Quizzes
     * @return set of Quizzes
     * @throws RemoteException
     */
    Set<Quiz> getQuizzes() throws RemoteException;

    /**
     * Gets a random Quiz ID
     * @return int - a random number ID for Quiz
     * @throws RemoteException
     */
    int getRandomID() throws RemoteException;

    /**
     * Prints to screen quiz id, highest scoring player name and player score.
     * @param quizID
     * @return String with the highest scorer details.
     * @throws RemoteException
     */
    String getWinnerForQuiz(int quizID) throws RemoteException;

    /**
     * Serializes the QuizServer Object
     * @throws RemoteException
     */
    void serialize() throws RemoteException;

    /**
     * Puts questions and answers into the questionAnswers Map.
     * @param question for Quiz
     * @param answers - holding Question at position[0], answers at position[1-4] and correct answer at position[5]
     * @throws RemoteException
     */
    void serverAddsAnswers(String question, String[] answers) throws RemoteException;

    /**
     * Adds questions to an arrayList, with a quiz ID and stores in a quizMap on the server
     * prints a message to the screen once added.
     * @param ID of quiz
     * @param newListOfQuestions
     * @throws RemoteException
     */
    void serverAddsSetOfQuestions(int ID, ArrayList<String> newListOfQuestions) throws RemoteException;

    /**
     * Checks if for a given quizID if the score is higher than the highest score for that Quiz. 
     * If the score is higher than the highest score, it replaces the Player name and Score.
     * @param QuizID
     * @param score
     * @throws RemoteException
     */
    void setHighestScoreForQuiz(int QuizID, int score) throws RemoteException;

    /**
     * Sets the highest scoring Player object in a map with the Quiz ID
     * @param id of Quiz
     * @param player Object
     * @throws RemoteException
     */
    void setHighestScorePlayerIDMap(int id, Player player) throws RemoteException;

}
