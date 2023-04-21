package controller;

import java.util.ArrayList;
import model.Book;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class MenuController {

    public static void answerMainMenu() {
        int option = InputController.getOption(1, 13);
        switch (option) {
            case 1: // Find a book by Id
                Book bookById = BookController.matchBooksById();
                bookById.printBook(); // Print the book's data
                break;

            case 2: // Find a book by Title
                Book bookByTitle = BookController.matchBooksByTitle();
                bookByTitle.printBook(); // Print the book's data
                break;

            case 3: // Find a book by Author
                Book bookByAuthor = BookController.matchBooksByAuthor();
                bookByAuthor.printBook(); // Print the book's data
                break;

            case 4: // List all books
                
                break;
            case 5: // Find a student by Id
                System.out.print("\nPlease enter the student's Id (4 digits): ");
                StudentController.getStudent(StudentController.checkStudentId()).printStudent();
                break;
            case 6: // List all students
                
                break;
            case 7: // Lend a bookById
                Book bookLendById = BookController.matchBooksById();
                BorrowingController.checkAndBorrowBook(bookLendById.getId());
                break;
            case 8: // Return a bookById
                Book bookReturnById = BookController.matchBooksById();
                BorrowingController.returnBook(bookReturnById.getId());
                break;
            case 9: // View a waiting list
                Book bookViewWListById = BookController.matchBooksById();
                WaitingListController.printAWaitingList(bookViewWListById.getId());
                break;
            case 10: // Add student to a waiting list
                Book bookAddWListById = BookController.matchBooksById();
                WaitingListController.addStudentToWaitingList(bookAddWListById.getId());
                break;
            case 11: // View a bookById's borrow history
                // boorow list in object
                break;
            case 12: // View a student's borrow history 
                
                break;
            case 13: // Exit Program
                System.out.println("\nHave a nice day!");
                Main.endProgram();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    /*
    public static int answerBookList(int size) {
        return InputController.getOption(1, size);
    }
    */
    
    /*
    // Method that builds and prints the "list staff by category" menu
    public static void showCategoryMenu(){
        
        ArrayList categoryMenu = new ArrayList<String>();
        
        categoryMenu.add("List staff by category"); // Header
        // Adds each club staff type to the list
        for (ClubStaffTitle cst : ClubStaffTitle.values()) {
            
            categoryMenu.add(cst.toString());
        }
        
        // Adds each coaching staff type to the list
        for (CoachingStaffTitle cst : CoachingStaffTitle.values()) {
            
            categoryMenu.add(cst.toString());
        }
        
        categoryMenu.add("Back to Main Menu");
        System.out.println(printMenu(categoryMenu));
    }
    
    // Method that builds and prints the "list group by day" menu
    public static void showDayMenu(){
        
        ArrayList dayMenu = new ArrayList<String>();
        
        dayMenu.add("List training groups by day");
        
        for(int i=0 ; i < TrainingDay.values().length ;i++){
            
            dayMenu.add(TrainingDay.values()[i].toString());
        }
        
        dayMenu.add("Back to Main Menu");
        System.out.println(printMenu(dayMenu));
    }
    
    // Method that builds and prints the "list players by group" menu. 
    // It receives the group list as a parameter
    public static void showGroupMenu(ArrayList<TrainingGroup> groupList){
        
        ArrayList groupMenu = new ArrayList<String>();
        
        groupMenu.add("List players by training group");
        
        for(int i=0 ; i < groupList.size() ;i++){
            
            groupMenu.add(groupList.get(i).getId());
        }
        
        groupMenu.add("Back to Main Menu");
        System.out.println(printMenu(groupMenu));
    }
    
    // Method that builds and prints the "list groups by coach" or "list players by coach" menu.
    // It receives the list of coaches and a boolean to know which header to print.
    public static void showCoachMenu(ArrayList<CoachingStaff> coachList, boolean listGroups){
        
        ArrayList coachMenu = new ArrayList<String>(); 
        
        if(listGroups){
            
            coachMenu.add("List groups by coach");
        }else{
            
            coachMenu.add("List players by coach");
        }
                
        for(int i=0 ; i < coachList.size() ;i++){
            
            coachMenu.add(coachList.get(i).getName());
        }
        
        coachMenu.add("Back to Main Menu");
        System.out.println(printMenu(coachMenu));
    }
    */

   
    
    
}
