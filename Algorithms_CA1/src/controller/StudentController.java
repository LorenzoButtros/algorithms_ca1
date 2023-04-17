package controller;

import java.util.HashMap;
import model.Student;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class StudentController {
    
    HashMap<Integer,Student> students; // Using id as keys
    
    public void createStudentList(){
        for (int i = 0; i < 100; i++) {
            Student newStudent = new Student();
            students.put(newStudent.getId(), newStudent);
        }
    }
    
}
