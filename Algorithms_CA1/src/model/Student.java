package model;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Student {
    int id, mobile;
    String name, address;

    public Student(int id, int mobile, String name, String address) {
        this.id = id;
        this.mobile = mobile;
        this.name = name;
        this.address = address;
    }
}
