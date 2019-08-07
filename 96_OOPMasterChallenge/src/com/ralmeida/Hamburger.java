package com.ralmeida;

public class Hamburger {

    private String name;
    private String breadRollType;
    private String meat;
    private double basePrice;
    private double totalPrice;
    private int additionalQtd;
    private int totalAdditionalAccepted;
    private Additional lettuce, tomato, carrot, bacon, cheese, extraBurger, pepper;

    public Hamburger(String name, String breadRollType, String meat, double basePrice) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.basePrice = basePrice;
        this.totalPrice = basePrice;
        this.additionalQtd = 0;
        this.totalAdditionalAccepted = 4;
        lettuce = new Additional("Lettuce", 1);
        tomato = new Additional("Tomato", 1);
        carrot = new Additional("Carrot", 1);
        bacon = new Additional("Bacon", 2);
        cheese = new Additional("Cheese", 1);
        extraBurger = new Additional("Extra Burger", 3);
        pepper = new Additional("Pepper", 1);
    }

    public void addAdditional(Additional additional) {
        if (additionalQtd < totalAdditionalAccepted) {
            if (!additional.isIncluded()) {
                this.totalPrice += additional.add();
                additionalQtd++;
                System.out.println(additional.getName() + " has been added.");
            } else {
                System.out.println(additional.getName() + " already included.");
            }
        } else {
            System.out.println("Could not add " + additional.getName() + ". Burger reached total of additions: " + totalAdditionalAccepted);
        }
    }

    public void checkPrice(){
        System.out.printf(name + " Burger - Base price: $%.2f\n", basePrice);
        this.listAdditions();
        System.out.printf("Total price: $%.2f\n\n", this.totalPrice);
    }

    public void listAdditions() {
        if (lettuce.isIncluded()) {
            lettuce.printPrice();
        }
        if (tomato.isIncluded()) {
            tomato.printPrice();
        }
        if (carrot.isIncluded()){
            carrot.printPrice();
        }
        if (bacon.isIncluded()){
            bacon.printPrice();
        }
        if (cheese.isIncluded()){
            cheese.printPrice();
        }
        if (extraBurger.isIncluded()){
            extraBurger.printPrice();
        }
        if (pepper.isIncluded()){
            pepper.printPrice();
        }
    }

    public void setTotalAdditionalAccepted(int totalAdditionalAccepted) {
        this.totalAdditionalAccepted = totalAdditionalAccepted;
    }

    public String getName() {
        return name;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getAdditionalQtd() {
        return additionalQtd;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Additional getLettuce() {
        return lettuce;
    }

    public Additional getTomato() {
        return tomato;
    }

    public Additional getCarrot() {
        return carrot;
    }

    public Additional getBacon() {
        return bacon;
    }

    public Additional getCheese() {
        return cheese;
    }

    public Additional getExtraBurger() {
        return extraBurger;
    }

    public Additional getPepper() {
        return pepper;
    }
}
