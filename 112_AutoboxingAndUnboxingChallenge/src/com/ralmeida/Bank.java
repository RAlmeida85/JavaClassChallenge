package com.ralmeida;

import java.util.ArrayList;

public class Bank {

    // It should have an arraylist of Branches

    // Bank:
    // Add a new branch
    // Add a customer to that branch with initial transaction
    // Add a transaction for an existing customer for that branch
    // Show a list of customers for a particular branch and optionally a list
    // of their transactions
    // Demonstration autoboxing and unboxing in your code

    private ArrayList<Branch> branches = new ArrayList<Branch>();

    public void addBranch(String name){

        for (Branch b: branches){
            if (b.getName().equals(name)){
                System.out.println("Branch " + name + " already exists.");
                return;
            }
        }
        branches.add(new Branch(name));
        System.out.println("Branch " + name + " has been added.");
    }

    public void addCustomerToBranch(String branchName, String customerName, double initialAmount){
        int result = -1;
        for (Branch b: branches){
            if (b.getName().equals(branchName)){
                result = b.addCustomer(customerName, initialAmount);
            }
        }
        if (result < 0){
            System.out.println("Error to add customer " + customerName + " to branch " + branchName);
        } else {
            System.out.println("Customer " + customerName + " was added to branch " + branchName);
        }
    }

    public void addTransaction(String branchName, String customerName, double amount){

        Branch branch = getBranch(branchName);
        if (branch == null){
            System.out.println("Branch " + branchName + " does not exist");
            return;
        }

        for (Customer c : branch.getCustomers()){
            if (c.getName().equals(customerName)){
                c.addTransaction(amount);
                System.out.println("Transaction of " + amount + " added to Customer " + customerName + " on Branch " + branchName);
                return;
            }
        }

        System.out.println("Erro to add transaction");
    }

    public void printListofCustomerByBranch(String branchName){
        Branch branch = getBranch(branchName);
        if (branch == null){
            System.out.println("Branch "+ branchName +" does not exist");
        } else {
            System.out.println("Printing list of customers for Branch " + branchName);
            branch.printListOfCustomer();
        }
    }

    private Branch getBranch (String name){
        for (Branch b: branches){
            if (b.getName().equals(name)){
                return b;
            }
        }
        return null;
    }

}
