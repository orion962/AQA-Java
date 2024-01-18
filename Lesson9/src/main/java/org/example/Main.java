package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ////////////////////////////////////////////////////// задание 1
        Random rnd = new Random();
        int[] arr1 = rnd.ints(10, 100, 250).toArray();
        for (int elem : arr1) {
            System.out.print(elem + " ");
        }
        System.out.println("\n" + Arrays.stream(arr1).filter(n -> n % 2 == 0).count() + "\n");
        ////////////////////////////////////////////////////// задание 2
        Collection<String> data1 = new ArrayList<>();
        Collections.addAll(data1, "Highload", "High", "Load", "Highload");
        ////////////////////////////////////////////////////// задание 2.1
        System.out.println(data1.stream().filter(s -> s.equals("High")).count());
        ////////////////////////////////////////////////////// задание 2.2
        Optional<String> first = data1.stream().findFirst();
        System.out.println(first.orElse("0"));
        ////////////////////////////////////////////////////// задание 2.3
        Optional<String> last = data1.stream().reduce((frst, scnd) -> scnd);
        System.out.println(last.orElse("0"));
        System.out.println();
        ////////////////////////////////////////////////////// задание 3
        Collection<String> data2 = new ArrayList<>();
        Collections.addAll(data2, "f10", "f15", "f2", "f4", "f4");
        String[] arr2 = data2.stream().sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                .toArray(String[]::new);
        for (String s : arr2) {
            System.out.print(s + " ");
        }
        System.out.println();
        ////////////////////////////////////////////////////// задание 4, 4.1, 4.2
        MyClass obj = new MyClass();
        System.out.println(obj.getAverageAge());
        obj.getSummons();
        System.out.println();
        ////////////////////////////////////////////////////// задание 5
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                break;
            } else {
                list.add(line);
            }
        }
        in.close();
        list.stream().filter(s -> s.charAt(0) == 'f').forEach(System.out::println);
    }
}