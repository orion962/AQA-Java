package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>(Arrays.asList(new Apple[]{new Apple(), new Apple(), new Apple()}));
        ArrayList<Orange> oranges = new ArrayList<>(Arrays.asList(new Orange[]{new Orange(), new Orange(), new Orange()}));
        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        orangeBox.add(new Orange());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        Box<Apple> box = new Box<>();
        appleBox.shift(box);
        System.out.println(appleBox.getWeight());
        System.out.println(box.getWeight());
    }
}