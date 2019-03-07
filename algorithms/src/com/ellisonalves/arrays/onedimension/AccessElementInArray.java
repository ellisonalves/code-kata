package com.ellisonalves.arrays.onedimension;

import com.ellisonalves.Algorithm;

class AccessElementInArray implements Algorithm<Integer> {

    private int[] elements;
    private int position;

    public AccessElementInArray(int[] elements, int position) {
        this.elements = elements;
        this.position = position;
    }

    @Override
    public Integer execute() {
        if (position > elements.length - 1 || position < 0)
            throw new IllegalArgumentException("position must be a valid number inside of the array");
        else
            return elements[position];
    }
}
