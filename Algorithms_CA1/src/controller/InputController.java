package controller;

import java.util.Scanner;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class InputController {

    public static void getEnterKey(){
        
        Scanner scanner = new Scanner(System.in); // Initialize scanner
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine(); // Just get Enter key
    }
    
    public static String getString(){
        
        Scanner scanner = new Scanner(System.in); // Initialize scanner
        return scanner.nextLine().trim(); // Return user input
    }
    
    public static boolean getYorN(){
        
        Scanner scanner = new Scanner(System.in); // Initialize scanner
        String input;
        boolean valid = false;
        while(!valid){ // Will never be true
            input = scanner.nextLine().trim(); // Get an input
            switch (input) {
                case "Y":
                case "y":
                    return true;
                case "N":
                case "n":
                    return false;
                default:
                    System.out.print("\nInvalid input, please input Y or N: ");
                    break;
            }
        }
        return false; // Will never reach here
    }
    
    public static int getInt(){
        
        Scanner scanner = new Scanner(System.in); // Initialize scanner
        int input;
        boolean valid = false;
        while(!valid){ // Will never be true
            try{
                input = scanner.nextInt(); // Get an input, will throw an exception if it's not an int
                return input;
            }catch (Exception e){
                System.out.print("\nInvalid input, please enter numbers only: ");
                scanner.nextLine(); // To prevent infinite loop
            }
        }
    return 0; // Will never reach here
    }
     
    public static int getOption(int min, int max){
        
        Scanner scanner = new Scanner(System.in); // Initialize scanner
        int input;
        boolean valid = false;
        while(!valid){ // Will never be true
            try{
                System.out.print("\nOption: ");
                input = scanner.nextInt(); // Get an input, will throw an exception if it's not an int within range
                if(input<min || input>max){
                    throw new Exception();
                }
                return input;
            }catch (Exception e){
                System.out.print("\nInvalid input, please enter a number from the menu: ");
                scanner.nextLine(); // To prevent infinite loop
            }
        }
    return 0; // Will never reach here
    }
    
}
