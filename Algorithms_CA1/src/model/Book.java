package model;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Book {
    private String id, title, authorName, genres;
    //ArrayList<String> genres;

    public Book(String id, String authorFName, String authorLName, String title, String genres) {
        this.id = id;
        this.authorName = authorLName + ", " + authorFName;
        //this.authorFName = authorFName;
        //this.authorLName = authorLName;
        this.title = title;
        this.genres = genres;
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
    
    /*
    public String getAuthorFName() {
        return authorFName;
    }

    public String getAuthorLName() {
        return authorLName;
    }
    */

    public String getGenres() {
        return genres;
    }
    
    //public ArrayList<String> getGenres() {
    //    return genres;
    //}


}
