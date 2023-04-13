package controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import model.Book;

/**
 *
 * @author lmbut
 */
public class BookController {
    
    private static Scanner scanner;
    private static HashMap<String,Book> books; // Using id as keys
    
    public static void createBookList(){
        try {
            scanner = new Scanner(new FileReader("src/controller/MOCK_DATA.csv")); // Look for the file in the Controller package folder
            while(scanner.hasNext()){ // Will run until there is nothing left to read
                try {
                    String[] read = scanner.nextLine().split(",");
                    String id = read[0];
                    String firstName = read[1];
                    String lastName = read[2];
                    String title = read[3];
                    String[] genres = read[4].split(" | ");
                    ArrayList genresList = new ArrayList<>(Arrays.asList(genres));
                    books.put(id, new Book(id, firstName, lastName, title, genresList));
                }catch(Exception e){
                    System.out.println("READING ERROR");
                }
            }
            System.out.println("File reading complete.");
        } catch (Exception e) {
        }
    }
    
}
