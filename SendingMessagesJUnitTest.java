/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import student.registration.SendingMessages;

/**
 *
 * @author b2066
 */
public class SendingMessagesJUnitTest {


    @Test
    public void testValidRecipientNumber() {

        boolean result =
                SendingMessages.checkRecipientCell("+27831234567");

        assertTrue(result);
    }

    @Test
    public void testInvalidRecipientNumber() {

        boolean result =
                SendingMessages.checkRecipientCell("0831234567");

        assertFalse(result);
    }

    @Test
    public void testGenerateMessageID() {

        long id =
                SendingMessages.generateMessageID();

        assertTrue(id >= 1000000000L);
        assertTrue(id <= 9999999999L);
    }

    @Test
    public void testCreateMessageHash() {

        String expected =
                "12:1:HELLOWORLD";

        String actual =
                SendingMessages.createMessageHash(
                        1234567890L,
                        1,
                        "Hello World");

        assertEquals(expected, actual);
    }

    @Test
     public void testCreateMessageHashDifferentMessage() {

        String expected =
                "98:2:GOODBYEFRIEND";

        String actual =
                SendingMessages.createMessageHash(
                        9876543210L,
                        2,
                        "Goodbye Friend");

        assertEquals(expected, actual);
    }
}
    

  

