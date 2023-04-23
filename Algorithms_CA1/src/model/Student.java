package model;

import controller.StudentRandomData;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Student {
    
    private int id;
    private String name, address, mobile;
    private static int currId = 1000; // Static id counter used in student creation
    private ArrayList<Borrowing> borrowHistory;
    
    // Construct for the first creation
    public Student() {
        id = createId();
        name = StudentRandomData.getRandomStudentName();
        mobile = StudentRandomData.getRandomMobile();
        address = StudentRandomData.getRandomStreetName();
        borrowHistory = new ArrayList<>();
    }
    
    // Construct for the load function
    public Student(int id, String name, String mobile, String address, ArrayList<Borrowing> borrowHistory) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.borrowHistory = borrowHistory;
    }
    
    public void printStudent() {
        System.out.println("\nId: " + id + "\nName: " + name + "\nMobile: " 
                + mobile + "\nAddress: " + address);
    }
    
    private int createId() {
        currId++; // Incremets counter before assigning to a new student
        return currId;
    } 

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public void printBorrowHistory() {
        
        if(borrowHistory.isEmpty()) {
            System.out.println("\nStudent's borrow history is empty.");
        }else{
            System.out.println("\n---[Student's Borrow History]---");
            for (int i = 0; i < borrowHistory.size(); i++) {
                borrowHistory.get(i).printBorrowing();
                System.out.println("");
            }
        }
    }
    
    public void addToBorrowHistory(Borrowing borrowing) {
        borrowHistory.add(borrowing);
    }
    
    public ArrayList<Borrowing> getBorrowHistory() {
        return borrowHistory;
    }
    
}
