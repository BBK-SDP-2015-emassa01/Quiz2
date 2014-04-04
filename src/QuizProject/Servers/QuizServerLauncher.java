/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.Servers;

import QuizProject.PlayerClient.QuizPlayerClient;
import QuizProject.SetupClient.QuizSetupClient;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnmarshalException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Esha
 */
public class QuizServerLauncher implements QuizServerLauncherInterf {

    QuizServerInterf serverQuiz;
    QuizSetupClient client;
    QuizPlayerClient player;

    String serviceName = "quiz";

    public QuizServerLauncher() throws RemoteException {
        // ERROR serverQuiz.deserialize();
    }

    public static void main(String[] args) throws RemoteException {
        QuizServerLauncher test = new QuizServerLauncher();
        test.launch();
    }

    private void launch() {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new RMISecurityManager());
//        }
        try {
            LocateRegistry.createRegistry(1099);
            QuizServerInterf server = new QuizServer();
            String registryHost = "//localhost/";
            Naming.rebind(registryHost + serviceName, server);
        } catch (UnmarshalException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException | RemoteException ex) {

            ex.printStackTrace();
        }

    }

    @Override
    public void close() throws RemoteException {
        if (serverQuiz==null){
            throw new NullPointerException("THERE IS NO QUIZ SERVER");
            } else {
        serverQuiz.serialize();
        }
        
        Registry registry = LocateRegistry.getRegistry(1099);
        try {
            registry.unbind(serviceName);
            UnicastRemoteObject.unexportObject(client.service, true);
            UnicastRemoteObject.unexportObject(player.service, true);
        } catch (NotBoundException ex) {
            throw new RemoteException("Could not un-register, quitting anyway...", ex);
        }
    }

}
