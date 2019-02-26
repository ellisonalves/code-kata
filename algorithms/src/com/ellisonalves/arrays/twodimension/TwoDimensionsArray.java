package com.ellisonalves.arrays.twodimension;

public class TwoDimensionsArray {

    private int[][] matrix;

    public TwoDimensionsArray(int rows, int cols) {
        this.matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    public int accessElement(int row, int col) {
        int value = Integer.MIN_VALUE;
        try {
            value = matrix[row][col];
            if (value == Integer.MIN_VALUE)
                System.out.println("Element not found");
            else
                System.out.println("Element found: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Element not found");
        }
        return value;
    }

    public void searchElement(int element) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (element == matrix[row][col]) {
                    System.out.println("Element: " + element + " Found in, row: " + row + " and column: " + col);
                }
            }
        }
    }

    public void deleteElement(int row, int col) {
        try {
            if (matrix[row][col] != Integer.MIN_VALUE) {
                System.out.println("Element: " + matrix[row][col] + " in row: " + row + " col: " + col + " being delete");
                matrix[row][col] = Integer.MIN_VALUE;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
        }
    }

    public void insertElement(int row, int col, int element) {
        try {
            if (matrix[row][col] == Integer.MIN_VALUE) {
                matrix[row][col] = element;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!");
        }
    }

    public String traverse() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                builder.append(matrix[row][col])
                        .append("    ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String... args) {
        TwoDimensionsArray twoDimensionsArray = new TwoDimensionsArray(3, 5);

        System.out.println(">>> Insert values in Array... ");
        twoDimensionsArray.insertElement(0, 1, 5);
        twoDimensionsArray.insertElement(0, 2, 10);
        twoDimensionsArray.insertElement(0, 3, 3);
        twoDimensionsArray.insertElement(1, 0, 13);
        twoDimensionsArray.insertElement(1, 1, 40);
        twoDimensionsArray.insertElement(2, 3, 40);

        System.out.println(">>> Traverse Array ");
        System.out.println(twoDimensionsArray.traverse());

        System.out.println(">>> Acess element ");
        twoDimensionsArray.accessElement(0, 2);
        twoDimensionsArray.accessElement(100, 200);
        twoDimensionsArray.accessElement(0, 0);
        System.out.println();

        System.out.println(">>> Search element ");
        twoDimensionsArray.searchElement(20);
        twoDimensionsArray.searchElement(10);
        System.out.println();

        System.out.println(">>> Deleting ");
        twoDimensionsArray.deleteElement(0, 1);
        twoDimensionsArray.deleteElement(0, 1);
        twoDimensionsArray.deleteElement(2, 3);
        System.out.println();

        System.out.println(">>> Traverse Array ");
        System.out.println(twoDimensionsArray.traverse());
    }

}
