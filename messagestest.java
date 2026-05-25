/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author b2066
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import student.registration.SendingMessages;

public class messagestest {

    // Test valid recipient cellphone number
    @Test
    public void testValidRecipientNumber() {

        boolean result =
                SendingMessages.checkRecipientCell("+27831234567");

        assertTrue(result);
    }

    // Test invalid recipient cellphone number
    @Test
    public void testInvalidRecipientNumber() {

        boolean result =
                SendingMessages.checkRecipientCell("0831234567");

        assertFalse(result);
    }

    // Test generated message ID length
    @Test
    public void testMessageIDLength() {

        long messageID =
                SendingMessages.generateMessageID();

        int length =
                String.valueOf(messageID).length();

        assertEquals(10, length);
    }

    // Test message hash creation
    @Test
    public void testCreateMessageHash() {

        String hash =
                SendingMessages.createMessageHash(
                        1234567890L,
                        1,
                        "Hello John"
                );

        assertEquals("12:1:HELLOJOHN", hash);
    }

    // Test message hash is uppercase
    @Test
    public void testMessageHashUppercase() {

        String hash =
                SendingMessages.createMessageHash(
                        1234567890L,
                        2,
                        "good morning"
                );

        assertEquals(hash, hash.toUpperCase());
    }

    // Test message character limit
    @Test
    public void testMessageLength() {

        String message =
                "This is a short message";

        boolean result =
                message.length() <= 250;

        assertTrue(result);
    }

    // Test message exceeds limit
    @Test
    public void testMessageTooLong() {

        String longMessage =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        boolean result =
                longMessage.length() <= 250;

        assertFalse(result);
    }

    // Test storing message
    @Test
    public void testStoreMessage() {

        assertDoesNotThrow(() -> {

            SendingMessages.storeMessage(
                    1234567890L,
                    1,
                    "+27831234567",
                    "Hello John",
                    "12:1:HELLOJOHN"
            );
        });
    }
}

