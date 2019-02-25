package com.ellisonalves.arrays;

public interface MyArray {

    int accessElement(int element);

    int searchElement(int index);

    boolean deleteElement(int index);

    boolean insertElement(int position, int element);

    String traverse();
}
