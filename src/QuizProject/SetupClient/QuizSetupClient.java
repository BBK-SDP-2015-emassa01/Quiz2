/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.SetupClient;

import QuizProject.Servers.GetInput;
import QuizProject.Servers.Quiz;
import QuizProject.Servers.QuizServer;
import QuizProject.Servers.QuizServerInterf;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Esha
 */
public class QuizSetupClient implements QuizSetupClientInterf{

    QuizServerInterf serverQuiz;
    boolean running = true;

    public Remote service;
    private int quizID;

    public QuizSetupClient() throws NotBoundException, MalformedURLException, RemoteException {
        serverQuiz = new QuizServer();
        Remote service = this.service = Naming.lookup("//127.0.0.1:1099/quiz");
//        if (System.getSecurityManager() == null) {
//        System.setSecurityManager(new RMISecurityManager());
//        }
//        serverQuiz.deserialize();
        System.out.println("\t\t\t\tWELCOME TO THE QUIZ SETUP TOOL!");
    }

    @Override
    public void launch() throws RemoteException {

        try {
            serverQuiz = (QuizServerInterf) service;

            keepLooping();

        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            QuizSetupClientInterf quizClient = new QuizSetupClient();
            quizClient.launch();
        } catch (Exception ex) {

        }
    }

    @Override
    public int menu() {
        System.out.println("-> PRESS 1 TO ADD QUIZ.");
        System.out.println("-> Press 2 FOR QUIZ LIST.");
        System.out.println("-> Press 3 TO LIST QUESTIONS OF A SPECIFIED QUIZ");
        System.out.println("-> Press 4 TO CLOSE A QUIZ - WINNER REVEALED TO SERVER AND PLAYER.");
        System.out.println("-> Press 5 TO SAVE AND EXIT.");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim();

        int switchValue = Integer.parseInt(input);
        return switchValue;
    }
    
    public boolean checkForInput(String input){
        if (input.equals("")){
            return false;
        } else return true;
    }
    
    public boolean checkInputValid(int input)throws RemoteException{
        if ((input==1)|(input==2)|(input==3)|(input==4)|(input==5)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void keepLooping() throws RemoteException {
        if (running) {
            int menuChoice = menu();
            if (checkInputValid(menuChoice)){
                if (checkForInput(menuChoice+"")){
            dealWithSwitchRequest(menuChoice);
            keepLooping();
                }
            } else {
                throw new IllegalArgumentException("NOT VALID CHOICE.");
            }
        } else {
//            serverQuiz.writeQuizServer();
            System.exit(0);
        }
    }

    @Override
    public ArrayList<String> clientAddsSetOfQuestions(int id) throws RemoteException {
        ArrayList<String> newListOfQuestions = new ArrayList<>();
        String question = null;
        String[] answers = null;
        quizID = id;

        boolean collectingQ = true;
        while (collectingQ) {
            System.out.println("ENTER A QUESTION: (END TO QUIT)");
            GetInput input = new GetInput();
            question = input.getStringInput();

            if (question.equalsIgnoreCase("end")) {
                System.out.println("SAVED SUCCESSFULLY.");
                serverQuiz.serverAddsSetOfQuestions(id, newListOfQuestions);
                collectingQ = false;
                System.out.println("SETUP COMPLETE.");
            } else {
                newListOfQuestions.add(question);
                answers = clientAddsAnswers(question);
                serverQuiz.serverAddsAnswers(question, answers);
                serverQuiz.getQuestionsAndAnswers().put(question, answers);

            }
        }

        Object[] list = newListOfQuestions.toArray();
        for (Object a : list) {
            System.out.println("ADDED: " + a.toString());
        }
        return newListOfQuestions;
    }

    @Override
    public String[] clientAddsAnswers(String question) {
        String[] answers = new String[6];
        System.out.println("ENTER YOUR MULTIPLE ANSWER CHOICES");

        GetInput input = new GetInput();

        answers[0] = question;
        System.out.println("CHOICE 1:");

        String ans1 = input.getStringInput();
        answers[1] = ans1;

        System.out.println("CHOICE 2:");
        String ans2 = input.getStringInput();
        answers[2] = ans2;

        System.out.println("CHOICE 3:");
        String ans3 = input.getStringInput();
        answers[3] = ans3;

        System.out.println("CHOICE 4:");
        String ans4 = input.getStringInput();
        answers[4] = ans4;

        System.out.println("ENTER NUMBER OF CORRECT ANSWER (1,2,3 OR 4):");
        String ans5 = input.getStringInput();
        answers[5] = ans5;
        return answers;

    }

    @Override
    public void dealWithSwitchRequest(int choice) throws RemoteException {
        switch (choice) {
            case 1: //deal with add a new Quiz
                System.out.println("ENTER QUIZ NAME:");
                GetInput input = new GetInput();
                String name = input.getStringInput();
                int id = serverQuiz.addQuiz(name);
                System.out.println("QUIZ ID: \"" + id + "\"");
                System.out.println("ENTER THE QUESTIONS. TYPE 'END' TO FINISH. ");
                ArrayList<String> questionSet = clientAddsSetOfQuestions(id);
                serverQuiz.serverAddsSetOfQuestions(id, questionSet);
                break;
            case 2:
                //get current quiz list
                Object[] quizList = serverQuiz.getCurrentQuizList();
                System.out.println("CURRENT QUIZ LIST: ");
                for (Object a : quizList) {
                    Quiz b = (Quiz) a;
                    System.out.println("QUIZ: " + b.getQuizName());
                }
                break;
            case 3:
                System.out.println("ENTER QUIZ ID:");
                GetInput input2 = new GetInput();
                Object[] questions2 = serverQuiz.getListOfQuestionsInQuiz(input2.getIntInput());
                for (Object a : questions2) {
                    System.out.println("Question: " + a.toString());
                }
                break;
            case 4://QUOTE QUIZ ID AND CLOSE. FULL PLAYER DETAILS SAVED ON SERVER.
                System.out.println("ENTER QUIZ ID TO REVEAL WINNER, SAVE AND CLOSE:");
                GetInput in = new GetInput();
                int quizID = in.getIntInput();
                
                //NEED TO CLOSE THIS QUIZ GET IT FROM THE QUIZZES.
                closeDown();
                break;
            case 5: //exit given the Quiz ID
                running = false;
                //NEED TO SERIALIZE DATA HERE.
                System.out.println("SAVED. THANKS FOR PLAYING THE QUIZ GAME!");
                //serverQuiz.writeQuizServer();
                serverQuiz.serialize();
                closeDown();
                System.exit(0);
                break;
            default:
                System.out.println("SOMETHING WENT WRONG. PLEASE TRY AGAIN.");
                break;
        }
    }

    @Override
    public void closeDown() throws RemoteException {
        serverQuiz.serialize();
    }
}
