package com.ellisonalves.main;

import com.ellisonalves.recursion.FindBiggestNumberRecursion;

public class RecursionMain {

    public static void main(String[] args) {
        System.out.println("FindBiggestNumberRecursion >>> " + new FindBiggestNumberRecursion(
                new int[]{20, 1, 2, 300, 3, 4, 400, 5, 6, 100, 200, 7, 8, 9, 10})
                .execute()
        );
    }
}
