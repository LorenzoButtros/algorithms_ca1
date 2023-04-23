package controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import model.Book;
import model.Borrowing;
import model.WaitingList;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class WaitingListController {

    private static Scanner scanner;
    private static HashMap<String,WaitingList> waitingLists = new HashMap<>(); // Using book id as keys
    
    public static void loadWListData() {
        try {
            File wListFile = new File("src/controller/waitingLists.txt"); // Instantiate a File object with the file in the folder
            scanner = new Scanner(new FileReader(wListFile)); // Instantiate Scanner object with the File
            if(wListFile.length() == 0) { // If file is empty
                System.out.println("waitingLists.txt - File is empty.");
            }else{
                loadWLists(); // Load waiting lists from txt
            }
        }catch(Exception e){
            System.out.println("waitingLists.txt - ERROR ACCESSING FILE");
        }
    }
    
    public static void loadWLists(){
        System.out.println("Loading wating lists from TXT");
        waitingLists = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader("src/controller/waitingLists.txt"));
            int entry = 0;
            while(scanner.hasNext()){ // Will run until there is nothing left to read
                try {
                    String[] read = scanner.nextLine().split("/");
                    String bookId = read[0];
                    int first = Integer.parseInt(read[1]);
                    int last = Integer.parseInt(read[2]);
                    int[] wList = new int[WaitingList.getMaxSize()];
                    // Build waiting list
                    for (int i = 3; i < read.length; i++) { // Waiting list data starts at index 3 of array
                        wList[i-3] = Integer.parseInt(read[i]);
                    }
                    waitingLists.put(bookId, new WaitingList(bookId, first, last, wList));
                }catch(Exception e){
                    System.out.println("waitingLists.txt - LOADING ERROR AT ENTRY " + entry);
                }
            }
            System.out.println("waitingLists.txt - Load successful.");
        }catch (Exception e) {
            System.out.println("waitingLists.txt - ERROR ACCESSING FILE DURING LOAD");
        }
    }
    
    public static void saveWList() {
        try {
            // The "false" tells the method to overwrite instead of append
            FileWriter fileWriter = new FileWriter("src/controller/waitingLists.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter,false);
            printWriter.flush(); // Erase contents of the file before wrinting
            int entry = 0;
            for (HashMap.Entry<String, WaitingList> wListEntry : waitingLists.entrySet()) { // Run through the waiting list HashMap
                try {
                    WaitingList wList = wListEntry.getValue();
                    printWriter.write(wList.getBookId()+ "/"
                            + wList.getFirst()+ "/"
                            + wList.getLast()+ "/");
                    for (int i = 0; i < WaitingList.getMaxSize(); i++) {
                        printWriter.write(wList.getQueue()[i]
                                + (i == (WaitingList.getMaxSize()-1) ? "" : "/")); // Will not finish the line with a /
                    }
                    printWriter.write("\n"); // End line to write next book
                    entry++;
                }catch(Exception e){
                    System.out.println("waitingLists.txt - SAVING ERROR AT ENTRY " + entry);
                }
            }
            printWriter.close();
            fileWriter.close();
            System.out.println("\nwaitingLists.txt - Updated.");
        }catch (Exception e) {
            System.out.println("waitingLists.txt - ERROR ACCESSING FILE DURING SAVE");
        }
    }
    
    public static void checkNextOnWaitingList(String bookId) {
        if(waitingLists.containsKey(bookId)){ // If the waiting list already exists
            waitingLists.get(bookId).printFirst(); // Prints the first sutudent's Id or tells if the queue is empty
        }else{ // If the waitinf list does not exist
            System.out.println("\nWaiting list is Empty.");
        }
    }
    
    public static void printAWaitingList(String bookId) {
        if(waitingLists.containsKey(bookId)){ 
            waitingLists.get(bookId).printAll();
        }else{
            System.out.println("\nWaiting list is Empty.");
        }
        //InputController.getEnterKey();
    }

    public static void addStudentToWaitingList(String bookId) {
        System.out.print("\nPlease input the student's Id: ");
        int studentId = StudentController.checkStudentId();  // Asks for a valid student id
        if(!waitingLists.containsKey(bookId)){
            waitingLists.put(bookId, new WaitingList(bookId));
        }
        waitingLists.get(bookId).enqueue(studentId);
        InputController.getEnterKey();
    }

    public static void removeStudentFromWaitingList(String bookId) {
        if(waitingLists.containsKey(bookId)){
            waitingLists.get(bookId).dequeue();
        }else{
            System.out.println("\nWaiting list is Empty.");
        }
        InputController.getEnterKey();
    }
    
    public static void answerWListMenu(int menuSize, String bookId) {
        // Get input. Will only accept an int in range
        int option = InputController.getOption(1, menuSize);
        switch (option) {
            case 1: // Enqueue
                
                addStudentToWaitingList(bookId);
                break;

            case 2: // Dequeue
                
                removeStudentFromWaitingList(bookId);
                break;

            case 3: // Done
                
                break;

            default:
                throw new AssertionError();
        }
    }
    
    public static HashMap<String, WaitingList> getWaitingLists() {
        return waitingLists;
    }
    
}
