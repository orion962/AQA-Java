package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"0", "1", "2"}, {"0", "1", "2", "4"}, {"0", "1", "2", "4"}, {"0", "1", "2", "4"}};
        try {
            System.out.println(sumIntElems(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    static int sumIntElems(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        boolean flag = true;
        for (String[] strings : arr) {
            if (strings.length != arr.length) {
                flag = false;
                break;
            }
        }
        if (!(arr.length == 4 && flag)) {
            throw new MyArraySizeException("Неправильный размер массива.");
        }

        int sum = 0;
        int line = 0;
        int column = 0;
        try {
            for (int i = 0; i < arr.length; ++i) {
                line = i;
                for (int j = 0; j < arr[i].length; ++j) {
                    column = j;
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException ignored) {
            throw new MyArrayDataException("Элемент не удаётся сконвертировать в int.", line, column);
        }
        return sum;
    }
}