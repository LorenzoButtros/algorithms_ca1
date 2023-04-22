package controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import model.Book;
import view.Menu;

/**
 *
 * @author lmbut
 */
public class BookController {
    
    private static Scanner scanner;
    private static HashMap<String,Book> books; // Using id as keys
    
    public static void createBookList(){
        books = new HashMap<>();
        try {
            scanner = new Scanner(new FileReader("src/controller/MOCK_DATA.csv")); // Look for the file in the Controller package folder
            while(scanner.hasNext()){ // Will run until there is nothing left to read
                try {
                    String[] read = scanner.nextLine().split(",");
                    String id = read[0];
                    String firstName = read[1];
                    String lastName = read[2];
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
                    //String[] genres = read[4].split(" | ");
                    //ArrayList genresList = new ArrayList<>(Arrays.asList(genres));
                    books.put(id, new Book(id, firstName, lastName, title, genres));
                    //System.out.println(title + " ADDED");
                }catch(Exception e){
                    System.out.println("MOCK_DATA.csv - READING ERROR");
                }
            }
            System.out.println("MOCK_DATA.csv - File reading complete.");
        } catch (Exception e) {
            System.out.println("MOCK_DATA.csv - BOOK CREATION ERROR");
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
