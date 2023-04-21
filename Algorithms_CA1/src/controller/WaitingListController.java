package controller;

import java.util.HashMap;
import model.Book;
import model.WaitingList;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class WaitingListController {

    private static HashMap<String,WaitingList> waitingLists = new HashMap<>(); // Using book id as keys
    
    public static void checkNextOnWaitingList(String bookId) {
        if(waitingLists.containsKey(bookId)){ // If the waiting list already exists
            waitingLists.get(bookId).printFirst(); // Prints the first sutudent's Id or tells if the queue is empty
        }else{ // If the waitinf list does not exist
            System.out.println("\nWaiting list is Empty.");
        }
    }
    
    public static void addStudentToWaitingList(String bookId) {
        System.out.print("Please input the student's Id: ");
        int studentId = StudentController.checkStudentId();  // Asks for a valid student id
        if(!waitingLists.containsKey(bookId)){
            waitingLists.put(bookId, new WaitingList());
        }
        waitingLists.get(bookId).enqueue(studentId);
    }

    public static void printAWaitingList(String bookId) {
        if(waitingLists.containsKey(bookId)){ // If the waiting list already exists
            waitingLists.get(bookId).printAll();// Prints the first sutudent's Id or tells if the queue is empty
        }else{ // If the waitinf list does not exist
            System.out.println("\nWaiting list is Empty.");
        }
        InputController.getEnterKey();
    }

    public static HashMap<String, WaitingList> getWaitingLists() {
        return waitingLists;
    }
    
}
