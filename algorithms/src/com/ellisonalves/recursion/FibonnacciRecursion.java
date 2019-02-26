package com.ellisonalves.recursion;

public class FibonnacciRecursion {

    private int fibbonacci(int number) {
        if ((number == 0) || (number == 1))
            return number;
        else
            return fibbonacci(number - 1) + fibbonacci(number - 2);
    }

    public static void main(String... args) {
        FibonnacciRecursion fr = new FibonnacciRecursion();
        System.out.println(">>> Fibbonacci: " + fr.fibbonacci(8));
    }
}
