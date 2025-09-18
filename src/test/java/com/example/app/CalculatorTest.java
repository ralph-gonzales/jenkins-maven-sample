package com.example.app;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void add_shouldSumTwoNumbers() {
        Calculator c = new Calculator();
        assertThat(c.add(2, 3)).isEqualTo(5);
    }

    @Test
    void subtract_shouldSubtractNumbers() {
        Calculator c = new Calculator();
        assertThat(c.subtract(10, 4)).isEqualTo(6);
    }

    @Test
    void multiply_shouldMultiply() {
        Calculator c = new Calculator();
        assertThat(c.multiply(7, 6)).isEqualTo(42);
    }

    @Test
    void divide_shouldThrowOnZero() {
        Calculator c = new Calculator();
        assertThatThrownBy(() -> c.divide(1, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("must not be 0");
    }
}
