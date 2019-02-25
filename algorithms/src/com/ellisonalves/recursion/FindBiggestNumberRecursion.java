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

}
