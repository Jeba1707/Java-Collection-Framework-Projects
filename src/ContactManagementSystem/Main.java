package ContactManagementSystem;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ContactManager contactManager = new ContactManager("E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\ContactManagementSystem\\contact.ser");

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println("Welcome to the Contact Manager!");
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        } while (choice != 6);
    }

    public static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contactManager.addContact(contact);
    }

    public static void viewContacts() {
        contactManager.viewContacts();
    }

    public static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        contactManager.searchContact(name);
    }

    public static void updateContact() {
        System.out.print("Enter name to update: ");
        String name = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        contactManager.updateContact(name, phoneNumber, email);
    }

    public static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        contactManager.deleteContact(name);
    }
}
