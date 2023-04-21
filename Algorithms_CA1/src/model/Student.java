package model;

import controller.StudentRandomData;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Student {
    
    private int id;
    private String name, address, mobile;
    private static int currId = 1000;
    
    public Student() {
        id = createId();
        name = StudentRandomData.getRandomStudentName();
        mobile = StudentRandomData.getRandomMobile();
        address = StudentRandomData.getRandomStreetName();
    }
    
    public void printStudent() {
        System.out.println("\nId: " + id + "\nName: " + name + "\nMobile: " 
                + mobile + "\nAddress: " + address);
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
