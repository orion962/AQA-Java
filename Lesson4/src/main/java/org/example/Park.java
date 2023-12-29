package org.example;

public class Park {
    public class Attractions {
        String title;
        String worktime;
        int price;

        Attractions(String title, String worktime, int price) {
            this.title = title;
            this.worktime = worktime;
            this.price = price;
        }

        void printString() {
            System.out.printf("%s, %s, %d", title, worktime, price);
            System.out.println();
        }
    }
}