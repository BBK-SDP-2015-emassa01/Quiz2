/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.PlayerClient;

import QuizProject.Servers.GetInput;
import QuizProject.Servers.Player;
import QuizProject.Servers.Quiz;
import QuizProject.Servers.QuizServer;
import QuizProject.Servers.QuizServerInterf;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Esha
 */
public class QuizPlayerClient implements QuizPlayerClientInterf {

    private QuizServerInterf serverQuiz;
    public Remote service;
    boolean running = true;

    private GetInput getInput = new GetInput();
    private String playerString;

    private final Player player = new Player();

    public QuizPlayerClient() throws NotBoundException, MalformedURLException, RemoteException, IllegalArgumentException {
        serverQuiz = new QuizServer();
        service = this.service = Naming.lookup("//127.0.0.1:1099/quiz");
        boolean validInput = true;

//        if (System.getSecurityManager() == null) {
//        System.setSecurityManager(new RMISecurityManager());
//        }
        System.out.println("\t\t\t\tWELCOME! PLAY A QUIZ HERE!");
        System.out.println("ENTER YOUR PLAYER NAME: ");
        Scanner input = new Scanner(System.in);
        playerString = input.nextLine().trim();

        while (playerString.equals("")) {
            validInput = false;
            System.out.println("INVALID INPUT DETECTED. TRY AGAIN.");
            input = new Scanner(System.in);
            playerString = input.nextLine().trim();
        }
        if (validInput) {
            player.setPlayerName(playerString);
        }
    }

    @Override
    public void launch() throws RemoteException {

        try {
            serverQuiz = (QuizServerInterf) service;

            keepLooping();

        } catch (RemoteException e) {
            e.getMessage();
        }
    }

    @Override
    public synchronized void keepLooping() throws RemoteException, IllegalArgumentException {
        if (running) {
            int selectedQuizID = menu();

            System.out.println("PRESS 1 TO PLAY THIS QUIZ ");
            System.out.println("PRESS 2 TO CLOSE THIS QUIZ AND REVEAL WINNER ");

            Scanner input = new Scanner(System.in);
            String tempResp = input.nextLine().trim();
            int resp = Integer.parseInt(tempResp);

            if (resp == 1) {
                playSelectedQuiz(selectedQuizID);
            } else if (resp == 2) {
                System.out.println(selectedQuizID);
                System.out.println(serverQuiz.getWinnerForQuiz(selectedQuizID));
                serverQuiz.serialize(
                        serverQuiz.getQuizzes(),
                        serverQuiz.getQuizMap(),
                        serverQuiz.getQuestionsAndAnswers(),
                        serverQuiz.getHighestScorePlayerIDMap(),
                        serverQuiz.getFileName()
                );
                System.out.println("FINISHED SERIALIZATION.");
                keepLooping();
            } else {
                System.out.println("INVALID RESPONSE. TRY AGAIN.");
                keepLooping();
            }
        }
        if (!running) {
            serverQuiz.serialize(
                    serverQuiz.getQuizzes(),
                    serverQuiz.getQuizMap(),
                    serverQuiz.getQuestionsAndAnswers(),
                    serverQuiz.getHighestScorePlayerIDMap(),
                    serverQuiz.getFileName()
            );
            System.exit(0);
        }
    }

    @Override
    public void terminateQuiz() {
        running = false;
        try {
            serverQuiz.serialize(
                    serverQuiz.getQuizzes(),
                    serverQuiz.getQuizMap(),
                    serverQuiz.getQuestionsAndAnswers(),
                    serverQuiz.getHighestScorePlayerIDMap(),
                    serverQuiz.getFileName()
            );
        } catch (RemoteException ex) {
            System.out.println("COULD NOT SERIALIZE BEFORE CLOSING.");
            ex.printStackTrace();
        }
        System.exit(0);

    }

    public static void main(String args[]) {
        try {
            QuizPlayerClient playerClient = new QuizPlayerClient();
            playerClient.launch();
        } catch (IllegalArgumentException | NotBoundException | MalformedURLException | RemoteException ex) {

        }
    }

    @Override
    public int menu() throws RemoteException {

        printOutQuizList();
        System.out.println("\n\nENTER QUIZ ID TO ACCESS: ('END' TO EXIT)");

        Scanner tempInput = new Scanner(System.in);
        String input = tempInput.nextLine().trim();

        if (input.equalsIgnoreCase("end")) {
            running = false;
            terminateQuiz();
        } else if (input.equals("")) {
            System.out.println("INVALID INPUT. TRY AGAIN.");
            keepLooping();
        } else if (!serverQuiz.getQuizMap().containsKey(Integer.parseInt(input))) {
            System.out.println("ID DOES NOT EXIST.");
            keepLooping();
        } else if (serverQuiz.getQuizMap().containsKey(Integer.parseInt(input))) {
            System.out.println("QUIZ FOUND.");
            int quizID = Integer.parseInt(input);
            return quizID;
        }

        int quizID = Integer.parseInt(input);
        return quizID;
    }

    @Override
    public int selectQuizToPlay() {
        //return quiz ID that the player wants to play
        System.out.println("ENTER ID OF QUIZ TO ACCESS.");
        int result = getInput.getIntInput();
        return result;
    }

    @Override
    public void printOutQuizList() throws RemoteException {
        Object[] quizArray = null;
        try {
            quizArray = serverQuiz.getCurrentQuizList();
//            if (serverQuiz.getCurrentQuizList() == null) {
//                System.out.println("NO SAVED QUIZZES.");
//            }
            System.out.println("\n\nQUIZZES:");
            for (Object a : quizArray) {
                Quiz b = (Quiz) a;
                System.out.println("ID: " + b.getQuizID() + "\t|| NAME: " + b.getQuizName());
            }
            //System.out.println("THE COMPLETE LIST:");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("NO SAVED QUIZZES");
        }
    }

    @Override
    public int getHighestScoreForPlayer(int quizID) throws RemoteException {
        return serverQuiz.getHighestScoreForQuiz(quizID);
    }

    @Override
    public void playSelectedQuiz(int selectedQuizID) throws RemoteException {

        Map<Integer, ArrayList<String>> quizMap = serverQuiz.getQuizMap();
        ArrayList<String> questions = quizMap.get(selectedQuizID);
        int tempScore = 0;

        for (int i = 0; i < questions.size(); i++) {

            Map<String, String[]> thisSet = serverQuiz.getQuestionsAndAnswers();

            String[] QAs = thisSet.get(questions.get(i));
            System.out.println("Question: " + QAs[0] + "\n");
            System.out.println("Option 1: " + QAs[1]);
            System.out.println("Option 2: " + QAs[2]);
            System.out.println("Option 3: " + QAs[3]);
            System.out.println("Option 4: " + QAs[4]);
            String answer = getInput.getStringInput().trim();

            int option = Integer.parseInt(answer);
            if ((option == 1) | (option == 2) | (option == 3) | (option == 4)) {
                if (answer.equals(QAs[5])) {
                    tempScore++;
                    System.out.println("CORRECT! 1 POINT AWARDED!\n");
                } else {
                    System.out.println("WRONG!\n");
                }
            } else {
                System.out.println("INVALID RESPONSE COUNTS AS AN INCORRECT ANSWER!");
            }

        }
        System.out.println("QUIZ COMPLETE. YOUR SCORE: " + tempScore);

        System.out.println("CURRENT HIGHEST SCORE FOR THIS QUIZ = " + serverQuiz.getHighestScoreForQuiz(selectedQuizID));

        if (tempScore > serverQuiz.getHighestScoreForQuiz(selectedQuizID)) {
            System.out.println("\n\nYOU HAVE THE HIGHEST SCORE SO FAR!");
            serverQuiz.setHighestScoreForQuiz(selectedQuizID, tempScore);
            player.setPlayerScore(tempScore);
            serverQuiz.setHighestScorePlayerIDMap(selectedQuizID, player);
        }

//        if (serverQuiz.getHighestScoreForQuiz(selectedQuizID) < tempScore) {
//            serverQuiz.setHighestScoreForQuiz(selectedQuizID, tempScore);
//            player.setPlayerScore(tempScore);
//            serverQuiz.setHighestScorePlayerIDMap(selectedQuizID, player);
//        }
        keepLooping();
    }
}
