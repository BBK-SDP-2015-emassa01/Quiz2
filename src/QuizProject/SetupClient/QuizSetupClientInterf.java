/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.SetupClient;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Esha
 */
public interface QuizSetupClientInterf {

    String[] clientAddsAnswers(String question);

    ArrayList<String> clientAddsSetOfQuestions(int id) throws RemoteException;

    void closeDown() throws RemoteException;

    void dealWithSwitchRequest(int choice) throws RemoteException;

    void keepLooping() throws RemoteException;

    void launch() throws RemoteException;

    int menu();
    
}
