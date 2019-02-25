package com.ellisonalves.arrays;

import com.ellisonalves.Algorithm;

class InsertElementInArray implements Algorithm<Boolean> {

    private int[] elements;
    private int position;
    private int newElement;

    public InsertElementInArray(int[] elements, int position, int newElement) {
        this.elements = elements;
        this.position = position;
        this.newElement = newElement;
    }

    @Override
    public Boolean execute() {
        if (elements[position] == Integer.MIN_VALUE) {
            elements[position] = newElement;
            return true;
        }

        return false;
    }

}
