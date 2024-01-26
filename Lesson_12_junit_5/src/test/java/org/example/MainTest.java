package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    @DisplayName("Проверка правильности вычисления факториала чисел 0,1,5,10.")
    void calculateFactorial() {
        assertAll(() -> assertEquals(1, Main.calculateFactorial(0)),
                () -> assertEquals(1, Main.calculateFactorial(1)),
                () -> assertEquals(120, Main.calculateFactorial(5)),
                () -> assertEquals(3628800, Main.calculateFactorial(10)));
        assertNotEquals(-1, Main.calculateFactorial(0));
    }
}