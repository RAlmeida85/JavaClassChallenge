package com.ralmeida;

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        String phoneNumberFormatted = phoneNumber.replaceAll("[^\\d.]", "");
        this.phoneNumber = phoneNumberFormatted;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
