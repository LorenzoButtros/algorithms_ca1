package model;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Book {
    String id, title, authorFName, authorLName;
    ArrayList<String> genres;

    public Book(String id, String authorFName, String authorLName, String title, ArrayList<String> genres) {
        this.id = id;
        this.authorFName = authorFName;
        this.authorLName = authorLName;
        this.title = title;
        this.genres = genres;
    }
}
