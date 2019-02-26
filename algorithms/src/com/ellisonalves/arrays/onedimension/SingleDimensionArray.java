package com.ellisonalves.arrays.onedimension;

public class SingleDimensionArray {

    private int[] elements;

    public SingleDimensionArray(int sizeOf) {
        this.elements = new int[sizeOf];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = Integer.MIN_VALUE;
        }
    }

    public int accessElement(int element) {
        return new AccessElementInArray(elements, element).execute();
    }

    public int searchElement(int index) {
        return new SearchElementInArray(elements, index).execute();
    }

    public boolean deleteElement(int index) {
        return new DeleteElementInArray(elements, index).execute();
    }

    public boolean insertElement(int position, int element) {
        return new InsertElementInArray(elements, position, element).execute();
    }

    public String traverse() {
        return new TraverseElementsInArray(elements).execute() + "\n\n";
    }

}
