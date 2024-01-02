package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // чтение данных из файла input.csv и запись в объект obj1
        AppData obj1 = new AppData();
        readFile(obj1);
        obj1.print();
        /////////////////////////////////////////////////
        // запись данных в файл output.csv из объекта obj2
        String[] header = {"value1", "value2", "value3"};
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        AppData obj2 = new AppData(header, data);
        writeFile(obj2);
    }

    static void readFile(AppData obj) {
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("Lesson6/src/files/input.csv"))) {
            while (br.readLine() != null) ++lines;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("Lesson6/src/files/input.csv"))) {
            String[] header = new String[0];
            int[][] data = new int[lines - 1][];
            String s;
            int idx = 0;
            while ((s = br.readLine()) != null) {
                if (idx == 0) {
                    header = s.split(";");
                } else {
                    String[] line = s.split(";");
                    data[idx - 1] = new int[line.length];
                    for (int i = 0; i < line.length; ++i) {
                        data[idx - 1][i] = Integer.parseInt(line[i]);
                    }
                }
                ++idx;
            }
            obj.set(header, data);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void writeFile(AppData obj) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Lesson6/src/files/output.csv"))) {
            String[] header = obj.getHeader();
            int[][] data = obj.getData();
            bw.write(String.join(";", header) + "\n");
            String[] arr = new String[header.length];
            for (int[] datum : data) {
                for (int j = 0; j < datum.length; ++j) {
                    arr[j] = String.valueOf(datum[j]);
                }
                bw.write(String.join(";", arr) + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}