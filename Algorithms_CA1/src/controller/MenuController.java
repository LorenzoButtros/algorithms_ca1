package controller;

import java.util.ArrayList;
import model.Book;
import model.Student;
import view.Menu;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class MenuController {

    // React to user input
    public static void answerMainMenu(int menuSize) {
        // Get input. Will only accept an int in range
        int option = InputController.getOption(1, menuSize);
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

            case 4: // List all books by Title
                Book[] sortedBooksByTitle = Sorting.sortBooksByTitle(BookController.getBooksArray());
                Menu.printBookArrayByTitle(sortedBooksByTitle);
                break;
                
            case 5: // List all books by Author
                Book[] sortedBooksByAuthor = Sorting.sortBooksByAuthor(BookController.getBooksArray());
                Menu.printBookArrayByAuthor(sortedBooksByAuthor);
                break;
                
            case 6: // Find a student by Id
                System.out.print("\nPlease enter the student's Id (4 digits): ");
                // Use search algorithm here to find student
                //StudentController.getStudent(StudentController.checkStudentId()).printStudent();
                break;
            
            case 7: // List all students by Id
                Student[] sortedStudentsById = Sorting.studentSortById(StudentController.getStudentsArray());
                Menu.printStudentArrayById(sortedStudentsById);
                break;
            
            case 8: // List all students by Name
                Student[] sortedStudentsByName = Sorting.studentSortByName(StudentController.getStudentsArray());
                Menu.printStudentArrayByName(sortedStudentsByName);
                break;
                
            case 9: // Lend a book
                Book bookLendById = BookController.matchBooksById();
                BorrowingController.checkAndBorrowBook(bookLendById.getId());
                break;
            
            case 10: // Return a bookById
                Book bookReturnById = BookController.matchBooksById();
                BorrowingController.returnBook(bookReturnById.getId());
                break;
            
            case 11: // Manage a waiting list
                Book bookViewWListById = BookController.matchBooksById();
                WaitingListController.printAWaitingList(bookViewWListById.getId());
                Menu.showWListMenu(bookViewWListById.getId());
                break;
            
            //case 12: // Add student to a waiting list
            //    Book bookAddWListById = BookController.matchBooksById();
            //    WaitingListController.addStudentToWaitingList(bookAddWListById.getId());
            //    break;
            
            case 12: // View a book's borrow history
                Book bookHistoryById = BookController.matchBooksById();
                bookHistoryById.printBorrowHistory();// Print the book's borrow history
                InputController.getEnterKey();
                break;
            
            case 13: // View a student's borrow history 
                System.out.print("\nPlease enter the student's Id (4 digits): ");
                Student student = StudentController.getStudent(StudentController.checkStudentId());
                student.printBorrowHistory();// Print the student's borrow history
                InputController.getEnterKey();
                break;
            
            case 14: // Exit Program
                System.out.println("\nHave a nice day!");
                Main.endProgram();
                break;
            
            default:
                throw new AssertionError();
        }
    }
    
    
}
