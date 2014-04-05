/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.Servers;

import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Esha
 */
public class GetInput implements GetInputInterf {

    @Override
    public int getIntInput() {
        Scanner input = new Scanner(System.in);
        String input1 = input.nextLine().trim();
        return Integer.parseInt(input1);
    }

    @Override
    public String getStringInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().trim();
    }
    
    public boolean checkForInput(String input){
        if (input.equals("")){
            System.out.println("INVALID INPUT DETECTED.");
            return false;
        } else return true;
    }
    
    public boolean checkInputValid(int input){
        if ((input==1)|(input==2)|(input==3)|(input==4)|(input==5)){
            System.out.println("INVALID INPUT DETECTED.");
            return true;
        } else{
            return false;
        }
    }

}
