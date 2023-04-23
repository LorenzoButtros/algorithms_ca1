package controller;

import static controller.StudentController.loadStudents;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import model.Book;
import model.Borrowing;
import model.Student;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class BorrowingController {
    
    private static Scanner scanner;
    private static HashMap<String,Borrowing> borrowings = new HashMap<>(); // Using book id as keys
    
    public static void loadBorrowingData() {
        try {
            File borrowingsFile = new File("src/controller/borrowings.txt"); // Instantiate a File object with the file in the folder
            scanner = new Scanner(new FileReader(borrowingsFile)); // Instantiate Scanner object with the File
            if(borrowingsFile.length() == 0) { // If file is empty
                System.out.println("borrowings.txt - File is empty.");
            }else{
                loadBorrowings(); // Load borrowings from txt
            }
        }catch(Exception e){
            System.out.println("borrowings.txt - ERROR ACCESSING FILE");
        }
    }
    
    public static void loadBorrowings(){
        System.out.println("Loading borrowings from TXT");
        borrowings = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader("src/controller/borrowings.txt"));
            int entry = 0;
            while(scanner.hasNext()){ // Will run until there is nothing left to read
                try {
                    String[] read = scanner.nextLine().split("/");
                    String bookId = read[0];
                    String data = read[1];
                    String dueDate = read[2];
                    int studentId = Integer.parseInt(read[3]);
                    borrowings.put(bookId, new Borrowing(bookId, data, dueDate, studentId));
                    entry++;
                }catch(Exception e){
                    System.out.println("borrowings.txt - LOADING ERROR AT ENTRY " + entry);
                }
            }
            System.out.println("borrowings.txt - Load successful.");
        }catch (Exception e) {
            System.out.println("borrowings.txt - ERROR ACCESSING FILE DURING LOAD");
        }
    }
    
    public static void saveBorrowings() {
        try {
            // The "false" tells the method to overwrite instead of append
            FileWriter fileWriter = new FileWriter("src/controller/borrowings.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter,false);
            printWriter.flush(); // Erase contents of the file before wrinting
            int entry = 0;
            for (HashMap.Entry<String, Borrowing> borrowingEntry : borrowings.entrySet()) { // Run through the borrowings HashMap
                try {
                    Borrowing borr = borrowingEntry.getValue();
                    printWriter.write(borr.getBookId()+ "/"
                            + borr.getDate() + "/"
                            + borr.getDueDate() + "/"
                            + borr.getStudentId() + "\n");
                    entry++;
                }catch(Exception e){
                    System.out.println("borrowings.txt - SAVING ERROR AT ENTRY " + entry);
                }
            }
            printWriter.close();
            fileWriter.close();
            System.out.println("\nborrowings.txt - Updated.");
        }catch (Exception e) {
            System.out.println("borrowings.txt - ERROR ACCESSING FILE DURING SAVE");
        }
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
            System.out.print("This book is available. Please enter the borrowing date (dd-mm-yyyy, do not use /)): ");
            date = InputController.getString();
            System.out.print("Please enter the due date (dd-mm-yyyy, do not use /): ");
            dueDate = InputController.getString();
            System.out.print("Please enter the student's Id (4 digits): ");
            studentId = StudentController.checkStudentId(); // Asks for a valid student id
            Borrowing newBorrowing = new Borrowing(bookId,date,dueDate,studentId);
            borrowings.put(newBorrowing.getBookId(), newBorrowing);
            StudentController.getStudent(studentId).addToBorrowHistory(newBorrowing);
            BookController.getBook(bookId).addToBorrowHistory(newBorrowing);
            saveBorrowings();
            BookController.saveBooks();
            StudentController.saveStudents();
            System.out.println("\nBorrowing sucessful.");
            InputController.getEnterKey();
        }
    }
    
    public static void returnBook(String bookId) {
        
        if(isBorrowed(bookId)) { // Check if book is borrowed
            borrowings.remove(bookId); // Remove that borrowing from HashMap
            System.out.println("");
            saveBorrowings();
            System.out.println("\nBook returned.");
            WaitingListController.checkNextOnWaitingList(bookId); // Check the next on the book's waiting list
        }else{
            System.out.println("\nThis book is not borrowed.");
        }
        InputController.getEnterKey();
    }

    public static boolean isBorrowed(String bookId) {
        return borrowings.containsKey(bookId);
    }
    
    public static Borrowing getBorrowing(String bookId) {
        return borrowings.get(bookId);
    }
    
    public static HashMap<String, Borrowing> getBorrowings() {
        return borrowings;
    }
    
    
    
}
