package org.example;

class Cat extends Animal {
    static int numberOfCats = 0;
    private boolean satiety = false;

    Cat(String name) {
        super(name);
        ++numberOfCats;
    }

    @Override
    void run(int dist) {
        if (dist <= 200) {
            super.run(dist);
        } else {
            System.out.println("Данное действие невозможно.");
        }
    }

    @Override
    void swim(int dist) {
        System.out.printf("%s не умеет плавать.\n", getName());
    }

    void eat(int food, Bowl bowl) {
        if (food <= bowl.getFood()) {
            satiety = true;
            bowl.setFood(bowl.getFood() - food);
        }
    }

    public void getSatiety() {
        if (satiety) {
            System.out.printf("%s сыт(а)\n", getName());
        } else {
            System.out.printf("%s голоден(дна)\n", getName());
        }
    }
}