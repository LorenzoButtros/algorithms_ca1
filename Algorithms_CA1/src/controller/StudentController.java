package controller;

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
public class StudentController {
    
    private static Scanner scanner;
    private static HashMap<Integer,Student> students = new HashMap<>(); // Using id as keys
    
    public static void loadStudentData() {
        try {
            File studentsFile = new File("src/controller/students.txt"); // Instantiate a File object with the file in the folder
            scanner = new Scanner(new FileReader(studentsFile)); // Instantiate Scanner object with the File
            if(studentsFile.length() == 0) { // If file is empty
                createRandomStudents();
            }else{
                loadStudents(); // Load students from txt
            }
        }catch(Exception e){
            System.out.println("students.txt - ERROR ACCESSING FILE");
        }
    }
    
    // Create students on first usage
    private static void createRandomStudents(){
        System.out.println("Creating random students");
        for (int i = 0; i < 100; i++) {
            Student newStudent = new Student();
            students.put(newStudent.getId(), newStudent);
        }
    }
    
    public static void loadStudents(){
        System.out.println("Loading students from TXT");
        students = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader("src/controller/students.txt"));
            while(scanner.hasNext()){ // Will run until there is nothing left to read
                try {
                    String[] read = scanner.nextLine().split("/");
                    int id = Integer.parseInt(read[0]);
                    String name = read[1];
                    String mobile = read[2];
                    String address = read[3];
                    String bookId, date, dueDate;
                    int studentId;
                    ArrayList<Borrowing> bList = new ArrayList<>();
                    // Build each borrowing with next 4 entries
                    for (int i = 4; i < read.length; i++) { // Borrowing data starts at index 4 of array
                        bookId = read[i];
                        i++;
                        date = read[i];
                        i++;
                        dueDate = read[i];
                        i++;
                        studentId = Integer.parseInt(read[i]);
                        bList.add(new Borrowing(bookId, date, dueDate, studentId));
                    }
                    students.put(id, new Student(id, name, mobile, address, bList));
                }catch(Exception e){
                    System.out.println("students.txt - READING ERROR");
                }
            }
            System.out.println("students.txt - File reading complete.");
        }catch (Exception e) {
            System.out.println("students.txt - STUDENT CREATION ERROR");
        }
    }
    
    public static void saveStudents() {
        try {
            // The "false" tells the method to overwrite instead of append
            FileWriter fileWriter = new FileWriter("src/controller/students.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter,false);
            printWriter.flush(); // Erase contents of the file before wrinting
            for (HashMap.Entry<Integer, Student> studentEntry : students.entrySet()) { // Run through the books HashMap
                try {
                    Student student = studentEntry.getValue();
                    ArrayList<Borrowing> borrs = student.getBorrowHistory();
                    printWriter.write(student.getId() + "/"
                            + student.getName()+ "/"
                            + student.getMobile()+ "/"
                            + student.getAddress()
                            + (borrs.isEmpty() ? "" : "/")); // // Will not write a / if borrs is empty
                    for (int i = 0; i < borrs.size(); i++) {
                        printWriter.write(borrs.get(i).getBookId() + "/" 
                                + borrs.get(i).getDate() + "/"
                                + borrs.get(i).getDueDate() + "/" 
                                + borrs.get(i).getStudentId() 
                                + (i == (borrs.size()-1) ? "" : "/")); // Will not finish the line with a /
                    }
                    printWriter.write("\n"); // End line to write next book
                }catch(Exception e){
                    System.out.println("students.txt - READING ERROR");
                }
            }
            printWriter.close();
            fileWriter.close();
            System.out.println("students.txt - File reading complete.");
        }catch (Exception e) {
            System.out.println("students.txt - BOOK CREATION ERROR");
        }
    }
    
    
    
    public static int checkStudentId(){
        int id=0;
        boolean valid = false;
        while(!valid){ // Will never be true
            id = InputController.getInt();
            if(students.containsKey(id)){
                return id;
            }else{
                System.out.print("\nStudent not found, please input another id: ");
            }
        }
        return id; // Will never reach here
    }

    public static Student getStudent(int id) {
        return students.get(id);
    }

    public static Student[] getStudentsArray() {
        
        Student[] studentsArray = students.values().toArray(new Student[0]);
        return  studentsArray;
    }
    
}
