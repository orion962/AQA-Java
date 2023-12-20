package org.example;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println();
        checkSumSign();
        System.out.println();
        printColor();
        System.out.println();
        compareNumbers();
    }

    static void printThreeWords()
    {
        System.out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign()
    {
        int a = 5;
        int b = -9;
        System.out.println((a + b >= 0) ? "Сумма положительная" : "Сумма отрицательная");
    }

    static void printColor()
    {
        int value = 99;
        if (value <= 0)
        {
            System.out.println("Красный");
        }
        else if (value > 0 && value <= 100)
        {
            System.out.println("Жёлтый");
        }
        else
        {
            System.out.println("Зелёный");
        }
    }

    static void compareNumbers()
    {
        int a = 7;
        int b = 12;
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }
}