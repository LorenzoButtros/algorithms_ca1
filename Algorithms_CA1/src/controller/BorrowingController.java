package controller;

import java.util.HashMap;
import model.Book;
import model.Borrowing;
import model.Student;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class BorrowingController {
    
    private static HashMap<String,Borrowing> borrowings = new HashMap<>(); // Using book id as keys
    
    public static boolean isBorrowed(String bookId) {
        return borrowings.containsKey(bookId);
    }
    
    public static Borrowing getBorrowing(String bookId) {
        return borrowings.get(bookId);
    }
    
    public static void checkAndBorrowBook(String bookId) {
        String date, dueDate;
        int studentId;
        
        if(isBorrowed(bookId)) {
            System.out.print("This book is borrowed. Add student to the waiting list (Y/N)?: ");
            if(InputController.getYorN()){ // If the user inputs Y
                WaitingListController.addStudentToWaitingList(bookId);
            }
        }else{
            System.out.print("This book is available. Please enter the borrowing date (dd/mm/yyyy): ");
            date = InputController.getString();
            System.out.print("Please enter the due date (dd/mm/yyyy): ");
            dueDate = InputController.getString();
            System.out.print("Please enter the student's Id (4 digits): ");
            studentId = StudentController.checkStudentId(); // Asks for a valid student id
            Borrowing newBorrowing = new Borrowing(bookId,date,dueDate,studentId);
            borrowings.put(newBorrowing.getBookId(), newBorrowing);
            StudentController.getStudent(studentId).addToBorrowHistory(newBorrowing);
            BookController.getBook(bookId).addToBorrowHistory(newBorrowing);
            System.out.println("\nBorrowing sucessful.");
            InputController.getEnterKey();
        }
    }
    
    public static void returnBook(String bookId) {
        int studentId;
        
        if(isBorrowed(bookId)) {
            borrowings.remove(bookId);
            System.out.println("\nBook returned.");
            WaitingListController.checkNextOnWaitingList(bookId);
        }else{
            System.out.println("\nThis book is not borrowed.");
        }
        InputController.getEnterKey();
    }

    public static HashMap<String, Borrowing> getBorrowings() {
        return borrowings;
    }
    
    
    
}
