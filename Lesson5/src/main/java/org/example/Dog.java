package org.example;

class Dog extends Animal {
    static int numberOfDogs = 0;
    Dog(String name)
    {
        super(name);
        ++numberOfDogs;
    }

    @Override
    void run(int dist)
    {
        if (dist <= 500)
        {
            super.run(dist);
        }
        else
        {
            System.out.println("Данное действие невозможно.");
        }
    }

    @Override
    void swim(int dist)
    {
        if (dist <= 10)
        {
            super.swim(dist);
        }
        else
        {
            System.out.println("Данное действие невозможно.");
        }
    }
}