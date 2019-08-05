package com.ralmeida;

public class Printer {

    private int pagesPrinted = 0;
    private double tonerLevel = 100;
    private double toneCapacity;
    private boolean isDuplex;

    public Printer(double tonerLevel, double toneCapacity, boolean isDuplex) {
        if(tonerLevel > 0) {
            this.tonerLevel = tonerLevel;
        }
        this.toneCapacity = toneCapacity;
        this.isDuplex = isDuplex;
    }

    public void fillToner(double tonerQtd){
        if ((tonerQtd + this.tonerLevel) <= this.toneCapacity){
            this.tonerLevel += tonerQtd;
            System.out.println("Toner Level: " + this.tonerLevel + " (" + (this.tonerLevel * 100) / this.toneCapacity + "%)");
        }
    }

    public void printPage() {
        if(this.tonerLevel > 0) {
            this.pagesPrinted ++;
            System.out.println("Page printed - Total pages printed: " + this.pagesPrinted);
        } else {
            System.out.println("Insuficient toner.");
        }
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public boolean isDuplex() {
        return isDuplex;
    }
}
