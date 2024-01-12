package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> data;

    Phonebook() {
        data = new HashMap<>();
    }

    void add(String surname, String phoneNumber) {
        if (data.containsKey(surname)) {
            data.get(surname).add(phoneNumber);
        } else {
            data.put(surname, new ArrayList<>(Collections.singletonList(phoneNumber)));
        }
    }

    void get(String surname) {
        if (data.containsKey(surname)) {
            System.out.println("Список телефонных номеров абонента с фамилией " + surname + ":");
            for (String s : data.get(surname)) {
                System.out.print(s + " ");
            }
            System.out.println();
        } else {
            System.out.println("Абонент с фамилией " + surname + " не найден.");
        }
    }
}