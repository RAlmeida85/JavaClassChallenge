package com.ralmeida;

public class DeluxeBurger extends Hamburger {
    private Additional drink;
    private Additional chips;

    public DeluxeBurger(String breadRollType, String meat, double basePrice) {
        super("Deluxe", breadRollType, meat, basePrice);
        this.drink = new Additional("Drink", 0, true);
        this.chips = new Additional("Chips", 0, true);
    }

    @Override
    public void addAdditional(Additional additional) {
        System.out.println("Could not add " + additional.getName() + ". Deluxe Burger cannot be changed");
    }

    @Override
    public void listAdditions() {
        drink.printPrice();
        chips.printPrice();
    }
}
