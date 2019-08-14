package com.ralmeida;

import java.util.Scanner;

public class MobilePhone {

    private static ContactsList contactsList = new ContactsList();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean quit = false;
        int option = 0;
        displayMenu();

        while(!quit){
            System.out.println("Enter an option: (from 0-6)");
            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1: // print list of contacts
                    contactsList.printContactsList();
                    break;
                case 2: // Add new contact
                    addContact();
                    break;
                case 3: // update existing contact
                    modifyContact();
                    break;
                case 4: // remove contact
                    removeContact();
                    break;
                case 5: // search / find contact
                    searchContact();
                    break;
                case 6: // list of options
                    displayMenu();
                    break;
                case 0:
                    System.out.println("Closing app. Thanks!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }


    public static void addContact(){
        System.out.println("Enter Contact Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        contactsList.addContact(new Contact(name, phoneNumber));
    }


    public static void modifyContact(){
        System.out.println("Enter name to modify: ");
        String name = scanner.nextLine();
        Contact contact = contactsList.searchContactByName(name);
        if (contact == null){
            System.out.println("Contact " + name + " not found!");
        } else {
            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();
            Contact newContact = new Contact(newName, phoneNumber);
            contactsList.modifyContact(contact, newContact);
            System.out.println("Contact " + name + " has been modified!");
        }
    }


    public static void removeContact(){
        System.out.println("Enter name to remove: ");
        String name = scanner.nextLine();
        Contact contact = contactsList.searchContactByName(name);
        if (contact == null){
            System.out.println("Contact " + name + " not found!");
        } else {
            contactsList.removeContact(contact);
            System.out.println("Contact " + name + " has been removed!");
        }
    }

    public static void searchContact(){
        System.out.println("Enter name to search: ");
        String name = scanner.nextLine();
        Contact contact = contactsList.searchContactByName(name);
        if (contact == null){
            System.out.println("Contact " + name + " not found!");
        } else {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone: " + contact.getPhoneNumber());
        }
    }

    public static void displayMenu(){
        System.out.println("\nPress: ");
        System.out.println("\t 1 - Print list of contacts.");
        System.out.println("\t 2 - Add new contact.");
        System.out.println("\t 3 - Update existing contact.");
        System.out.println("\t 4 - Remove contact.");
        System.out.println("\t 5 - Search/find contact.");
        System.out.println("\t 6 - List of options.");
        System.out.println("\t 0 - Quit.");
    }
}
