package controller;

import java.util.ArrayList;

/**
 *
 * @author lmbut
 */
public class MenuController {
    
    /*
    // Method that builds and prints the "list staff by category" menu
    public static void showCategoryMenu(){
        
        ArrayList categoryMenu = new ArrayList<String>();
        
        categoryMenu.add("List staff by category"); // Header
        // Adds each club staff type to the list
        for (ClubStaffTitle cst : ClubStaffTitle.values()) {
            
            categoryMenu.add(cst.toString());
        }
        
        // Adds each coaching staff type to the list
        for (CoachingStaffTitle cst : CoachingStaffTitle.values()) {
            
            categoryMenu.add(cst.toString());
        }
        
        categoryMenu.add("Back to Main Menu");
        System.out.println(printMenu(categoryMenu));
    }
    
    // Method that builds and prints the "list group by day" menu
    public static void showDayMenu(){
        
        ArrayList dayMenu = new ArrayList<String>();
        
        dayMenu.add("List training groups by day");
        
        for(int i=0 ; i < TrainingDay.values().length ;i++){
            
            dayMenu.add(TrainingDay.values()[i].toString());
        }
        
        dayMenu.add("Back to Main Menu");
        System.out.println(printMenu(dayMenu));
    }
    
    // Method that builds and prints the "list players by group" menu. 
    // It receives the group list as a parameter
    public static void showGroupMenu(ArrayList<TrainingGroup> groupList){
        
        ArrayList groupMenu = new ArrayList<String>();
        
        groupMenu.add("List players by training group");
        
        for(int i=0 ; i < groupList.size() ;i++){
            
            groupMenu.add(groupList.get(i).getId());
        }
        
        groupMenu.add("Back to Main Menu");
        System.out.println(printMenu(groupMenu));
    }
    
    // Method that builds and prints the "list groups by coach" or "list players by coach" menu.
    // It receives the list of coaches and a boolean to know which header to print.
    public static void showCoachMenu(ArrayList<CoachingStaff> coachList, boolean listGroups){
        
        ArrayList coachMenu = new ArrayList<String>(); 
        
        if(listGroups){
            
            coachMenu.add("List groups by coach");
        }else{
            
            coachMenu.add("List players by coach");
        }
                
        for(int i=0 ; i < coachList.size() ;i++){
            
            coachMenu.add(coachList.get(i).getName());
        }
        
        coachMenu.add("Back to Main Menu");
        System.out.println(printMenu(coachMenu));
    }
    */
    // Method that receives an arraylist of options and builds a printable string
    public static String printMenu(ArrayList menuItems){
        
        // The header is the first item of the list
        String menu = "\n**** " + menuItems.get(0) + " **** \n"; 
        
        // i starts as 1 so the first option will be number 1. 0 was the header
        for (int i = 1; i < menuItems.size(); i++){ 
            
            menu = menu.concat("\n" + i +") " + menuItems.get(i)); // The option with its number
        }
        
        return menu;
    }
    
}
