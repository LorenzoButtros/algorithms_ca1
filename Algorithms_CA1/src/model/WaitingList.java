package model;

import controller.StudentController;
import controller.WaitingListController;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */

// This is where the array-based queue is implemented

public class WaitingList {
    
    private String bookId;
    private int first, last; // Pointers to first and last position of the queue 
    private int queue[]; // Array of student ids
    private static final int maxSize = 10; // Allow a maximun of 10 student ids in a waiting list 
    
    // Construct for first creation
    public WaitingList(String bookId) {
        
        this.bookId = bookId;
        first = 0;
        last = 0;
        queue = new int[maxSize];
    }
    
    // Construct for the load function
    public WaitingList(String bookId, int first, int last, int[] queue) {
        
        this.bookId = bookId;
        this.first = first;
        this.last = last;
        this.queue = queue;
    }
    
    // Inserts student id in the waiting list at the last position
    public void enqueue(int id) {
        
        if (maxSize == last) { // If queue is full
            System.out.printf("\nWaiting list is full.");
        }
        else{ // Insert student id
            queue[last] = id; 
            last++; // Increase poiter by one position
            WaitingListController.saveWList();
            System.out.println("\nStudent "+ id +" added to waiting list.");
        }
    }
 
    // Deletes student id at the first position
    public void dequeue() {
        
        if (first == last) { // If queue is empty
            System.out.printf("\nWaiting list is empty.");
        }else{ 
            int id = queue[first];
            // Shift all ids to the right by one position
            for (int i = 0; i < last - 1; i++) { 
                queue[i] = queue[i + 1];
            }
            // Store 0 at last position
            if (last < maxSize) {
                queue[last] = 0;
            }
            last--; // Decrease pointer by one position
            WaitingListController.saveWList();
            System.out.println("\nStudent "+ id +" removed from waiting list.");
        }
    }
 
    // Print all ids in the waiting list
    public void printAll() {
        
        int i;
        if (first == last) { // If queue is empty
            System.out.println("\nWaiting list is Empty.");
        }else{
            System.out.println("\n---[ Waiting list ]---");
            for (i = first; i < last; i++) { // Run through the array from first to last
                int id = queue[i];
                //System.out.println("i:"+i+" id:"+id+" first:"+first+" last:"+last);
                System.out.println((i+1) + " - Id: "+ id + " | " + "Name: " + StudentController.getStudent(id).getName());
            }
        }
    }
 
    // Print the id in the first positon
    public void printFirst() {
        
        if (first == last) { // If queue is empty
            System.out.print("\nWaiting list is Empty.");
        }else{
            // Prints the data of the student whose id is in the first position of the queue
            StudentController.getStudent(queue[first]).printStudent(); 
        }
    }

    public String getBookId() {
        return bookId;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    public int[] getQueue() {
        return queue;
    }

    public static int getMaxSize() {
        return maxSize;
    }

}
