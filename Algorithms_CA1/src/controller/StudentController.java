package controller;

import java.util.HashMap;
import model.Student;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class StudentController {
    
    private static HashMap<Integer,Student> students = new HashMap<>(); // Using id as keys
    
    public static void createStudentList(){
        for (int i = 0; i < 100; i++) {
            Student newStudent = new Student();
            students.put(newStudent.getId(), newStudent);
        }
    }
    
    public static int checkStudentId(){
        int id=0;
        boolean valid = false;
        while(!valid){ // Will never be true
            id = InputController.getInt();
            if(students.containsKey(id)){
                return id;
            }else{
                System.out.print("\nStudent not found, please input another id: ");
            }
        }
        return id; // Will never reach here
    }

    public static Student getStudent(int id) {
        return students.get(id);
    }

    public static Student[] getStudentsArray() {
        
        Student[] studentsArray = students.values().toArray(new Student[0]);
        return  studentsArray;
    }
    
}
