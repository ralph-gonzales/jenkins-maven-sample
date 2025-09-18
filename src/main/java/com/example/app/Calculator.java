package com.example.app;

/**
 * A tiny calculator with a couple of pure functions used by tests.
 */
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("b must not be 0");
        return a / b;
    }
}
