package com.ralmeida;

public class HealthyBurger extends Hamburger{

    private Additional whiteCheese, arugula, ham;

    public HealthyBurger(String meat, double basePrice) {
        super("Healthy", "Brown rye", meat, basePrice);
        this.whiteCheese = new Additional("White Chesse", 2);
        this.arugula = new Additional("Arugula", 1);
        this.ham = new Additional("Ham", 2);
        setTotalAdditionalAccepted(6);
    }

    @Override
    public void listAdditions() {
        super.listAdditions();
        if (whiteCheese.isIncluded()){
            whiteCheese.printPrice();
        }
        if (arugula.isIncluded()){
            arugula.printPrice();
        }
        if (ham.isIncluded()){
            ham.printPrice();
        }
    }

    public Additional getWhiteCheese() {
        return whiteCheese;
    }

    public Additional getArugula() {
        return arugula;
    }

    public Additional getHam() {
        return ham;
    }
}
