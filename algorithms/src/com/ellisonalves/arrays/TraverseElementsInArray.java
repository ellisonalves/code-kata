package com.ellisonalves.arrays;

import com.ellisonalves.Algorithm;

class TraverseElementsInArray implements Algorithm<String> {

    private int[] elements;

    public TraverseElementsInArray(int[] elements) {
        this.elements = elements;
    }

    @Override
    public String execute() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            builder.append(elements[i])
                    .append("   ");

        }
        return builder.toString();
    }

}
