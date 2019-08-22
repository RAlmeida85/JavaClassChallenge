package com.ralmeida;

import java.util.ArrayList;

public class Branch {

    // Branch:
    // Need to be able to add a new customer and initial transaction amount.
    // Also needs to add additional transactions for that customer/branch
    private String name;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public int addCustomer(String name, double initialAmount){
        for (Customer c : customers){
            if (c.getName().equals(name)){
                return -1;
            }
        }
        customers.add(new Customer(name, initialAmount));
        return customers.size();
    }

    public int addTransaction(String name, double amount){
        for (Customer c : customers){
            if (c.getName().equals(name)){
                c.addTransaction(amount);
                return customers.indexOf(c);
            }
        }
        return -1;
    }

    public void printListOfCustomer(){
        for (int i=0; i < customers.size(); i++){
            System.out.println((i+1) + " - " + customers.get(i).getName());
        }
    }

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
