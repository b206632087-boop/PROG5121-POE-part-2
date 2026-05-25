/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package student.registration;

import java.util.Scanner;
import java.util.HashMap;
/**
 *
 * @author b2066
 */
public class Registration {

    public static HashMap<String, String>users =new HashMap<>();
    
    public static String currentFirstname = "";
    public static String currentLastname ="";
    
    public static void main (String[] args ) {
      
        Scanner myInput = new Scanner(System.in);    
        
        //declarations
        String username = null;
        String password = null;
        String cellphonenumber;
        boolean isValid =false; 
       
        
      //prompting the user
      System.out.println("Enter firstname");
      String Firstname =myInput.nextLine();
      System.out.println("lastname ");
      String Lastname = myInput.nextLine();
      
      
      
        //Registration
        while(!isValid) {
        System.out.println("enter username");
        System.out.println("username must contain an underscore and is no more than  five characters long");
        username = myInput.nextLine(); 
        
        if(username.contains("_") &&
           username.length() <= 5){
           isValid = true;
           System.out.println("username successfully captured");
    }else{
            System.out.println("username is not correctly formatted please ensure that your username contains underscore and is no more than five characters in length");
                    }
    }
       isValid = false;     
       
    while(!isValid) {
        System.out.println("enter a password");
        System.out.println(" please ensure that the password contains atleast eight acters ,a capital letter,a number and a special character");
        password = myInput.nextLine();
        
        if(password.length() >=8 &&
           password.matches(".*[0-9]*") &&
           password.matches(".*[A-Z].*") &&
           password.matches(".*[!@#$%^&*()].*")){
           isValid = true;
        System.out.println("password successfully captured");
    }else{
            System.out.println("password is not correctly formatted please ensure that the password contains atleast eight acters ,a capital letter,a number and a special character");
        }
      }
    
     String regex = "\\+27\\d{9}"; 
    isValid = false;
  
    while(!isValid ) {
    System.out.println("enter cellphone number");
    System.out.println("cellphone number should contain international code +27");
    cellphonenumber = myInput.nextLine();
    
        if(cellphonenumber.matches(regex) && cellphonenumber.contains("+27")) {
            isValid =true;
           System.out.println("cellphone number successfully captured");
        }else{
            System.out.println("cellphone number incorrectly formatted or does not contain international code ");
        
        
        }
    }
    users.put(username,password);
    currentFirstname = Firstname;
    currentLastname = Lastname;
    
    System.out.println("Registration successful");
    
    
    login.loginUser();
    }
}  
