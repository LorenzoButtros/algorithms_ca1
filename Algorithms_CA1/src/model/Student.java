package model;

import controller.StudentRandomData;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Student {
    int id;
    String name, address, mobile;
    static int currId = 100;
    
    public Student() {
        id = createId();
        name = StudentRandomData.getRandomStreetName();
        mobile = StudentRandomData.getRandomMobile();
        address = StudentRandomData.getRandomStreetName();
    }
    
    private int createId(){
        currId++;
        return currId;
    } 

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }
    
    
}
