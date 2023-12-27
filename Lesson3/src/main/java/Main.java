/*
 1. Написать метод, принимающий на вход два целых числа и проверяющий,
 что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

 2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
  положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.

 3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
  если число отрицательное, и вернуть false если положительное.

 4. Написать метод, которому в качестве аргументов передается строка и число,
  метод должен отпечатать в консоль указанную строку, указанное количество раз.

 5. Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
  не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

 6. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
  С помощью цикла и условия заменить 0 на 1, 1 на 0.

 7. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100.

 8. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2.

 9. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
  и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
   Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
   то есть [0][0], [1][1], [2][2], ..., [n][n].

 10. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len,
  каждая ячейка которого равна initialValue.
 */

public class Main {
    public static void main(String[] args) {
        /////////////////////////////////////////// 1 задание
        if (returnBoolValue(3, 18))
        {
            System.out.println("Сумма лежит в диапазоне от 10 до 20.");
        }
        else
        {
            System.out.println("Сумма не лежит в диапазоне от 10 до 20.");
        }
        System.out.println();
        /////////////////////////////////////////// 2 задание
        printNumberSign(5);
        printNumberSign(-3);
        System.out.println();
        /////////////////////////////////////////// 3 задание
        if (returnBoolValue(3))
        {
            System.out.println("Число отрицательное.");
        }
        else
        {
            System.out.println("Число положительное.");
        }
        System.out.println();
        /////////////////////////////////////////// 4 задание
        printString("AQA-Java", 8);
        System.out.println();
        System.out.println();
        /////////////////////////////////////////// 5 задание
        int year1 = 2000; // високосный
        int year2 = 1900; // не високосный
        int year3 = 2008; // високосный
        if (printLeapYear(year3))
        {
            System.out.println("Високосный год.");
        }
        else
        {
            System.out.println("Не високосный год.");
        }
        System.out.println();
        /////////////////////////////////////////// 6 задание
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; ++i)
        {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr1.length; ++i)
        {
            arr1[i] = 1 - arr1[i];
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println();
        /////////////////////////////////////////// 7 задание
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; ++i)
        {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < 101; ++i)
        {
            arr2[i-1] = i;
            System.out.print(arr2[i-1] + " ");
        }
        System.out.println();
        System.out.println();
        /////////////////////////////////////////// 8 задание
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; ++i)
        {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr3.length; ++i)
        {
            if (arr3[i] < 6)
            {
                arr3[i] *= 2;
            }
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        System.out.println();
        /////////////////////////////////////////// 9 задание
        int[][] arr4 = new int[6][6];
        for (int i = 0; i < arr4.length; ++i)
        {
            for (int j = 0; j < arr4[i].length; ++j)
            {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < arr4.length; ++i)
        {
            arr4[i][i] = 1;
        }
        for (int i = 0; i < arr4.length; ++i)
        {
            arr4[i][(arr4.length - 1) - i] = 1;
        }
        for (int i = 0; i < arr4.length; ++i)
        {
            for (int j = 0; j < arr4[i].length; ++j)
            {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        /////////////////////////////////////////// 10 задание
        int[] arr5 = returnArray(10, 25);
        for (int i = 0; i < arr5.length; ++i)
        {
            System.out.print(arr5[i] + " ");
        }
        System.out.println();
    }

    static boolean returnBoolValue(int a, int b)
    {
        return (a+b >= 10 && a+b <= 20);
    }

    static void printNumberSign(int a)
    {
        System.out.println((a >= 0) ? "Положительное число" : "Отрицательное число");
    }

    static boolean returnBoolValue(int a)
    {
        return (a < 0);
    }

    static void printString(String s, int n)
    {
        for (int i = 0; i < n; ++i)
        {
            System.out.print(s + " ");
        }
    }

    static boolean printLeapYear(int year)
    {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    static int[] returnArray(int len, int initialValue)
    {
        int[] arr = new int[len];
        for (int i = 0; i < len; ++i)
        {
            arr[i] = initialValue;
        }
        return arr;
    }
}
