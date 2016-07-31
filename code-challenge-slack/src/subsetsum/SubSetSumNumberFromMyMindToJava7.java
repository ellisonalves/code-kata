package subsetsum;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * You're given two inputs: a positive integer x and an array A of
 * positive integers. Your task is to find the subset(s) of A whose sum
 * is closest but not bigger than x. The order of the output does not
 * matter, but you should return all possible solutions.
 * <p>
 * For example:
 * x = 29
 * A = [2, 8, 3, 9, 11]
 * <p>
 * output = [8, 9, 11]
 * <p>
 * The sum is 28, which is the closest you can get to x.
 * <p>
 * Bonus: accept all integers, not just positive ones.
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by ellison on 28/07/16.
 */
public class SubSetSumNumberFromMyMindToJava7 {

    private static final int MAX_MAGIC_NUMBER = 29;
    private static final int RANGE_AROUND_MAGIC_NUMBER = MAX_MAGIC_NUMBER - 5;

    public static void main(String[] args) {
        SubSetSumNumberFromMyMindToJava7 subSetSumNumberFromMyMindToJava7 = new SubSetSumNumberFromMyMindToJava7();
        subSetSumNumberFromMyMindToJava7.challengeAccepted(MAX_MAGIC_NUMBER, new Integer[]{2, 8, 3, 9, 11});
        // [11, 9, 8] = 28

        subSetSumNumberFromMyMindToJava7.challengeAccepted(MAX_MAGIC_NUMBER, new Integer[]{2, 8, 3, 9, 11, 12, 13, 15, 20});
        // [20, 8] = 28
        // [15, 13] = 28
        // [13, 12, 3] = 28
        // [12, 11, 3, 2] = 28
        // [11, 9, 8] = 28

        subSetSumNumberFromMyMindToJava7.challengeAccepted(MAX_MAGIC_NUMBER, new Integer[]{2, 8, 3, 9, 11, 12, -1, -2, 15, 30, 38});
        // [30, -2] = 28
        // [15, 12, -1, -2] = 24
        // [12, 11, 3, 2, -1, -2] = 25
        // [11, 9, 8, -1, -2] = 25
    }

    public void challengeAccepted(int magicNumber, Integer[] numbersSet) {
        System.out.println();
        System.out.println("Output: ");
        int[][] integers = subSetSumNumbers(magicNumber, numbersSet);
        for (int[] array : integers) {
            System.out.println(Arrays.toString(array) + " = " + sum(array));
        }
    }

    private int[][] subSetSumNumbers(final int magicNumber, final Integer[] numbersSet) {
        Arrays.sort(numbersSet, Collections.reverseOrder());
        int totalOfIterations = numbersSet.length;
        Set<int[]> finalResult = new LinkedHashSet<>();
        for (int i = 0; i < totalOfIterations - 1; i++) {
            int[] filter = new int[totalOfIterations];
            filter[i] = numbersSet[i];
            int index = i + 1;
            while (index < totalOfIterations) {
                filter[index] = numbersSet[index];
                boolean invalidSum = !((sum(filter)) < magicNumber);
                if (invalidSum)
                    filter[index] = 0;
                index++;
            }
            int sumResult = sum(filter);
            if (sumResult >= RANGE_AROUND_MAGIC_NUMBER && sumResult < magicNumber) {
                finalResult.add(removeZeros(filter));
            }
        }
        return finalResult.toArray(new int[][]{});
    }

    private int[] removeZeros(final int[] array) {
        int[] newOutputArray = new int[0];
        int newArrayIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                newOutputArray = Arrays.copyOf(newOutputArray, newOutputArray.length + 1);
                newOutputArray[newArrayIndex++] = array[i];
            }
        }
        return newOutputArray;
    }

    private int sum(int[] elements) {
        int sum = 0;
        if (elements != null)
            for (Integer e : elements)
                if (null != e)
                    sum += e;
        return sum;
    }
}
