package com.ralmeida;

public class Outlander extends Car {

    private int roadService;

    public Outlander(int roadService) {
        super("Outlander", 4, 4, 5, 6, false);
        this.roadService = roadService;
    }

}
