/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.registration;

/**
 *
 * @author b2066
 */
import java.util.Scanner;
public class login {

  public static void loginUser(){
      Scanner myInput = new Scanner(System.in); 
      //declarations
      String inputUsername;
      String inputPassword;
        boolean isValid = false;

   while(!isValid) {
   System .out.println("****Login****");
    
   System.out.println("Enter your username");
   inputUsername = myInput.nextLine();
   System.out.println("Enter your password ");
   inputPassword =  myInput.nextLine();
   
   if(Registration.users.containsKey(inputUsername) &&
           Registration.users.get(inputUsername).equals(inputPassword)){
       
       
       System.out.println("Welcome " + Registration.currentFirstname +"  "+ Registration.currentLastname + "  " +"it is great to see you again.");
    isValid = true;
   }else{
       System.out.println("username or password incorrect please try again ");
         }
        }
   SendingMessages.sendmessages(); 
   } 
}

