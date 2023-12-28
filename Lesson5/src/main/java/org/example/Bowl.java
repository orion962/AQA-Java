package org.example;

class Bowl {
    private int food;

    Bowl(int food) {
        this.food = food;
    }

    void addFood(int num) {
        food += num;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int num) {
        food = num;
    }
}
