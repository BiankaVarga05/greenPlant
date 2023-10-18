package com.gfa.exam.pirates;

import java.util.*;

public class Pirate {
    private String name;
    protected int goldAmount = 0;
    protected int healthPoints = 20;
    private boolean hasWoodenLeg = false;

    public Pirate(String name) {
        this.name = name;
    }

    public void makeWoodenLeg() {
        hasWoodenLeg = true;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public String getName() {
        return name;
    }

    public boolean isPoor() {
        return hasWoodenLeg && goldAmount < 15;
    }

    public String toString() {
        return "Hello, I'm " + name + ". I " +
                (hasWoodenLeg ? "have a wooden leg" : "still have my real legs") +
                " and " + goldAmount + " amount of gold.";
    }

    public void work() {
        goldAmount++;
        healthPoints--;
    }

    public void party() {
        healthPoints++;
    }
}
