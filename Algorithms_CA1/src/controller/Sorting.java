package controller;

import model.Book;
import model.Student;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Sorting {
    
    // An implementation of the insertion sort algorithm for book titles
    public static Book[] sortBooksByTitle(Book[] array) {
        
        Book book;
        int pointer; 
        for (int i = 1; i < array.length; i++) {
            book = array[i]; // Saves content of i into book
            pointer = i; // Points at i
            // compareTo returns a >0 int if the first string is lexicographically greater then the second,
            // <0 if lesser and 0 if equal 
            // Compare Title to the left with Title in book
            while(pointer>0 && array[pointer-1].getTitle().compareTo(book.getTitle())>0) {
                array[pointer] = array[pointer-1]; // Shifts contents
                pointer--; // Decrement pointer
            }
            array[pointer] = book; // Insert content of book
        }
        return array;
    }
    
    // An implementation of the insertion sort algorithm for book authors
    public static Book[] sortBooksByAuthor(Book[] array) {
        
        int n = array.length;
        Book k; // Key element
        int pos;
        for (int i = 1; i < n; i++) {
            k = array[i];
            pos = i;
            while(pos>0 && array[pos-1].getAuthorName().compareTo(k.getAuthorName())>0) {
                array[pos] = array[pos-1];
                pos = pos-1;
            }
            array[pos] = k;
        }
        return array;
    }
    
    // An implementation of the insertion sort algorithm for student names
    public static Student[] studentSortByName(Student[] array) {
        
        int n = array.length;
        Student k; // Key element
        int pos;
        for (int i = 1; i < n; i++) {
            k = array[i];
            pos = i;
            //while(pointer>0 && array[pointer-1]>book){
            while(pos>0 && array[pos-1].getName().compareTo(k.getName())>0) {
                array[pos] = array[pos-1];
                pos = pos-1;
            }
            array[pos] = k;
        }
        return array;
    }
    
    // An implementation of the insertion sort algorithm for student ids
    public static Student[] studentSortById(Student[] array) {
        
        int n = array.length;
        Student k; // Key element
        int pos;
        for (int i = 1; i < n; i++) {
            k = array[i];
            pos = i;
            //while(pointer>0 && array[pointer-1]>book){
            while(pos>0 && array[pos-1].getId()>k.getId()) {
                array[pos] = array[pos-1];
                pos = pos-1;
            }
            array[pos] = k;
        }
        return array;
    }
}
