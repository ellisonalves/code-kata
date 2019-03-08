package com.ellisonalves.stack;

public class StackArray {

    private int[] stack;
    private int top;

    public StackArray(int size) {
        this.stack = new int[size];
        this.top = stack.length - 1;
        System.out.println("Successfully created an empty Stack of size: " + size);
    }


}
