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
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esha
 */
public class QuizSetupClient implements QuizSetupClientInterf {

    QuizServerInterf serverQuiz;
    boolean running = true;

    public Remote service;
    //private int quizID;

    public QuizSetupClient() throws NotBoundException, MalformedURLException, RemoteException {
        serverQuiz = new QuizServer();
        Remote service = this.service = Naming.lookup("//127.0.0.1:1099/quiz");
//        if (System.getSecurityManager() == null) {
//        System.setSecurityManager(new RMISecurityManager());
//        }
        System.out.println("\t\t\t\tWELCOME TO THE QUIZ SETUP TOOL!");
    }

    @Override
    public void launch() throws RemoteException {

        try {
            serverQuiz = (QuizServerInterf) service;

            keepLooping();

        } catch (ClassCastException e) {
            e.getMessage();
        }
    }

    public static void main(String args[]) {
        try {
            QuizSetupClientInterf quizClient = new QuizSetupClient();
            quizClient.launch();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            ex.getMessage();
        }
    }

    @Override
    public int menu() {
        int switchValue = 0;

        try {
            System.out.println("-> PRESS 1 TO ADD QUIZ.");
            System.out.println("-> PRESS 2 FOR QUIZ LIST.");
            System.out.println("-> PRESS 3 TO LIST QUESTIONS OF A SPECIFIED QUIZ");
            System.out.println("-> PRESS 4 TO SAVE.");
            System.out.println("-> PRESS 5 TO REVEAL WINNER.");
            System.out.println("-> PRESS 6 TO CLOSE DOWN.");

            GetInput input = new GetInput();
            switchValue = input.getIntInput();

//            if ((switchValue != 1) | (switchValue != 2) | (switchValue != 3) | (switchValue != 4) | (switchValue != 5) | (switchValue != 6)) {
//                System.out.println("SOMTHING WENT WRONG. DID YOU ENTER YOUR CHOICE CORRECTLY? LET'S TRY AGAIN");
//                dealWithSwitchRequest(menu());
//                keepLooping();
//            }
        } catch (NullPointerException | IllegalArgumentException e) {
            e.getMessage();
        }
        return switchValue;
    }

    @Override
    public void keepLooping() throws RemoteException {
        if (running) {
            dealWithSwitchRequest(menu());
            keepLooping();
        } else {

            try {
                serverQuiz.serialize(
                        serverQuiz.getQuizzes(),
                        serverQuiz.getQuizMap(),
                        serverQuiz.getQuestionsAndAnswers(),
                        serverQuiz.getHighestScorePlayerIDMap(),
                        serverQuiz.getFileName(),
                        serverQuiz.getQuizIDValue()
                );
            } catch (IOException ex) {
                System.out.println("COULD NOT LOCATE FILE.");
                ex.getCause();
            }

            System.exit(0);
        }
    }

    @Override
    public ArrayList<String> clientAddsSetOfQuestions(int id) throws RemoteException, NullPointerException, IllegalArgumentException {
        ArrayList<String> newListOfQuestions = new ArrayList<>();
        String question;
        String[] answers;

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
                try {
                    serverQuiz.serialize(
                            serverQuiz.getQuizzes(),
                            serverQuiz.getQuizMap(),
                            serverQuiz.getQuestionsAndAnswers(),
                            serverQuiz.getHighestScorePlayerIDMap(),
                            serverQuiz.getFileName(),
                            serverQuiz.getQuizIDValue()
                    );
                } catch (IOException ex) {
                    System.out.println("COULD NOT LOCATE FILE.");
                    ex.getCause();
                }
            } else {
                try {
                    newListOfQuestions.add(question);
                    answers = clientAddsAnswers(question);
                    serverQuiz.serverAddsAnswers(question, answers);
                    serverQuiz.getQuestionsAndAnswers().put(question, answers);
                } catch (NullPointerException | IllegalArgumentException e) {
                    e.getCause();
                }

            }
        }

        Object[] list = newListOfQuestions.toArray();
        try {
            for (Object a : list) {
                System.out.println("ADDED: " + a.toString());
            }
        } catch (NullPointerException e) {
            e.getCause();
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
                System.out.println("ENTER NEW QUIZ'S NAME:");
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
                    System.out.println("QUIZ: " + b.getQuizName() + " ID: " + b.getQuizID());
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
            case 4: //exit given the Quiz ID
                System.out.println("...");
                System.out.println("SAVED!");
                try {
                    serverQuiz.serialize(
                            serverQuiz.getQuizzes(),
                            serverQuiz.getQuizMap(),
                            serverQuiz.getQuestionsAndAnswers(),
                            serverQuiz.getHighestScorePlayerIDMap(),
                            serverQuiz.getFileName(),
                            serverQuiz.getQuizIDValue()
                    );
                } catch (IOException ex) {
                    System.out.println("COULD NOT LOCATE FILE.");
                    ex.getCause();
                }
                break;
            case 5://QUOTE QUIZ ID AND CLOSE. FULL PLAYER DETAILS SAVED ON SERVER.
                System.out.println("ENTER QUIZ ID TO REVEAL WINNER:");
                GetInput in = new GetInput();
                int quizID = in.getIntInput();
                System.out.println(serverQuiz.getWinnerForQuiz(quizID));
                break;
            case 6: //CLOSE DOWN
                System.out.println("CLOSING DOWN NOW....");
                System.out.println("(-: HAVE A GREAT DAY :-)");
                closeDown();
                break;
            default:
                System.out.println("SOMETHING WENT WRONG. PLEASE TRY AGAIN.");
                break;
        }
    }

    @Override
    public void closeDown() throws RemoteException {
        try {
            serverQuiz.serialize(
                    serverQuiz.getQuizzes(),
                    serverQuiz.getQuizMap(),
                    serverQuiz.getQuestionsAndAnswers(),
                    serverQuiz.getHighestScorePlayerIDMap(),
                    serverQuiz.getFileName(),
                    serverQuiz.getQuizIDValue()
            );
        } catch (IOException ex) {
            System.out.println("COULD NOT LOCATE FILE.");
            ex.getCause();
        }
        System.exit(0);
    }
}
