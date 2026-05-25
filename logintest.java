/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import student.registration.Registration;

/**
 *
 * @author b2066
 */
public class logintest {
    
    public logintest() {
    }

    // Test successful login
    @Test
    public void testSuccessfulLogin() {

        // Add test user
        Registration.users.put("ab_cd", "Pass@123");

        // Simulated login details
        String username = "ab_cd";
        String password = "Pass@123";

        boolean result =
                Registration.users.containsKey(username) &&
                Registration.users.get(username).equals(password);

        assertTrue(result);
    }

    // Test failed login with wrong password
    @Test
    public void testFailedLoginWrongPassword() {

        // Add test user
        Registration.users.put("ab_cd", "Pass@123");

        String username = "ab_cd";
        String password = "wrongPass";

        boolean result =
                Registration.users.containsKey(username) &&
                Registration.users.get(username).equals(password);

        assertFalse(result);
    }

    // Test failed login with wrong username
    @Test
    public void testFailedLoginWrongUsername() {

        // Add test user
        Registration.users.put("ab_cd", "Pass@123");

        String username = "wrong_user";
        String password = "Pass@123";

        boolean result =
                Registration.users.containsKey(username) &&
                Registration.users.get(username).equals(password);

        assertFalse(result);
    }

    // Test firstname and lastname display values
    @Test
    public void testUserNamesStored() {

        Registration.currentFirstname = "Bradley";
        Registration.currentLastname = "Bokamoso";

        assertEquals("Bradley",
                Registration.currentFirstname);

        assertEquals("Bokamoso",
                Registration.currentLastname);
    }

    // Test user exists in HashMap
    @Test
    public void testUserExists() {

        Registration.users.put("ab_cd", "Pass@123");

        boolean result =
                Registration.users.containsKey("ab_cd");

        assertTrue(result);
    }
} 
  

