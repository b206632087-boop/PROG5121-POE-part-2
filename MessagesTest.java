
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import student.registration.SendingMessages;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author b2066
 */


public class MessagesTest {

    @Test
    public void testCheckRecipientCell_Valid() {

        assertTrue(
            SendingMessages.checkRecipientCell("+27831234567")
        );
    }

    @Test
    public void testCheckRecipientCell_Invalid() {

        assertFalse(
            SendingMessages.checkRecipientCell("0831234567")
        );
    }

    @Test
    public void testGenerateMessageID() {

        long id = SendingMessages.generateMessageID();

        assertTrue(id >= 1000000000L);
        assertTrue(id <= 9999999999L);
    }

    @Test
    public void testCreateMessageHash() {

        String hash =
            SendingMessages.createMessageHash(
                    1234567890L,
                    1,
                    "Hello World"
            );

        assertEquals(
                "12:1:HELLOWORLD",
                hash
        );
    }

    @Test
    public void testSentMessagesArray() {

        SendingMessages.sentMessages.clear();

        SendingMessages.sentMessages.add(
                "Test Message"
        );

        assertEquals(
                1,
                SendingMessages.sentMessages.size()
        );
    }

    @Test
    public void testStoredMessagesArray() {

        SendingMessages.storedMessages.clear();

        SendingMessages.storedMessages.add(
                "Stored Message"
        );

        assertEquals(
                "Stored Message",
                SendingMessages.storedMessages.get(0)
        );
    }

    @Test
    public void testDisregardedMessagesArray() {

        SendingMessages.disregardedMessages.clear();

        SendingMessages.disregardedMessages.add(
                "Ignored Message"
        );

        assertEquals(
                1,
                SendingMessages.disregardedMessages.size()
        );
    }

    @Test
    public void testMessageHashStored() {

        SendingMessages.messageHashes.clear();

        SendingMessages.messageHashes.add(
                "12:1:HELLOWORLD"
        );

        assertEquals(
                "12:1:HELLOWORLD",
                SendingMessages.messageHashes.get(0)
        );
    }
}



