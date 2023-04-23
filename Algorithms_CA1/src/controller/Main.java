package controller;

import model.Borrowing;
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
        
        BookController.loadBookData();
        StudentController.loadStudentData();
        BorrowingController.loadBorrowingData();
        WaitingListController.loadWListData();
        BookController.saveBooks();
        StudentController.saveStudents();
        while(run){
            Menu.showMainMenu();
        }
    }
    
    public static void endProgram(){
     
        run = false;
    }
}
