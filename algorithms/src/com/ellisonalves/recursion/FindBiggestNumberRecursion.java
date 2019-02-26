package com.ellisonalves.recursion;

import com.ellisonalves.Algorithm;

public class FindBiggestNumberRecursion implements Algorithm<Integer> {

    private int highest;

    private int[] elements;

    public FindBiggestNumberRecursion(int[] elements) {
        this.elements = elements;
    }

    @Override
    public Integer execute() {
        return findBiggestNumber(elements, elements.length - 1);
    }

    private int findBiggestNumber(int[] array, int position) {
        int current;
        if (position == -1)
            return highest;
        else if ((current = array[position]) > highest)
            highest = current;

        return findBiggestNumber(array, position - 1);
    }

    public static void main(String[] args) {
        System.out.println(">>> FindBiggestNumberRecursion: " + new FindBiggestNumberRecursion(
                new int[]{20, 1, 2, 300, 3, 4, 400, 5, 6, 100, 200, 7, 8, 9, 10})
                .execute()
        );
    }

}
