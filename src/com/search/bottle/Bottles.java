package com.search.bottle;

public class Bottles {

    private int bottleA;
    private int bottleB;

    public Bottles(int bottleA, int bottleB) {
        this.bottleA = bottleA;
        this.bottleB = bottleB;
    }

    public int getHValue() {
        return Math.abs((bottleA + bottleB) - 2);
    }

    public int getBottleA() {
        return bottleA;
    }

    public int getBottleB() {
        return bottleB;
    }

    public int getCapacityA() {
        return 4;
    }

    public int getCapacityB() {
        return 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bottles bottles)) return false;
        return bottleA == bottles.bottleA && bottleB == bottles.bottleB;
    }

    @Override
    public String toString() {
        return "bottleA=" + bottleA + ", bottleB=" + bottleB;
    }

    public void setBottleA(int value) {
        bottleA = value;
    }

    public void setBottleB(int value) {
        bottleB = value;
    }
}

