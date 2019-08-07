package com.ralmeida;

public class Additional {

    private String name;
    private double price;
    private boolean included = false;

    public Additional(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Additional(String name, double price, boolean included) {
        this.name = name;
        this.price = price;
        this.included = true;
    }

    public double add(){
        this.included = true;
        return this.price;
    }

    public void printPrice() {
        System.out.printf("Additional of " + this.name + ": $%.2f\n", this.price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isIncluded() {
        return included;
    }
}
