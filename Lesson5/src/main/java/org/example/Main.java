package org.example;

public class Main {
    public static void main(String[] args) {
        ////////////////////////////////////////////// задание 1
        Animal an1 = new Animal("Борис");
        Animal an2 = new Animal("Иннокентий");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Вурсик");
        Cat cat3 = new Cat("Мальвина");
        Dog dog1 = new Dog("Дружок");
        Dog dog2 = new Dog("Пирожок");
        ///////////////////////////////////////////////
        an1.run(125);
        an2.swim(20);
        cat1.run(135);
        cat2.swim(34);
        cat3.run(250);
        dog1.run(350);
        dog2.swim(12);
        ///////////////////////////////////////////////
        System.out.println(Animal.numberOfAnimals);
        System.out.println(Cat.numberOfCats);
        System.out.println(Dog.numberOfDogs);
        ///////////////////////////////////////////////
        Bowl bowl = new Bowl(100);
        Cat[] arr = {cat1, cat2, cat3};
        for (Cat cat : arr) {
            cat.eat(40, bowl);
            cat.getSatiety();
        }
        System.out.println(bowl.getFood());
        bowl.addFood(30);
        System.out.println(bowl.getFood());
        arr[2].eat(40, bowl);
        arr[2].getSatiety();
        /////////////////////////////////////////////// задание 2
        Circle circle = new Circle(2.5, "красный", "чёрный");
        Rectangle rect = new Rectangle(3.5, 4.9, "жёлтый", "синий");
        Triangle trg = new Triangle(3, 4, 5, "зелёный", "фиолетовый");
        circle.figureInfo();
        rect.figureInfo();
        trg.figureInfo();
    }
}