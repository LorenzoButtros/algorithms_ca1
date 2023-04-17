package controller;
import java.util.Random;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class StudentRandomData {

    
    // Creates an array with 30 common first names
    private static String[] firstNames = {"Liam","Noah","Oliver","Elijah","James","William","Benjamin","Lucas","Henry","Theodore","Jack","Levi","Alexander","Jackson","Mateo","Olivia","Emma","Charlotte","Amelia","Ava","Sophia","Isabella","Mia","Evelyn","Harper","Luna","Camila","Gianna","Elizabeth","Eleanor"};

    // Creates an array with 30 common surnames
    private static String[] surnames = {"Smith","Johnson","Willians","Brown","Jones","Garcia","Miller","Davis","Rodriguez","Martinez","Hernandez","Lopez","Gonzalez","Wilson","Anderson","Thomas","Taylor","Moore","Jackson","Martin","Lee","Perez","Thompson","White","Harris","Sanchez","Clark","Ramirez","Lewis","Robinson"};
    
    // Creates an array with 30 common first names
    private static String[] streetNames = {"Abbey", "Ailesbury", "Ameins", "Baggot", "Bayside", "Capel", "Clyde", "Crampton", "Dame", "Dorset", "Drumcondra", "Eccles", "Fleet", "Grafton", "Harcourt", "Herbert", "Howth", "Kildare", "Leeson", "Merrion", "Mountjoy", "Newbridge", "O'Connell", "Park", "Parliament", "Parnell", "Pearse", "Sandymount", "Stillorgan", "Talbot", "Westmoreland"};

    // Creates an array with 30 common surnames
    private static String[] streetTypes = {"Street","Avenue","Drive","Square","Road","Boulevard"};
    
    // Method that builds and returns a random student name using the arrays
    public static String getRandomStudentName() {

        Random r = new Random();

        // Pick a firstname and surname based on the length of the arrays
        String firstName = StudentRandomData.firstNames[r.nextInt(firstNames.length)];
        String surName = StudentRandomData.surnames[r.nextInt(surnames.length)];

        return ( firstName + " " + surName);
    }
    
    // Method that builds and returns a random street name using the arrays
    public static String getRandomStreetName() {

        Random r = new Random();

        // Pick a street name and street type based on the length of the arrays
        String streetName = StudentRandomData.firstNames[r.nextInt(firstNames.length)];
        String streetType = StudentRandomData.surnames[r.nextInt(surnames.length)];
        
        // Also adds a number
        return ( r.nextInt(180)+20 + streetName + " " + streetType);
    }
    
    // Method that cretes a random mobile number
    public static String getRandomMobile() {

        Random r = new Random();

        // Creates a random mobile number
        return 4+(Integer.toString(90)+10)+" "+Integer.toString(9000)+1000;
    }
}
