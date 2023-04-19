package view;

import controller.MenuController;
import java.util.ArrayList;
import model.Book;

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
        mainMenu.add("Find a book by Id");
        mainMenu.add("Find a book by Title");
        mainMenu.add("Find a book by Author");
        mainMenu.add("List all books");
        mainMenu.add("Find a student by Id");
        mainMenu.add("List all students");
        mainMenu.add("Lend a book");
        mainMenu.add("Return a book");
        mainMenu.add("View a waiting list");
        mainMenu.add("Add student to a waiting list");
        mainMenu.add("View a book's borrow history");
        mainMenu.add("View a student's borrow history");
        mainMenu.add("Exit program");
        // Prints the menu built by the printMenu method, that receives this menu arraylist as a parameter
        printMenu(mainMenu);
        MenuController.answerMainMenu();
    }
    
    public static void showBookList(ArrayList<Book> matchList) {
        ArrayList bookList = new ArrayList<String>();
        bookList.add("Book Matches"); // Header
        for (int i = 0; i < matchList.size(); i++) {
            bookList.add(matchList.get(i).getTitle() + " - " + matchList.get(i).getAuthorName() + " | Id: " + matchList.get(i).getId());
        }
        printMenu(bookList);
    }
    
    // Method that receives an arraylist of options and prints it
    public static void printMenu(ArrayList menuItems){
        
        // The header is the first item of the list
        String menu = "\n---[ " + menuItems.get(0) + " ]---"; 
        
        // Add the options to the string
        for (int i = 1; i < menuItems.size(); i++){ 
            menu = menu.concat("\n" + i +") " + menuItems.get(i)); // The option with its number
        }
        // Print the string
        System.out.println(menu);
    }

    
    
}
