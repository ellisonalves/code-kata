package com.ellisonalves.arrays;

import com.ellisonalves.Algorithm;

class DeleteElementInArray implements Algorithm<Boolean> {

    private int[] elements;
    private int index;

    public DeleteElementInArray(int[] elements, int index) {
        this.elements = elements;
        this.index = index;
    }

    @Override
    public Boolean execute() {
        if (index > elements.length - 1 || index < 0)
            throw new IllegalArgumentException("Provided index doesnot exist");

        if (isOccupied(elements[index])) {
            elements[index] = Integer.MIN_VALUE;
            return true;
        } else {
            System.out.println("elements doesn't exist");
            return false;
        }
    }

    private boolean isOccupied(int element) {
        return element != Integer.MIN_VALUE;
    }

}
