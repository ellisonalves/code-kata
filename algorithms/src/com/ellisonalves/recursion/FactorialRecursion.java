package com.ellisonalves.recursion;

public class FactorialRecursion {
    public int factorial(int number) {
        if (number <= 0)
            return 1;
        return number * factorial(number - 1);
    }

    public static void main(String... args) {
        FactorialRecursion fr = new FactorialRecursion();
        System.out.println(">>> Factorial: " + fr.factorial(5));
    }
}
