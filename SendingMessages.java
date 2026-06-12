 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package student.registration;
/**
 *
 * @author b2066
 */
import java.io.IOException;
import java.io.FileWriter; 
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class SendingMessages {

    // Message counter
    static int messageCount = 0;

public static ArrayList<String> sentMessages = new ArrayList<>();
public static ArrayList<String> disregardedMessages = new ArrayList<>();
public static ArrayList<String> storedMessages = new ArrayList<>();

public static ArrayList<String> messageHashes = new ArrayList<>();
public static ArrayList<String> messageIDs = new ArrayList<>();
public static ArrayList<String> recipients = new ArrayList<>();
    public static void sendmessages() {
        Scanner myInput = new Scanner(System.in);

            System.out.println("\nWelcome to QuickChat.");

            // Ask number of messages
            System.out.print("How many messages would you like to enter? ");
            int totalMessages = myInput.nextInt();
            myInput.nextLine();

            int choice;

            do {

            // Menu
            System.out.println("\n===== MENU =====");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.println("4. Stored Messages ");

                System.out.print("Choose option: ");
                choice = myInput.nextInt();
                myInput.nextLine();

                switch (choice) {

            case 1:
                        sendMessages(totalMessages);
                        break;

            case 2:

                if(sentMessages.isEmpty()) {

                    System.out.println("No messages have been sent.");

                } else {

                    System.out.println("\nRecently Sent Messages:");

                for(String msg : sentMessages) {

                    System.out.println(msg);
                        }
                    }

                break;
                        
                    

            case 3:
                    System.out.println("Goodbye!");
                        break;
                    
            case 4:
                    storedMessagesMenu();
                break;
            default:
                    System.out.println("Invalid option.");
                }

            } while (choice != 3);
    
    }
    // Send Messages Method
    public static void sendMessages(int totalMessages) {
      Scanner myInput = new Scanner(System.in);
        for (int i = 0; i < totalMessages; i++) {

            System.out.println("\n===== MESSAGE " + (i + 1) + " =====");

            // Generate Message ID
            long messageID = generateMessageID();

            // Increment message number
            messageCount++;

            // Recipient Number
            String recipient;

        do {
            System.out.print("Enter recipient cell number : ");
            recipient = myInput.nextLine();

        } while (!checkRecipientCell(recipient));

            // Message
            String message;

            do {
                System.out.print("Enter message (less than 250 characters): ");
                message = myInput.nextLine();

                if (message.length() > 250) {
                    System.out.println("Message exceeds 250 characters.");
                }

            } while (message.length() > 250);

            // Create Message Hash
            String messageHash = createMessageHash(messageID, messageCount, message);

            // Display message details
            System.out.println("\n===== MESSAGE DETAILS =====");
            System.out.println("Message ID: " + messageID);
            System.out.println("Message Number: " + messageCount);
            System.out.println("Recipient: " + recipient);
            System.out.println("Message: " + message);
            System.out.println("Message Hash: " + messageHash);

            // Options
            System.out.println("\n1. Send Message");
            System.out.println("2. Disregard Message");
            System.out.println("3. Store Message To Send Later");

            System.out.print("Choose option: ");
            int option = myInput.nextInt();
            myInput.nextLine();

            switch (option) {

    case 1:
        sentMessages.add(message);
        messageIDs.add(String.valueOf(messageID));
        messageHashes.add(messageHash);
        recipients.add(recipient);
        
        System.out.println("Message successfully sent.");
        break;

    case 2:
        disregardedMessages.add(message);
        
        System.out.println("Message disregarded.");
        break;

    case 3:
        storedMessages.add(message);
        
        messageIDs.add(String.valueOf(messageID));
        messageHashes.add(messageHash);
        recipients.add(recipient);
        
        storeMessage(messageID,messageCount
        ,recipient,message,messageHash);
        
        System.out.println("Message stored successfully.");
        break;
        
    default:
        System.out.println("invalid option");
            }
        }
    }

    // Validate Recipient Number
    public static boolean checkRecipientCell(String number) {

        if (number.length() <= 12 && number.startsWith("+")) {
            return true;
        } else {
            System.out.println("Cell number is incorrect.");
            return false;
        }
    }

    // Generate Random 10 Digit Message ID
    public static long generateMessageID() {

        Random random = new Random();

        long min = 1000000000L;
        long max = 9000000000L;

        return min + ((long) (random.nextDouble() * (max - min)));
    }

    // Create Message Hash
    public static String createMessageHash(long messageID,int messageNumber,String message) {

    String[] words = message.split(" "); 

    String firstWord = words[0];
    String lastWord = words[words.length - 1];

    String idPart = String.valueOf(messageID).substring(0, 2);

    String hash = idPart + ":" + messageNumber + ":" +firstWord + lastWord;

    return hash.toUpperCase();
    
    }
    
    public static void storeMessage(long messageID,
    int messageNumber,
    String recipient,
    String message,String messageHash) {
     Scanner myInput = new Scanner(System.in);
    try {

        FileWriter file = new FileWriter("messages.json", true);

        file.write("{\n");
        file.write("\"MessageID\": \"" + messageID + "\",\n");
        file.write("\"MessageNumber\": \"" + messageNumber + "\",\n");
        file.write("\"Recipient\": \"" + recipient + "\",\n");
        file.write("\"Message\": \"" + message + "\",\n");
        file.write("\"MessageHash\": \"" + messageHash + "\"\n");
        file.write("}\n");

        file.close();

        System.out.println("Message stored in JSON file.");

    } catch (IOException e) {

        System.out.println("Error writing to file.");
      }
    }
    
    public static void storedMessagesMenu() {
    
    Scanner myInput = new Scanner(System.in);
    int option;

    do {

        System.out.println("\n===== STORED MESSAGES =====");
        System.out.println("1. Display Sender And Recipient");
        System.out.println("2. Display Longest Message");
        System.out.println("3. Search Message ID");
        System.out.println("4. Search Recipient");
        System.out.println("5. Delete Message Using Hash");
        System.out.println("6. Full Report");
        System.out.println("7. Back");

        System.out.print("Choice: ");
        option = myInput.nextInt();
        myInput.nextLine();

        switch(option){

            case 1:
                displaySenderRecipient();
                break;

            case 2:
                displayLongestMessage();
                break;

            case 3:
                searchMessageID();
                break;

            case 4:
                searchRecipient();
                break;

            case 5:
                deleteMessageHash();
                break;

            case 6:
                fullReport();
                break;
        }

    } while(option != 7);
}
    public static void displayLongestMessage() {

    if(storedMessages.isEmpty()) {

        System.out.println("No stored messages.");
        return;
    }

    String longest = storedMessages.get(0);

    for(String msg : storedMessages) {

        if(msg.length() > longest.length()) {

            longest = msg;
        }
    }

    System.out.println("Longest Message:");
    System.out.println(longest);
}
    public static void searchMessageID() {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter Message ID: ");

    String id = input.nextLine();

    for(int i = 0; i < messageIDs.size(); i++) {

        if(messageIDs.get(i).equals(id)) {

            System.out.println("Recipient: "
                    + recipients.get(i));

            System.out.println("Message: "
                    + storedMessages.get(i));

            return;
        }
    }

    System.out.println("Message not found.");
}
    public static void displaySenderRecipient() {

    for(int i = 0; i < recipients.size(); i++) {

        System.out.println("Sender: User");
        System.out.println("Recipient: " + recipients.get(i));
        System.out.println();
    }
}
    public static void searchRecipient() {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter recipient: ");

    String recipient = input.nextLine();

    boolean found = false;

    for(int i = 0; i < recipients.size(); i++) {

        if(recipients.get(i).equals(recipient)) {

            System.out.println(storedMessages.get(i));

            found = true;
        }
    }

    if(!found) {

        System.out.println("No messages found.");
    }
}
    public static void deleteMessageHash() {

    Scanner input = new Scanner(System.in);

    System.out.print("Enter Message Hash: ");

    String hash = input.nextLine();

    for(int i = 0; i < messageHashes.size(); i++) {

        if(messageHashes.get(i).equals(hash)) {

            storedMessages.remove(i);
            messageHashes.remove(i);
            messageIDs.remove(i);
            recipients.remove(i);

            System.out.println("Message deleted.");

            return;
        }
    }

    System.out.println("Hash not found.");
}
    public static void fullReport() {

    System.out.println("\n===== STORED MESSAGE REPORT =====");

    for(int i = 0; i < storedMessages.size(); i++) {

        System.out.println("Message ID: "
                + messageIDs.get(i));

        System.out.println("Recipient: "
                + recipients.get(i));

        System.out.println("Message: "
                + storedMessages.get(i));

        System.out.println("Hash: "
                + messageHashes.get(i));

        System.out.println("-----------------------");
    }
}
}
     


