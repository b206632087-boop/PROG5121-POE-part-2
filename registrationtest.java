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
public class registrationtest {
    
    public registrationtest() {
    }

    

 

    // Test valid username
    @Test
    public void testValidUsername() {

        String username = "ab_cd";

        boolean result =
                username.contains("_") &&
                username.length() <= 5;

        assertTrue(result);
    }

    // Test invalid username
    @Test
    public void testInvalidUsername() {

        String username = "abcdef";

        boolean result =
                username.contains("_") &&
                username.length() <= 5;

        assertFalse(result);
    }

    // Test valid password
    @Test
    public void testValidPassword() {

        String password = "Pass@123";

        boolean result =
                password.length() >= 8 &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[!@#$%^&*()].*");

        assertTrue(result);
    }

    // Test invalid password
    @Test
    public void testInvalidPassword() {

        String password = "password";

        boolean result =
                password.length() >= 8 &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[!@#$%^&*()].*");

        assertFalse(result);
    }

    // Test valid cellphone number
    @Test
    public void testValidCellphoneNumber() {

        String regex = "\\+27\\d{9}";
        String cellphone = "+27831234567";

        boolean result =
                cellphone.matches(regex) &&
                cellphone.contains("+27");

        assertTrue(result);
    }

    // Test invalid cellphone number
    @Test
    public void testInvalidCellphoneNumber() {

        String regex = "\\+27\\d{9}";
        String cellphone = "0831234567";

        boolean result =
                cellphone.matches(regex) &&
                cellphone.contains("+27");

        assertFalse(result);
    }

    // Test storing user in HashMap
    @Test
    public void testUserStored() {

        Registration.users.put("ab_cd", "Pass@123");

        String storedPassword =
                Registration.users.get("ab_cd");

        assertEquals("Pass@123", storedPassword);
    }

    // Test firstname and lastname storage
    @Test
    public void testCurrentUserNames() {

        Registration.currentFirstname = "Bradley";
        Registration.currentLastname = "Bokamoso";

        assertEquals("Bradley",
                Registration.currentFirstname);

        assertEquals("Bokamoso",
                Registration.currentLastname);
    }
}
