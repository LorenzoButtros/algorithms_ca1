package controller;

import java.util.HashMap;
import model.WaitingList;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class WaitingListController {

    private static HashMap<String,WaitingList> waitingLists = new HashMap<>(); // Using book id as keys
    
    static void addStudentToWaitingList(String bookId) {
        System.out.print("Insert the student's Id: ");
        int studentId = StudentController.checkStudentId();  // Asks for a valid student id
        if(!waitingLists.containsKey(bookId)){
            waitingLists.put(bookId, new WaitingList());
        }
        waitingLists.get(bookId).enqueue(studentId);
    }
    
}
