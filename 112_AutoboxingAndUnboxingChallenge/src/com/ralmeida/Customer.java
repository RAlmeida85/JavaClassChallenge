package com.ralmeida;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactionsList = new ArrayList<>();

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.addTransaction(initialAmount);
    }

    public String getName() {
        return name;
    }

    public void addTransaction(Double amount){
        transactionsList.add(amount);
    }

    public ArrayList<Double> getTransactionsList() {
        return transactionsList;
    }
}
