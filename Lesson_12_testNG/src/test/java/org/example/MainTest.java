package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MainTest {
    @Test
    public void testCalculateFactorial() {
        assertEquals(1, Main.calculateFactorial(0));
        assertEquals(1, Main.calculateFactorial(1));
        assertEquals(120, Main.calculateFactorial(5));
        assertEquals(3628800, Main.calculateFactorial(10));
    }
}