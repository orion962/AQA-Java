package org.example;

public class AppData {
    private String[] header;
    private int[][] data;

    AppData() {
    }

    AppData(String[] header, int[][] data) {
        boolean flag = true;
        for (int[] datum : data) {
            if (datum.length != header.length) {
                flag = false;
                break;
            }
        }
        if (flag) {
            this.header = header;
            this.data = data;
        }
    }

    void set(String[] header, int[][] data) {
        boolean flag = true;
        for (int[] datum : data) {
            if (datum.length != header.length) {
                flag = false;
                break;
            }
        }
        if (flag) {
            this.header = header;
            this.data = data;
        }
    }

    String[] getHeader() {
        return header;
    }

    int[][] getData() {
        return data;
    }

    void print() {
        for (String s : header) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int[] datum : data) {
            for (int i : datum) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}