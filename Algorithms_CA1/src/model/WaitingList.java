package model;

import controller.StudentController;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */

// This is where the array-based queue is implemented

public class WaitingList {
    
    private int first, last; // Pointers to first and last position of the queue 
    private final int maxSize = 10; // Allow a maximun of 10 student ids in a waiting list 
    private int queue[]; // Array of student ids
 
    public WaitingList()
    {
        first = 0;
        last = 0;
        queue = new int[maxSize];
    }
 
    // Inserts student id in the waiting list at the last position
    public void enqueue(int id)
    {
        if (maxSize == last) { // Check if queue is full
            System.out.printf("\nWaiting list is full.");
        }
        else{ // Insert student id
            queue[last] = id;
            last++; // Increase poiter by one position
            System.out.println("\nStudent "+ id +" added to waiting list.");
        }
    }
 
    // Deletes student id at the first position
    public void dequeue()
    {
        if (first == last) { // Check if queue is empty
            System.out.printf("\nWaiting list is empty");
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
            
            System.out.println("\nStudent "+ id +" removed from waiting list.");
        }
    }
 
    // Print all ids in the waiting list
    public void printAll()
    {
        int i;
        if (first == last) { // Check if queue is empty
            System.out.printf("\nWaiting list is Empty.");
        }else{
        
            // Run through the array from first to last
            for (i = first; i < last; i++) {
                int id = queue[i];
                System.out.printf((i+1) + " - Id: "+ id + " | " + "Name: " + StudentController.getStudent(id).getName());
            }
        }
    }
 
    // Print the id in the first positon
    public void queueFirst()
    {
        if (first == last) { // Check if queue is empty
            System.out.printf("\nWaiting list is Empty.");
        }else{
            int id = queue[first];
            System.out.printf("\nNext student in the waiting list:\nId: " + id + "\nName: " + StudentController.getStudent(id).getName());
        }
    }
    
}
