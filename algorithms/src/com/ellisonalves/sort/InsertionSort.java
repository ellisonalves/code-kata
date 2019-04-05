package com.ellisonalves.sort;

import java.util.Arrays;

public class InsertionSort {

    // 20, 35, -15
    // 20, 35, 35
    // -15, 20, 35
    // -15, 20, 35, 7
    // -15, 20, 35, 35
    // -15, 20, 20, 35
    // -15, 7, 20, 35
    // -15, 7, 20, 35, 55
    // -15, 7, 20, 35, 55, 1
    // -15, 7, 20, 35, 55, 55
    // -15, 7, 20, 35, 35, 55
    // -15, 7, 20, 20, 35, 55
    // -15, 7, 7, 20, 35, 55
    // -15, 1, 7, 20, 35, 55
    // -15, 1, 7, 20, 35, 55, -22
    // -15, 1, 7, 20, 35, 55, 55
    // -15, 1, 7, 20, 35, 35, 55
    // -15, 1, 7, 20, 20, 35, 55
    // -15, 1, 7, 7, 20, 35, 55
    // -15, 1, 1, 7, 20, 35, 55
    // -15, -15, 1, 7, 20, 35, 55
    // -22, -15, 1, 7, 20, 35, 55

    public static void main(String... args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int unsortedIndex = 1; unsortedIndex < intArray.length; unsortedIndex++) {
            int unsortedElement = intArray[unsortedIndex];
            int i = unsortedIndex;

            while (i > 0 && intArray[i - 1] > unsortedElement) {
                intArray[i] = intArray[i - 1];
                i--;
            }

            intArray[i] = unsortedElement;
        }

        System.out.println(Arrays.toString(intArray));
    }

}
