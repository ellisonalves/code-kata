package subsetsum;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

    private static final int SUM = 29;

    public static void main(String... args) {
        SubSetSumNumberFromMyMindToJava7 subSetSumNumberFromMyMindToJava7 = new SubSetSumNumberFromMyMindToJava7();
        long begin = System.nanoTime();
        if (args.length > 0) {
            Integer[] argsAsInteger = new Integer[args.length];
            for (int i = 0; i < args.length; i++)
                argsAsInteger[i] = Integer.parseInt(args[i]);
            subSetSumNumberFromMyMindToJava7.challengeAccepted(argsAsInteger);
        } else {
            subSetSumNumberFromMyMindToJava7.challengeAccepted(new Integer[]{2, 8, 3, 9, 11});
            // [11, 9, 8] = 28

            subSetSumNumberFromMyMindToJava7.challengeAccepted(new Integer[]{2, 8, 3, 9, 11, 12, 13, 15, 20});
            // [20, 8] = 28
            // [15, 13] = 28
            // [13, 12, 3] = 28
            // [12, 11, 3, 2] = 28
            // [11, 9, 8] = 28

            subSetSumNumberFromMyMindToJava7.challengeAccepted(new Integer[]{2, 8, 3, 9, 11, 12, -1, -2, 15, 30, 38});
            // [30, -2] = 28
        }
        long end = System.nanoTime();

        System.out.println("Total time running: " + String.format("%d millis", TimeUnit.NANOSECONDS.toMillis(end - begin)));
    }

    public void challengeAccepted(Integer[] numbersSet) {
        System.out.println();
        System.out.println("Output: ");
        int[][] integers = subSetSumNumbers(numbersSet);
        for (int[] array : integers)
            System.out.println(Arrays.toString(array) + " = " + sum(array));
    }

    private int[][] subSetSumNumbers(final Integer[] numbersSet) {
        Arrays.sort(numbersSet, Collections.reverseOrder());
        Set<int[]> finalResult = new LinkedHashSet<>();
        int maxPossibleSum = 0;
        for (int i = 0; i < numbersSet.length - 1; i++) {
            int[] filter = new int[numbersSet.length];
            filter[i] = numbersSet[i];
            int index = i + 1;
            while (index < numbersSet.length) {
                filter[index] = numbersSet[index];
                boolean invalidSum = !((sum(filter)) < SUM);
                if (invalidSum)
                    filter[index] = 0;
                index++;
            }
            int actualSetSum = sum(filter);
            if (actualSetSum < SUM) {
                // This logic is possible because the numbersSet is ordered (reverse order)
                // So, the first array sum elements will always be closest from SUM.
                if (finalResult.isEmpty()) {
                    maxPossibleSum = actualSetSum;
                    finalResult.add(removeZeros(filter));
                } else if (actualSetSum == maxPossibleSum)
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
