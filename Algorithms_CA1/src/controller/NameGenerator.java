package controller;
import java.util.Random;

/**
 *
 * @author Lorenzo Buttros - 2022357
 */
public class NameGenerator {

    
    // Creates an array with 30 common first names
    private static String[] firstNames = {"Liam","Noah","Oliver","Elijah","James","William","Benjamin","Lucas","Henry","Theodore","Jack","Levi","Alexander","Jackson","Mateo","Olivia","Emma","Charlotte","Amelia","Ava","Sophia","Isabella","Mia","Evelyn","Harper","Luna","Camila","Gianna","Elizabeth","Eleanor"};

    // Creates an array with 30 common surnames
    private static String[] surnames = {"Smith","Johnson","Willians","Brown","Jones","Garcia","Miller","Davis","Rodriguez","Martinez","Hernandez","Lopez","Gonzalez","Wilson","Anderson","Thomas","Taylor","Moore","Jackson","Martin","Lee","Perez","Thompson","White","Harris","Sanchez","Clark","Ramirez","Lewis","Robinson"};
    
    // Empty constructor
    public NameGenerator() {
    }

    // Method that builds and returns a random name using the arrays
    // It is static so NameGenerator doesn't have to be instantiated
    public static String getRandomName() {

        Random r = new Random();

        // Pick a firstname and surname based on the length of the arrays
        String firstName = NameGenerator.firstNames[r.nextInt(firstNames.length)];
        String surName = NameGenerator.surnames[r.nextInt(surnames.length)];

        return ( firstName + " " + surName);
    }
}
