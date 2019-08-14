package com.ralmeida;

import java.util.ArrayList;

public class ContactsList {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void printContactsList(){

        System.out.println("You have " + contacts.size() + " contacts:");
        for (int i=0; i < contacts.size(); i++){
            System.out.println("Contact #" + (i+1));
            System.out.println("Name: " + contacts.get(i).getName());
            System.out.println("Phone: " + contacts.get(i).getPhoneNumber());
        }
    }

    public void addContact(Contact contact){
        if (isInList(contact.getName())){
            System.out.println("Contact " + contact.getName() + " already exist.");
        } else {
            contacts.add(contact);
            System.out.println("Contact " + contact.getName() + " has been added to list.");
        }
    }

    public void removeContact(Contact contact){
        contacts.remove(contact);
    }

    public void modifyContact(Contact oldContact, Contact newContact){
        contacts.set(contacts.indexOf(oldContact), newContact);
    }

    public Contact searchContactByName(String name){
        int index = findContact(name);
        if (index >= 0){
            return contacts.get(index);
        } else {
            return null;
        }
    }

    private int findContact(String name){
        int index = -1;
        for (Contact contact : contacts){
            if (name.equals(contact.getName())){
                index = contacts.indexOf(contact);
                return index;
            }
        }
        return index;
    }

    private boolean isInList(String name){
        int position = findContact(name);
        if (position >= 0){
            return true;
        } else {
            return false;
        }
    }
}
