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

    public static void main(String... args) {
        SingleDimensionArray singleDimensionArray = new SingleDimensionArray(5);
        System.out.println("Created array: " + singleDimensionArray.traverse());

        System.out.println(">>> Insert element in Array");
        singleDimensionArray.insertElement(0, 3);
        singleDimensionArray.insertElement(2, 10);
        singleDimensionArray.insertElement(1, 20);
        singleDimensionArray.insertElement(3, 111);
        singleDimensionArray.insertElement(4, 23);

        System.out.println("After insert: " + singleDimensionArray.traverse());

        System.out.println(">>> Access element in Array");
        System.out.print(singleDimensionArray.accessElement(0));
        System.out.println();
        System.out.println();

        System.out.println(">>> Search element in Array");
        System.out.print("Found in position: " + singleDimensionArray.searchElement(23));
        System.out.println();
        System.out.println();

        System.out.println(">>> Delete element in Array");
        singleDimensionArray.deleteElement(0);
        singleDimensionArray.deleteElement(4);

        System.out.print("After deletion: " + singleDimensionArray.traverse());
    }

}
