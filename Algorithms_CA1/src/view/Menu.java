package view;

import controller.InputController;
import controller.MenuController;
import controller.Sorting;
import java.util.ArrayList;
import model.Book;
import model.Student;

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
        mainMenu.add("List all books by Title");
        mainMenu.add("List all books by Author");
        mainMenu.add("Find a student by Id");
        mainMenu.add("List all students by Id");
        mainMenu.add("List all students by Name");
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
    public static void printMenu(ArrayList menuItems) {
        
        // The header is the first item of the list
        String menu = "\n---[ " + menuItems.get(0) + " ]---"; 
        
        // Add the options to the string
        for (int i = 1; i < menuItems.size(); i++){ 
            menu = menu + "\n" + i +") " + menuItems.get(i); // The option with its number
        }
        // Print the string
        System.out.println(menu);
    }

    public static void printBookArrayByTitle(Book[] books) {
        
        System.out.print("\n---[All books by Title]---");
        for (int i = 0; i < books.length; i++) {
            System.out.print("\n" + books[i].getTitle() + " | Author: " 
                    + books[i].getAuthorName() + " | Id: " + books[i].getId());
        }
        System.out.println("");
        InputController.getEnterKey();
    }
    
    public static void printBookArrayByAuthor(Book[] books) {
        
        System.out.print("\n---[All books by Author]---");
        for (int i = 0; i < books.length; i++) {
            System.out.print("\n" + books[i].getAuthorName() + " | Title: " 
                    + books[i].getTitle() + " | Id: " + books[i].getId());
        }
        System.out.println("");
        InputController.getEnterKey();
    }
    
    public static void printStudentArrayById(Student[] students) {
        
        System.out.print("\n---[All students by Id]---");
        for (int i = 0; i < students.length; i++) {
            System.out.print("\n" + students[i].getId() + " | Name: " 
                    + students[i].getName());
        }
        System.out.println("");
        InputController.getEnterKey();
    }
    
    public static void printStudentArrayByName(Student[] students) {
        
        System.out.print("\n---[All students by Name]---");
        for (int i = 0; i < students.length; i++) {
            System.out.print("\n" + students[i].getName() + " | Id: " 
                    + students[i].getId());
        }
        System.out.println("");
        InputController.getEnterKey();
    }
}
