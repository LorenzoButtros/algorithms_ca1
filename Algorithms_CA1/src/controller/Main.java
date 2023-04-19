package controller;

import java.util.HashMap;
import model.Book;
import model.Student;
import view.Menu;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Main {

    private static boolean run = true;
    
    public static void main(String[] args) {
        
        BookController.createBookList();
        StudentController.createStudentList();
        while(run){
            Menu.showMainMenu();
        }
    }
    
    public static void endProgram(){
        run = false;
    }
    
}
