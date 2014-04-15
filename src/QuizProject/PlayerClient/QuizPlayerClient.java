/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.PlayerClient;

import QuizProject.Servers.GetInput;
import QuizProject.Servers.GetInputInterf;
import QuizProject.Servers.Player;
import QuizProject.Servers.Quiz;
import QuizProject.Servers.QuizServerData;
import QuizProject.Servers.QuizServerInterf;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Esha
 */
public class QuizPlayerClient implements QuizPlayerClientInterface, Serializable {

    private QuizServerInterf serverQuiz;
    public Remote service;
    boolean running = true;

    private final GetInputInterf getInput = new GetInput();
    private String playerString;

    private final Player player = new Player();

    public QuizPlayerClient() throws NotBoundException, MalformedURLException, RemoteException, IllegalArgumentException {
        serverQuiz = new QuizServerData();
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
            System.out.println("REMOTE EXCEPTION...");
            e.printStackTrace();
        }
    }

    @Override
    public void keepLooping() throws RemoteException, IllegalArgumentException {
        if (running) {
            String tempResp = null;
            int resp = 0;
            int selectedQuizID = 0;
            try {
                selectedQuizID = menu();
                System.out.println("PRESS 1 TO PLAY THIS QUIZ ");
                System.out.println("PRESS 2 TO REVEAL WINNER ");

                Scanner input = new Scanner(System.in);
                tempResp = input.nextLine().trim();
                resp = Integer.parseInt(tempResp);
            } catch (IllegalArgumentException | NullPointerException | InputMismatchException e) {
                e.printStackTrace();
            }
            try {
                if (resp == 1) {
                    playSelectedQuiz(selectedQuizID);
                } else if (resp == 2) {
                    System.out.println(serverQuiz.getWinnerForQuiz(selectedQuizID));
                    serverQuiz.serialize(
                            serverQuiz.getQuizzes(),
                            serverQuiz.getQuizMap(),
                            serverQuiz.getQuestionsAndAnswers(),
                            serverQuiz.getHighestScorePlayerIDMap(),
                            serverQuiz.getFileName(),
                            serverQuiz.getQuizIDValue(),
                            serverQuiz.getClosedQuizList()
                    );
                    System.out.println("SAVED.");
                    keepLooping();
                } else {
                    System.out.println("SOMETHING WENT WRONG. LET'S TRY AGAIN.");
                    keepLooping();
                }
            } catch (IllegalArgumentException | NullPointerException | InputMismatchException e) {
                System.out.println("TRY AGAIN.");
                e.printStackTrace();
            } catch (IOException ex) {
                System.out.println("COULD NOT LOCATE FILE.");
                ex.printStackTrace();
            }
        }
        if (!running) {
            try {
                serverQuiz.serialize(
                        serverQuiz.getQuizzes(),
                        serverQuiz.getQuizMap(),
                        serverQuiz.getQuestionsAndAnswers(),
                        serverQuiz.getHighestScorePlayerIDMap(),
                        serverQuiz.getFileName(),
                        serverQuiz.getQuizIDValue(),
                        serverQuiz.getClosedQuizList()
                );
            } catch (IOException ex) {
                System.out.println("COULD NOT LOCATE FILE.");
                ex.printStackTrace();
            }
            System.exit(0);
        }
    }

    @Override
    public synchronized void terminateQuiz() {
        running = false;
        System.out.println("THANKS FOR PLAYING! HOPE YOU HAD A GREAT TIME :-)");
        try {
            serverQuiz.serialize(
                    serverQuiz.getQuizzes(),
                    serverQuiz.getQuizMap(),
                    serverQuiz.getQuestionsAndAnswers(),
                    serverQuiz.getHighestScorePlayerIDMap(),
                    serverQuiz.getFileName(),
                    serverQuiz.getQuizIDValue(),
                    serverQuiz.getClosedQuizList()
            );
        } catch (RemoteException ex) {
            System.out.println("COULD NOT SERIALIZE BEFORE CLOSING.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("COULD NOT LOCATE FILE.");
            ex.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String args[]) {
        try {
            QuizPlayerClient playerClient = new QuizPlayerClient();
            playerClient.launch();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int menu() throws RemoteException {

        printOutQuizList();
        System.out.println("\n\nENTER QUIZ ID TO ACCESS: ('END' TO EXIT)");

        Scanner tempInput = new Scanner(System.in);
        String input = tempInput.nextLine().trim();

        int quizID = 0;

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
            quizID = Integer.parseInt(input);
            return quizID;
        }

        try {
            quizID = Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException | InputMismatchException e) {
            e.printStackTrace();
        }
        return quizID;
    }

    @Override
    public synchronized void printOutQuizList() throws RemoteException {
        Object[] quizArray;
        try {
            quizArray = serverQuiz.getCurrentQuizList();

            System.out.println("\n\nQUIZZES:");
            for (Object a : quizArray) {
                Quiz b = (Quiz) a;
                System.out.println("ID: " + b.getQuizID() + "\t|| QUIZ NAME: " + b.getQuizName());
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("\n\nNO SAVED QUIZZES YET!");
        }
    }

    @Override
    public synchronized int getHighestScoreForPlayer(int quizID) throws RemoteException {
        return serverQuiz.getHighestScoreForQuiz(quizID);
    }

    @Override
    public synchronized void playSelectedQuiz(int selectedQuizID) throws RemoteException {
        Map<Integer, ArrayList<String>> quizMap = null;
        ArrayList<String> questions = null;
        int tempScore = 0;

        try {
            quizMap = serverQuiz.getQuizMap();
            questions = quizMap.get(selectedQuizID);

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
        } catch (NumberFormatException | NullPointerException | InputMismatchException e) {
            e.printStackTrace();
        }

        System.out.println("QUIZ COMPLETE. YOUR SCORE: " + tempScore);

        System.out.println("CURRENT HIGHEST SCORE FOR THIS QUIZ = " + serverQuiz.getHighestScoreForQuiz(selectedQuizID));

        if (tempScore >= serverQuiz.getHighestScoreForQuiz(selectedQuizID)) {
            System.out.println("\n\nYOU HAVE THE HIGHEST SCORE SO FAR!");
            serverQuiz.setHighestScoreForQuiz(selectedQuizID, tempScore);
            player.setPlayerScore(tempScore);
            serverQuiz.setHighestScorePlayerIDMap(selectedQuizID, player);
        }

        keepLooping();
    }
}