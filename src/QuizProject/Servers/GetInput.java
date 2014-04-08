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
            e.getCause();
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT DETECTED.");
            e.getCause();
        } 
        return intInput;
    }

    @Override
    public String getStringInput() throws NullPointerException {
        String input1 = null;
        

        Scanner input = new Scanner(System.in);
        input1 = input.nextLine().trim();
        if (input1.equals("")){
            throw new NullPointerException("YOU LEFT THAT BLANK! ");
        }
        

        return input1;
    }
    
    
//    try{
//        Scanner input = new Scanner(System.in);
//        input1 = input.nextLine().trim();
//        if (input1.equals("")){
//            throw new NullPointerException("YOU LEFT THAT BLANK! ");
//        }
//        } catch ( NullPointerException e){
//            System.out.println("TRY AGAIN.");
//            e.getCause();
//        }
//
//        return input1;
//    }
}
