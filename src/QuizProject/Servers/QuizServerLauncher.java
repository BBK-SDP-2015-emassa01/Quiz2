/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.Servers;

import QuizProject.PlayerClient.QuizPlayerClientInterface;
import QuizProject.SetupClient.QuizSetupClientsInterface;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.UnmarshalException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Esha
 */
public class QuizServerLauncher implements QuizServerLauncherInterf {

    private QuizServerInterf serverQuiz;
    private QuizSetupClientsInterface client;
    private QuizPlayerClientInterface player;

    private final String serviceName = "quiz";

    private final boolean running = true;

    public QuizServerLauncher() throws RemoteException {
        // do nothing
    }

    public static void main(String[] args) throws RemoteException, InterruptedException {
        try {
            QuizServerLauncherInterf test = new QuizServerLauncher();
            test.launch();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void launch() throws InterruptedException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            LocateRegistry.createRegistry(1099);
            QuizServerInterf serverQuiz = new QuizServerData();
            String registryHost = "//localhost/";
            Naming.rebind(registryHost + serviceName, serverQuiz);
        } catch (UnmarshalException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException | RemoteException ex) {

            ex.printStackTrace();
        }
    }

    @Override
    public void close() throws RemoteException {
        try {
            if (serverQuiz == null) {
                throw new NullPointerException("THERE IS NO QUIZ SERVER");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

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
        } catch (IOException | NullPointerException ex) {
            System.out.println("COULD NOT LOCATE FILE.");
            ex.printStackTrace();
        }

        Registry registry = LocateRegistry.getRegistry(1099);
        try {
//            registry.unbind(serviceName);
            String registryHost = "//localhost/";
            Naming.unbind(registryHost + serviceName);
//            UnicastRemoteObject.unexportObject(client.service, true);
//            UnicastRemoteObject.unexportObject(player.service, true);
        } catch (NotBoundException ex) {
            throw new RemoteException("DID NOT UNBIND");
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean getRunningVariable(){
        return this.running;
    }

}
