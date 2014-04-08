/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuizProject.Servers;

import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Esha
 */
public class GetInput implements GetInputInterf {

    @Override
    public int getIntInput() {
        String input1 = null;
        int intInput = 0;
        try{
        Scanner input = new Scanner(System.in);
        input1 = input.nextLine().trim();
        intInput = Integer.parseInt(input1);
       
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("TRY AGAIN.");
            e.getMessage();
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT DETECTED.");
            e.getMessage();
        } 
        return intInput;
    }

    @Override
    public String getStringInput() throws NullPointerException {
        String input1 = null;
        
        try{
        Scanner input = new Scanner(System.in);
        input1 = input.nextLine().trim();
        if (input1.equals("")){
            System.out.println("YOU LEFT THAT BLANK! MOVING ON...");
        }
        } catch ( NullPointerException e){
            System.out.println("TRY AGAIN.");
            e.getMessage();
        }

        return input1;
    }
}
