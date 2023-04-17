package view;

import controller.MenuController;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Menu {
    
    // Method that builds and prints the main menu
    public static void showMainMenu(){
        
        ArrayList mainMenu = new ArrayList<String>(); // List that receives the options below
        mainMenu.add("Library Menu"); // Header
        mainMenu.add("Find a book");
        mainMenu.add("List all books");
        mainMenu.add("Find a student");
        mainMenu.add("List all students");
        mainMenu.add("View a student's borrow history");
        mainMenu.add("Lend a book");
        mainMenu.add("Return a book");
        mainMenu.add("View a waiting list");
        mainMenu.add("Add student to a waiting list");
        mainMenu.add("Exit program");
        
        // Prints the menu built by the printMenu method, that receives this menu arraylist as a parameter
        System.out.println(printMenu(mainMenu)); 
    }
    
    // Method that receives an arraylist of options and builds a printable string
    public static String printMenu(ArrayList menuItems){
        
        // The header is the first item of the list
        String menu = "\n**** " + menuItems.get(0) + " **** \n"; 
        
        // i starts as 1 so the first option will be number 1. 0 was the header
        for (int i = 1; i < menuItems.size(); i++){ 
            
            menu = menu.concat("\n" + i +") " + menuItems.get(i)); // The option with its number
        }
        
        return menu;
    }
    
    
    
}
