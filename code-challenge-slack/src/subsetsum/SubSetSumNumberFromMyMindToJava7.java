package subsetsum;

import java.util.*;

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
        Set<int[]> subSetSumNumbers = subSetSumNumbers(magicNumber, numbersSet);
        for (int[] result : subSetSumNumbers) {
            int newArrayLength = 1;
            int newArrayIndex = 0;
            int[] newOutputArray = new int[newArrayLength];
            for (int i = 0; i < result.length; i++) {
                if (result[i] != 0) {
                    newOutputArray = Arrays.copyOf(newOutputArray, newArrayLength++);
                    newOutputArray[newArrayIndex++] = result[i];
                }
            }
            System.out.println(Arrays.toString(newOutputArray) + " = " + sum(newOutputArray));
        }
    }

    private Set<int[]> subSetSumNumbers(int magicNumber, Integer[] numbersSet) {
        Arrays.sort(numbersSet, Collections.reverseOrder());
        int totalOfIterations = numbersSet.length;
        Set<int[]> finalResult = new LinkedHashSet<>();
        for (int i = 0; i < totalOfIterations - 1; i++) {
            int[] result = new int[totalOfIterations];
            result[i] = numbersSet[i];
            int index = i + 1;
            while (index < totalOfIterations) {
                result[index] = numbersSet[index];
                boolean invalidSum = !((sum(result)) < magicNumber);
                if (invalidSum) {
                    result[index] = 0;
                }
                index++;
            }
            Integer sumResult = sum(result);
            if (sumResult >= magicNumber - 5 && sumResult < magicNumber)
                finalResult.add(result);
        }
        return finalResult;
    }

    private Integer sum(int[] elements) {
        int sum = 0;
        for (Integer e : elements) {
            sum += e;
        }
        return sum;
    }

}
