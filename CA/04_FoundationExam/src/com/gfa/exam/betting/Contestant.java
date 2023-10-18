package com.gfa.exam.betting;

public class Contestant implements Comparable<Contestant> {
    private String name;
    private int placement = 0;

    public Contestant(String name) {
        this.name = name;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        if (placement >= 0) {
            this.placement = placement;
        }
    }

    @Override
    public String toString() {
        return name + " has finished on place: " + placement;
    }

    @Override
    public int compareTo(Contestant other) {
        return this.getPlacement() - other.getPlacement();
    }
}
