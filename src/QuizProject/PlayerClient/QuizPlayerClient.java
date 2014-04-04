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

    private GetInput input = new GetInput();
    private String playerString;

    private Player player;

    public QuizPlayerClient() throws NotBoundException, MalformedURLException, RemoteException {
        serverQuiz = new QuizServer();
        service = this.service = Naming.lookup("//127.0.0.1:1099/quiz");
//        if (System.getSecurityManager() == null) {
//        System.setSecurityManager(new RMISecurityManager());
//        }
        System.out.println("\t\t\t\tWELCOME! PLAY A QUIZ HERE!");
        System.out.println("ENTER YOUR PLAYER NAME: ");
        playerString = input.getStringInput();
        player = new Player();
        player.setPlayerName(playerString);
    }

    @Override
    public void launch() throws RemoteException {

        try {
            serverQuiz = (QuizServerInterf) service;

            keepLooping();

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void keepLooping() throws RemoteException {
        if (running) {
            int selectedQuizID = menu();

            System.out.println("PRESS 1 TO PLAY THIS QUIZ ");
            System.out.println("PRESS 2 TO CLOSE THIS QUIZ AND REVEAL WINNER ");

            int response = input.getIntInput();

            if (response == 1) {
                playSelectedQuiz(selectedQuizID);
            } else if (response == 2) {

                System.out.println(serverQuiz.getWinnerForQuiz(selectedQuizID));
                serverQuiz.serialize();
                System.out.println("FINISHED SERIALIZATION.");
            }
            keepLooping();
        } else {
            System.exit(0);
        }
    }

    @Override
    public void terminateQuiz() {
        running = false;
        //serialize?
        System.exit(0);

    }

    public static void main(String args[]) {
        try {
            QuizPlayerClient playerClient = new QuizPlayerClient();
            playerClient.launch();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {

        }
    }

    @Override
    public int menu() throws RemoteException {

        printOutQuizList();
        System.out.println("\n\nENTER QUIZ ID TO ACCESS: ('END' TO EXIT)");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.equalsIgnoreCase("end")) {
            running = false;
            terminateQuiz();
        }
        int quizID = Integer.parseInt(input);

        return quizID;
    }

    @Override
    public int selectQuizToPlay() {
        //return quiz ID that the player wants to play
        System.out.println("ENTER ID OF QUIZ TO ACCESS.");
        Scanner input = new Scanner(System.in);
        int result = Integer.parseInt(input.nextLine().trim());
        return result;
    }

    @Override
    public void printOutQuizList() throws RemoteException {
        try {
            Object[] quizArray = serverQuiz.getCurrentQuizList();
            if (serverQuiz.getCurrentQuizList() == null) {
                System.out.println("NO SAVED QUIZZES.");
            }
            System.out.println("\n\nQUIZZES:");
            for (Object a : quizArray) {
                Quiz b = (Quiz) a;
                System.out.println("ID: " + b.getQuizID() + "\t|| NAME: " + b.getQuizName());
            }
            //System.out.println("THE COMPLETE LIST:");
        } catch (NullPointerException e) {
            System.out.println("ID DOES NOT EXIST");
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
        int highestScoreForQuiz=0;

        for (int i = 0; i < questions.size(); i++) {

            Map<String, String[]> thisSet = serverQuiz.getQuestionsAndAnswers();
            highestScoreForQuiz = serverQuiz.getHighestScoreForQuiz(i);

            String[] QAs = thisSet.get(questions.get(i));
            System.out.println("Question: " + QAs[0] + "\n");
            System.out.println("Option 1: " + QAs[1]);
            System.out.println("Option 2: " + QAs[2]);
            System.out.println("Option 3: " + QAs[3]);
            System.out.println("Option 4: " + QAs[4]);
            String answer = input.getStringInput().trim();
            
            try{
            int option = Integer.parseInt(answer);
            if((option ==1)|(option ==2)|(option ==3)|(option ==4)){
                if (answer.equals(QAs[5])) {
                    tempScore++;
                    System.out.println("CORRECT! 1 POINT AWARDED!\n");
                } else {
                    System.out.println("WRONG!\n");
                }
            }
            } catch(NumberFormatException e){
                    e.printStackTrace();
                    }
        }
        if (serverQuiz.getHighestScoreForQuiz(selectedQuizID) < tempScore) {
                serverQuiz.setHighestScoreForQuiz(selectedQuizID, tempScore);
        }
        System.out.println("QUIZ COMPLETE. YOUR SCORE: " + tempScore);
        if (tempScore > highestScoreForQuiz) {
            Set<Quiz> theQuizSet = serverQuiz.getQuizzes();
            for (Quiz a : theQuizSet) {
                if (a.getQuizID() == selectedQuizID) {
                    a.setHighestScore(tempScore);
                }
            }
            System.out.println("\n\nYOU HAVE THE HIGHEST SCORE SO FAR!");
            player.setPlayerScore(tempScore);
            serverQuiz.setHighestScorePlayerIDMap(selectedQuizID, player);
        }
    }
}
