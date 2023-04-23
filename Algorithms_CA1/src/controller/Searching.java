package controller;

import model.Student;

/**
 *
 * @author Lorenzo Buttros - 2022357
 * @author Paulo Puhl - 2022225
 */
public class Searching {
    
    public static Student searchStudent(Student[] array, int studentId) {
        
        //an implementation of the binary searching algorithm
        array = Sorting.studentSortById(array);
        int left = 0; //left isthe first position of the array
        int right = array.length-1; //right is the last position of the array
        int index = array.length/2; //index is the position in the middle of the array
        
        //while searching if the student ID requested is in the array
        while(right>=left){
            if(array[index].getId() == studentId){
                return array[index]; //student found
            }else if(array[index].getId() > studentId){ //go to the left side of the split
                right = index-1;
                index = left+(right-left)/2;
            }else{ //go to the right side of the split
                left = index+1;
                index = left+(right-left)/2; 
            }
        }
        return null;
    }
}
