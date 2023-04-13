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
        System.out.println(MenuController.printMenu(mainMenu)); 
    }
    
    
    
    
    
}
