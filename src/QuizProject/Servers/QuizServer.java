/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.Servers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Esha
 */
public class QuizServer extends UnicastRemoteObject implements QuizServerInterf {

    private final Set<Quiz> quizzes = new HashSet<>(); //set of all current quizzes

    private final Map<Integer, ArrayList<String>> quizMap = new HashMap<>();//map Quiz ID to List of Questions

    private final Map<String, String[]> questionAnswers = new HashMap<>(); //holds an array, where pos[0] is the Question and pos[1-4] are the answers, pos[5] is the correct answer.

    private final Map<Integer, Player> highestScorePlayerIDMap = new HashMap<>();// maps Quiz ID the highest scoring Player (holds player name, quiz ID and score for Quizzes)

    private final String fileName = "quizData.txt";

    public QuizServer() throws RemoteException {
        ObjectInputStream ois = null;
        Scanner sc = null;
        if (new File(fileName).exists()) {
        try{
            sc = new Scanner(
            new BufferedInputStream(
            new FileInputStream(fileName)));
        } catch (FileNotFoundException e){
            System.out.println("reading..." + e);
        }
        while (sc.hasNext()){
            System.out.println(sc.next());
        }
        sc.close();
        }
        
        if (new File(fileName).exists()) {
            System.out.println("Found the quizData.txt file.");
            try {
                ois = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(fileName)));
                {
                    QuizServer serverQuiz = (QuizServer) ois.readObject();
                    System.out.println("CREATING THE QUIZ SERVER.");
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("On write error " + ex);
            } finally {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("I/O exception.");
                    ex.printStackTrace();
                }
            }
        } else System.out.println("File not found. Creating quizData.txt");
    }

    @Override
    public void serialize() throws RemoteException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)));

            oos.writeObject(this);
            oos.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public QuizServer deserialize() throws RemoteException {
        QuizServer quizServer = new QuizServer();
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)));

            quizServer = (QuizServer) ois.readObject();

            ois.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return quizServer;
    }

    @Override
    public String getWinnerForQuiz(int quizID) throws RemoteException {
        if (highestScorePlayerIDMap==null){
            throw new NullPointerException("NO SAVED HIGH SCORERS YET FOR THAT ID. ");
        }
        System.out.println(highestScorePlayerIDMap);
        String result = null;

        if (highestScorePlayerIDMap.containsKey(quizID)) {
            Player winner = highestScorePlayerIDMap.get(quizID);
            System.out.println(winner);

            if (winner == null) {
                result = "NO HIGHEST SCORER YET.";
            } else {
                result = "THE WINNER FOR QUIZ " + quizID + " IS " + winner.getPlayerName() + "\nHIGHEST SCORE:" + winner.getPlayerScore();
            }
        } else {
            result = "NO SAVED HIGH SCORERS YET FOR THAT ID.";
        }
        System.out.println(result);
        return result;
    }

    @Override
    public Map<Integer, Player> getHighestScorePlayerIDMap() throws RemoteException {
        return this.highestScorePlayerIDMap;
    }

    @Override
    public void setHighestScorePlayerIDMap(int id, Player player) throws RemoteException {
        this.highestScorePlayerIDMap.put(id, player);
    }

    @Override
    public Set<Quiz> getQuizzes() throws RemoteException {
        return this.quizzes;
    }

    @Override
    public Map<Integer, ArrayList<String>> getQuizMap() throws RemoteException {
        return this.quizMap;
    }

    @Override
    public Map<String, String[]> getQuestionsAndAnswers() throws RemoteException {
        return this.questionAnswers;
    }

    @Override
    public int getRandomID() throws RemoteException {
        Random random = new Random();
        int generatedID = random.nextInt(Integer.MAX_VALUE);
        return generatedID;
    }

    @Override
    public int getHighestScoreForQuiz(int QuizID) throws RemoteException {
        int highestScoreForQuiz = 0;
        if (quizzes.isEmpty()) {
            throw new NullPointerException("NO QUIZZES. ");
        } else {
            for (Quiz a : quizzes) {
                if (a.getQuizID() == QuizID) {
                    highestScoreForQuiz = a.getHighestScore();
                }
            }
        }
        return highestScoreForQuiz;
    }

    @Override
    public void setHighestScoreForQuiz(int QuizID, int score) throws RemoteException {
        if (quizzes.isEmpty()) {
            throw new NullPointerException("NO QUIZZES. ");
        } else {
            for (Quiz a : quizzes) {
                if (a.getQuizID() == QuizID) {
                    if (a.getHighestScore() < score) {
                        a.setHighestScore(score);

                    }
                }
            }
        }
    }

    @Override
    public int addQuiz(String s) throws RemoteException {
        Quiz newQuiz = new Quiz();
        int ID = getRandomID();
        newQuiz.setQuizID(ID);
        newQuiz.setQuizName(s);
        quizzes.add(newQuiz);
        quizMap.put(ID, null);
        System.out.println("ADDED QUIZ: " + s);
        return ID;
    }

    @Override
    public Object[] getCurrentQuizList() throws RemoteException {
        if (quizzes== null) {
            throw new NullPointerException("NO QUIZZES. ");
        }
        Object[] quizArray;
        if (quizzes.isEmpty()) {
            throw new NullPointerException("NO QUIZZES. ");
        } else {
            quizArray = quizzes.toArray();

            for (Object a : quizArray) {
                Quiz b = (Quiz) a;
                System.out.println("QUIZ: " + b.getQuizName() + "  ID: " + b.getQuizID());
            }
        }
        return quizArray;
    }

    @Override
    public Object[] getListOfQuestionsInQuiz(int id) throws RemoteException {
        if (quizMap.containsKey(id)) {
            ArrayList<String> thisListOfQuestions = quizMap.get(id);
            System.out.println(thisListOfQuestions.toString());
            Object[] thisArrayOfQuestions = thisListOfQuestions.toArray();
            return thisArrayOfQuestions;
        } else {
            Object[] message = new String[1];
            message[0] = "ID DOES NOT EXIST";
            return message;
        }
    }

    @Override
    public String checkIfQuizIDExists(int ID) throws RemoteException {
        String result;
        if (quizMap.containsKey(ID)) {
            result = "ADDING TO QUIZ: " + ID;
        } else {
            result = "CREATING QUIZ: " + ID;
        }
        return result;
    }

    @Override
    public synchronized void serverAddsSetOfQuestions(int ID, ArrayList<String> newListOfQuestions) throws RemoteException {
        if (quizMap.containsKey(ID)) {
            quizMap.put(ID, newListOfQuestions);
            System.out.println(quizMap.get(ID).toString());

            System.out.println("ADDED QUESTION TO QUIZ:" + ID);
        } else {
            throw new IllegalArgumentException("NO SUCH QUIZ ID. ");
        }
    }

    @Override
    public void serverAddsAnswers(String question, String[] answers) throws RemoteException {
        checkObjectIsNotNull(answers);
        checkObjectIsNotNull(question);
        questionAnswers.put(question, answers);
        System.out.println("Quiz: " + question + " has been added/amended in the Question and Answers Map. ");
        System.out.println("QA" + questionAnswers.toString());
    }

    @Override
    public void checkObjectIsNotNull(Object obj) throws RemoteException {
        if (obj == null) {
            throw new NullPointerException("THE ARGUMENT WAS NULL. ");
        }
    }
}
