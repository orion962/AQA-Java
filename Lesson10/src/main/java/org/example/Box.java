package org.example;

import java.util.ArrayList;

class Box<T extends Fruit> {
    private ArrayList<T> data;

    Box() {
        data = new ArrayList<>();
    }

    Box(ArrayList<T> arr) {
        data = new ArrayList<>();
        data.addAll(arr);
    }

    void add(T fruit) {
        data.add(fruit);
    }

    float getWeight() {
        if (!data.isEmpty()) {
            return data.get(0).getWeight() * data.size();
        } else {
            return 0.0f;
        }
    }

    <S extends Fruit> boolean compare(Box<S> obj) {
        return Math.abs(getWeight() - obj.getWeight()) < 0.0001;
    }

    void shift(Box<T> obj) {
        obj.data.addAll(data);
        data.clear();
    }
}