package ContactManagementSystem;

import java.util.TreeSet;
import java.io.*;
import java.util.*;
public class ContactManager {

    private TreeSet<Contact> contacts ;
    private String fileName;

    public ContactManager(String fileName) {
        this.contacts = new TreeSet<>();
        this.fileName = fileName;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveContactsToFile();
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        loadContactsFromFile();
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found:");
                System.out.println(contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void updateContact(String name, String phoneNumber, String email) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setNumber(phoneNumber);
                contact.setEmail(email);
                saveContactsToFile();
                System.out.println("Contact updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        Iterator<Contact> iterator = contacts.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                saveContactsToFile();
                System.out.println("Contact deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private void saveContactsToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Error saving contacts to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadContactsFromFile() {
        File file = new File(fileName);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                contacts = (TreeSet<Contact>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading contacts from file: " + e.getMessage());
            }
        }
    }
}
