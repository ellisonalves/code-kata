package com.ellisonalves.main;

import com.ellisonalves.arrays.SingleDimensionArray;

public class ArraysMain {

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
