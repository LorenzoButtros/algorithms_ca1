package model;

import controller.StudentController;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Borrowing {

    String bookId, date, dueDate;
    int studentId;

    public Borrowing(String bookId, String date, String dueDate, int studentId) {
        this.bookId = bookId;
        this.date = date;
        this.dueDate = dueDate;
        this.studentId = studentId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getDate() {
        return date;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getStudentId() {
        return studentId;
    }
    
    // Display the book's data
    public void printBorrowing() {
        System.out.print("\nBook id: " + bookId
                + "\nStudent id: " + studentId + "\nStudent name: " 
                + StudentController.getStudent(studentId).getName() + "\nBorrowing date: " 
                + date + "\nDue date: " + dueDate);
    }
}
