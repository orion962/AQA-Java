package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //////////////////////////////////////////////////////// задание 1
        String[] arr = {"яблоко", "апельсин", "банан", "киви",
                "мандарин", "кокос", "яблоко", "банан", "вишня", "банан"};

        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : arr) {
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);
            }
        }

        for (Map.Entry<String, Integer> elem : hm.entrySet()) {
            System.out.println(elem.getKey() + ": " + elem.getValue());
        }
        //////////////////////////////////////////////////////// задание 2
        Phonebook pb = new Phonebook();
        pb.add("Иванов", "+79021235689");
        pb.add("Иванов", "+79021135682");
        pb.add("Петров", "+79022883423");
        pb.add("Петров", "+79022833421");
        pb.add("Петров", "+79025883027");
        pb.add("Фёдоров", "+79028935870");
        pb.get("Иванов");
        pb.get("Симонов");
        pb.get("Петров");
    }
}