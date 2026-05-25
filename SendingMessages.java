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

public class SendingMessages {

    // Message counter
    static int messageCount = 0;

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

                System.out.print("Choose option: ");
                choice = myInput.nextInt();
                myInput.nextLine();

                switch (choice) {

                    case 1:
                        sendMessages(totalMessages);
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        System.out.println("Goodbye!");
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
        System.out.println("Message successfully sent.");
        break;

    case 2:
        System.out.println("Message disregarded.");
        break;

    case 3:
        System.out.println("Message stored successfully.");
        break;

    default:
        System.out.println("Invalid option.");
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
   }  


