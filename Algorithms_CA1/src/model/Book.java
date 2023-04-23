package model;

import controller.BorrowingController;
import controller.InputController;
import controller.WaitingListController;
import java.util.ArrayList;
import jdk.internal.util.xml.impl.Input;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Book {
    
    private String id, title, authorName, genres;
    private ArrayList<Borrowing> borrowHistory;

    // Construct for the first creation
    public Book(String id, String authorName, String title, String genres) {
        
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.genres = genres;
        borrowHistory = new ArrayList<>();
    }

    // Construct for the load function
    public Book(String id, String authorName, String title, String genres, ArrayList<Borrowing> borrowHistory) {
        
        this.id = id;
        this.authorName = authorName;
        this.title = title;
        this.genres = genres;
        this.borrowHistory = borrowHistory;
    }
    
    public String getTitle() {
        
        return title;
    }

    public String getId() {
        
        return id;
    }

    public String getAuthorName() {
        
        return authorName;
    }
    
    public String getGenres() {
        
        return genres;
    }
    
    // Display the book's data
    public void printBook() {
        
        System.out.print("\n---[Book]---\nTitle: " + title + "\nAuthor: " + authorName + "\nGenres: " 
                + genres + "\nId: " + id);
        if(BorrowingController.isBorrowed(id)){
            System.out.print("\nAvailable: No\n\n---[Current borrowing]---");
            BorrowingController.getBorrowing(id).printBorrowing();
            System.out.println("");
            WaitingListController.printAWaitingList(id);
        }else{
            System.out.println("\nAvailable: Yes");
        }
        InputController.getEnterKey();
    }

    public void printBorrowHistory() {
        
        if(borrowHistory.isEmpty()) {
            System.out.println("\nBook's borrow history is empty.");
        }else{
            System.out.println("\n---[Book's Borrow History]---");
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
