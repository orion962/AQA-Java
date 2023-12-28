package org.example;

class Animal {
    private String name;
    static int numberOfAnimals = 0;

    Animal(String name) {
        this.name = name;
        ++numberOfAnimals;
    }

    void run(int dist) {
        System.out.printf("%s пробежал(а) %d метров.\n", name, dist);
    }

    void swim(int dist) {
        System.out.printf("%s проплыл(а) %d метров.\n", name, dist);
    }

    public String getName() {
        return name;
    }
}
