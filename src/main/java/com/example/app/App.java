package com.example.app;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int a = 2;
        int b = 3;
        System.out.println("Hello from Jenkins Maven Sample!");
        System.out.printf("%d + %d = %d%n", a, b, calc.add(a, b));
    }
}
