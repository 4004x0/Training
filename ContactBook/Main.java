import java.util.ArrayList;
import java.util.Scanner;

// Class representing a contact
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor to initialize contact details
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter methods for retrieving contact details
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods for updating contact details
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

// Class representing a contact book
class ContactBook {
    private ArrayList<Contact> contacts;

    // Constructor to initialize an empty contact book
    public ContactBook() {
        contacts = new ArrayList<>();
    }

    // Method to add a contact to the contact book
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Method to search for a contact by name
    public void searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found:");
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Method to update a contact's phone number and email
    public void updateContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter new email: ");
                String email = scanner.nextLine();
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Method to delete a contact
    public void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Contact Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber, email);
                    contactBook.addContact(contact);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    contactBook.searchContact(searchName);
                    break;
                case 3:
                    System.out.print("Enter name to update: ");
                    String updateName = scanner.nextLine();
                    contactBook.updateContact(updateName);
                    break;
                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    contactBook.deleteContact(deleteName);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting Contact Book. Goodbye!");
    }
}
