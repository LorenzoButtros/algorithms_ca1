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
    
    private static HashMap<String,Borrowing> borrowings; // Using book id as keys
    
    public static boolean isBorrowed(String bookId){
        return borrowings.containsKey(bookId);
    }
    
    public static void checkAndBorrowBook(String bookId){
        String date, dueDate;
        int studentId;
        
        if(isBorrowed(bookId)){
            System.out.println("This book is borrowed. Add student to the waiting list (Y/N)?");
            if(InputController.getYorN){
                WaitingListController.addStudentToWaitingList();
            }
        }else{
            System.out.println("This book is available. Please enter the borrowing date (dd/mm/yyyy):");
            date = InputController.getString();
            System.out.println("Please enter the due date (dd/mm/yyyy):");
            dueDate = InputController.getString();
            System.out.println("Please enter the student's Id (4 digits):");
            studentId = StudentController.checkStudentId(InputController.getInt());
            Borrowing newBorrowing = new Borrowing(bookId,date,dueDate,studentId);
            borrowings.put(newBorrowing.getBookId(), newBorrowing);
        }
    }
    
}
