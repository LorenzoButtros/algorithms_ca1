package model;

/**
 *
 * @author lmbut
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
    
}
