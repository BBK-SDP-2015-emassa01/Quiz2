/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package QuizProject.Servers;

import java.rmi.RemoteException;

/**
 *
 * @author Esha
 */
public interface QuizServerLauncherInterf {

    /**
     * Serializes the QuizServer Object, and unbinds registry.
     * @throws RemoteException
     */
    void close() throws RemoteException;
    
}
