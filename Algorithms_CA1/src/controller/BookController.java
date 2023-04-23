package controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import model.Book;
import model.Borrowing;
import view.Menu;

/**
 *
 * @author lmbut
 */
public class BookController {
    
    private static Scanner scanner;
    private static HashMap<String,Book> books; // Using id as keys
    
    public static void loadBookData() {
        try {
            File booksFile = new File("src/controller/books.txt"); // Instantiate a File object with the file in the folder
            scanner = new Scanner(new FileReader(booksFile)); // Instantiate Scanner object with the File
            if(booksFile.length() == 0) { // If file is empty
                createBooksFromCSV(); // Create books from MOCK_DATA.csv
            }else{
                loadBooks(); // Load book from txt
            }
        }catch(Exception e){
            System.out.println("books.txt - ERROR ACCESSING FILE");
        }
    }
    
    // Create books on first usage
    private static void createBooksFromCSV(){
        System.out.println("Creating books from CSV");
        books = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader("src/controller/MOCK_DATA.csv"));
            while(scanner.hasNext()){ // Will run until there is nothing left to read
                try {
                    String[] read = scanner.nextLine().split(","); // Read an entire line and split it into an array
                    String id = read[0];
                    String firstName = read[1];
                    String lastName = read[2];
                    String authorName = lastName + ", " + firstName; // Join last and first name
                    String title = read[3]; // Will ignore text after the comma in some titles have
                    if(title.contains("\"")){ // Because some titles have 1 or 2 commas in them, causing them to split incorrectly
                        String title2 = read[4];
                        title = title.substring(1, title.length()); // Remove the " in the beginning
                        if(title2.contains("\"")){
                            title2 = title2.substring(0, title2.length()-1); // Remove the " in the end
                            title = title + "," + title2;
                        }else{
                            String title3 = read[5];
                            title3 = title3.substring(0, title3.length()-1); // Remove the " in the end
                            title = title + "," + title2 + "," + title3;
                        }
                    }
                    String genres = read[read.length-1]; // The last index
                    books.put(id, new Book(id, authorName, title, genres)); // Add the new book to the HashMap
                }catch(Exception e){
                    System.out.println("MOCK_DATA.csv - READING ERROR");
                }
            }
            System.out.println("MOCK_DATA.csv - File reading complete.");
        }catch (Exception e) {
            System.out.println("MOCK_DATA.csv - BOOK CREATION ERROR");
        }
    }
    
    public static void loadBooks(){
        System.out.println("Loading books from TXT");
        books = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader("src/controller/books.txt"));
            while(scanner.hasNext()){ // Will run until there is nothing left to read
                try {
                    String[] read = scanner.nextLine().split("/");
                    String id = read[0];
                    String authorName = read[1];
                    String title = read[2];
                    String genres = read[3];
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
                    books.put(id, new Book(id, authorName, title, genres, bList));
                }catch(Exception e){
                    System.out.println("books.txt - READING ERROR");
                }
            }
            System.out.println("books.txt - File reading complete.");
        }catch (Exception e) {
            System.out.println("books.txt - BOOK CREATION ERROR");
        }
    }
    
    public static void saveBooks() {
        try {
            // The "false" tells the method to overwrite instead of append
            FileWriter fileWriter = new FileWriter("src/controller/books.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter,false);
            printWriter.flush(); // Erase contents of the file before wrinting
            for (HashMap.Entry<String, Book> bookEntry : books.entrySet()) { // Run through the books HashMap
                try {
                    Book book = bookEntry.getValue();
                    ArrayList<Borrowing> borrs = book.getBorrowHistory();
                    printWriter.write(book.getId() + "/"
                            + book.getAuthorName() + "/"
                            + book.getTitle() + "/"
                            + book.getGenres() 
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
                    System.out.println("books.txt - READING ERROR");
                }
            }
            printWriter.close();
            fileWriter.close();
            System.out.println("books.txt - File reading complete.");
        }catch (Exception e) {
            System.out.println("books.txt - BOOK CREATION ERROR");
        }
    }
    
    public static Book matchBooksById(){
        ArrayList<Book> matchList = new ArrayList<>();
        do{
            System.out.print("\nPlease input a piece of the book Id (case sensitive): ");
            String id = InputController.getString(); // Get an Id or piece of Id as string from the user
            for (HashMap.Entry<String, Book> book : books.entrySet()) { // Runs through the books HashMap
                if(book.getKey().contains(id)){ // If the book's id contains the input
                    matchList.add(book.getValue()); // Adds the book from the HashMap to the List
                }
            }
            if(matchList.isEmpty()){
                System.out.println("\nNo matches found.");
            }
        }while(matchList.isEmpty());
        Menu.showBookList(matchList); // Prints the list
        return matchList.get(InputController.getOption(1, matchList.size())-1); // -1 because the first option is 1 but the first index is 0 
    }
    
    public static Book matchBooksByTitle(){
        ArrayList<Book> matchList = new ArrayList<>();
        do{
            System.out.print("\nPlease input a piece of the book title (case sensitive): ");
            String title = InputController.getString(); // Get a title or piece of title as string from the user
            for (HashMap.Entry<String, Book> book : books.entrySet()) { // Runs through the books HashMap
                if(book.getValue().getTitle().contains(title)){ // If the book's title contains the input
                    matchList.add(book.getValue()); // Adds the book from the HashMap to the List
                }
            }
            if(matchList.isEmpty()){
                System.out.println("\nNo matches found.");
            }
        }while(matchList.isEmpty());
        Menu.showBookList(matchList); // Prints the list
        return matchList.get(InputController.getOption(1, matchList.size())-1); // -1 because the first option is 1 but the first index is 0 
    }
    
    public static Book matchBooksByAuthor(){
        ArrayList<Book> matchList = new ArrayList<>();
        do{
            System.out.print("\nPlease input a piece of the book author's name (case sensitive): ");
            String author = InputController.getString(); // Get a name or piece of name as string from the user
            for (HashMap.Entry<String, Book> book : books.entrySet()) { // Runs through the books HashMap
                if(book.getValue().getAuthorName().contains(author)){ // If the book's title contains the input
                    matchList.add(book.getValue()); // Adds the book from the HashMap to the List
                }
            }
            if(matchList.isEmpty()){
                System.out.println("\nNo matches found.");
            }
        }while(matchList.isEmpty());
        Menu.showBookList(matchList); // Prints the list
        return matchList.get(InputController.getOption(1, matchList.size())-1); // -1 because the first option is 1 but the first index is 0 
    }
    
    public static Book getBook(String id) {
        return books.get(id);
    }
    
    public static Book[] getBooksArray() {
        
        Book[] booksArray = books.values().toArray(new Book[0]);
        return  booksArray;
    }
}
