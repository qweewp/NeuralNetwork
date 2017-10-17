package com.epam;

public class Neuron {

    private int weight;

    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void decreaseWeight() {
        this.weight = weight - 1;
    }

    public void increaseWeight() {
        this.weight = weight + 1;
    }

    @Override
    public String toString() {
        return "[" + weight + "]";
    }
}
