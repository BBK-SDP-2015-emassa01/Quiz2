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
        
        if (input1.equals("")){
            throw new IllegalArgumentException("TRY AGAIN.");
        }
        
        int intInput = 0;
        
        try {
            intInput = Integer.parseInt(input1);
        } catch (java.util.InputMismatchException e) {
            System.out.println("INVALID INPUT DETECTED.");
            e.getCause();
        }
        return intInput;
    }

    @Override
    public String getStringInput() throws IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        String input1 = input.nextLine().trim();

        if (!checkForValidStringInput(input1)) {
            throw new IllegalArgumentException("TRY AGAIN.");
        }

        return input1;
    }

    @Override
    public boolean checkForValidStringInput(String input) {
        if (input.equals("")) {
            System.out.println("INVALID INPUT DETECTED.");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkIntInputValid(int input) {
        Scanner kb = new Scanner(System.in);
        try {
            input = kb.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("INVALID INPUT DETECTED.");
            e.getCause();
            return false;
        }
        return false;
    }
      

}
