package com.adventofcode.puzzle1;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.adventofcode.puzzle1.FuelCounterUpper.fuel;
import static org.junit.jupiter.api.Assertions.*;

class FuelCounterUpperTest
{
    @Nested
    class Second {

        @Test
        void additive() {
            assertEquals(2, fuel(14));
            assertEquals(966, fuel(1969));
            assertEquals(50346, fuel(100756));
        }
    }
}