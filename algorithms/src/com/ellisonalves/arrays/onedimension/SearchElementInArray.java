package com.ellisonalves.arrays.onedimension;

import com.ellisonalves.Algorithm;

class SearchElementInArray implements Algorithm<Integer> {

    private int[] elements;
    private int wantedElement;

    public SearchElementInArray(int[] elements, int wantedElement) {
        this.elements = elements;
        this.wantedElement = wantedElement;
    }

    @Override
    public Integer execute() {
        for (int i = 0; i < elements.length; i++) {
            if (wantedElement == elements[i])
                return i;
        }
        throw new RuntimeException("Element " + wantedElement + " not found inside of the array of elements");
    }

}
