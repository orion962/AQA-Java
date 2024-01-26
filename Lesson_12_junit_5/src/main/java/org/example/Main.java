package org.example;

class Main {
    public static void main(String[] args) {
        System.out.println(calculateFactorial(10));
    }

    static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return calculateFactorial(n - 1) * n;
        }
    }
}