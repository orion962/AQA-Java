import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /////////////////////////////////////////// 1 задание
        System.out.println(returnBoolValue(3, 18));
        System.out.println(returnBoolValue(-1, 17));
        System.out.println();
        /////////////////////////////////////////// 2 задание
        printNumberSign(5);
        printNumberSign(-3);
        System.out.println();
        /////////////////////////////////////////// 3 задание
        System.out.println(returnBoolValue(3));
        System.out.println(returnBoolValue(-1));
        System.out.println();
        /////////////////////////////////////////// 4 задание
        printString("AQA-Java", 8);
        System.out.println();
        /////////////////////////////////////////// 5 задание
        int year1 = 2000; // високосный
        int year2 = 1900; // не високосный
        int year3 = 2008; // високосный
        System.out.println((printLeapYear(year3)) ? "Високосный год." : "ОНе високосный год.");
        System.out.println();
        /////////////////////////////////////////// 6 задание
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int k : arr1) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] = 1 - arr1[i];
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println();
        /////////////////////////////////////////// 7 задание
        int[] arr2 = new int[100];
        for (int i = 1; i < 101; ++i) {
            arr2[i - 1] = i;
            System.out.print(arr2[i - 1] + " ");
        }
        System.out.println();
        System.out.println();
        /////////////////////////////////////////// 8 задание
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; ++i) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        System.out.println();
        /////////////////////////////////////////// 9 задание
        int[][] arr4 = new int[6][6];
        for (int i = 0; i < arr4.length; ++i) {
            arr4[i][i] = 1;
            arr4[i][(arr4.length - 1) - i] = 1;
        }
        for (int[] ints : arr4) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
        /////////////////////////////////////////// 10 задание
        int[] arr5 = returnArray(10, 25);
        for (int j : arr5) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    static boolean returnBoolValue(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }

    static void printNumberSign(int a) {
        System.out.println((a >= 0) ? "Положительное число" : "Отрицательное число");
    }

    static boolean returnBoolValue(int a) {
        return (a < 0);
    }

    static void printString(String s, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static boolean printLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    static int[] returnArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }
}