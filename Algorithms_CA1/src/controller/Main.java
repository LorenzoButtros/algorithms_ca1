package controller;

import java.util.HashMap;
import model.Book;
import model.Borrowing;
import model.Student;
import model.WaitingList;
import view.Menu;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Main {

    private static boolean run = true;
    
    public static void main(String[] args) {
        
        //BookController.createBooksFromCSV();
        BookController.loadBookData();
        StudentController.loadStudentData();
        BorrowingController.loadBorrowingData();
        WaitingListController.loadWListData();
        //BookController.saveBooks();
        //StudentController.saveStudents();
        //testCase();
        while(run){
            Menu.showMainMenu();
        }
    }
    
    public static void endProgram(){
     
        run = false;
    }
    
    private static void testCase(){
        
        String bookId = "2cc44192-02a1-472e-b9b9-865dda6345c6";
        Borrowing newBorrowing = new Borrowing(bookId,"20/04/2023","27/04/2023",1001);
        BorrowingController.getBorrowings().put(newBorrowing.getBookId(), newBorrowing);
        WaitingListController.getWaitingLists().put(bookId, new WaitingList(bookId));
        WaitingListController.getWaitingLists().get(bookId).enqueue(1002);
        WaitingListController.getWaitingLists().get(bookId).enqueue(1003);
        WaitingListController.getWaitingLists().get(bookId).enqueue(1004);
        WaitingListController.getWaitingLists().get(bookId).enqueue(1005);
    }

}
