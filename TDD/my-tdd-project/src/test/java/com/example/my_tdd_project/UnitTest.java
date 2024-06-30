package com.example.my_tdd_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }

    private class Dollar {
        public int amount;

        public Dollar(int amount) {
            this.amount = amount;
        }

        public void times(int multiplier) {
            amount *= multiplier;
        }
    }
}
