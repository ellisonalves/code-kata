package subsetsum;

import java.util.*;
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

    private static final int SUM = 1200;

    public static void main(String... args) {
        SubSetSumNumberFromMyMindToJava7 subSetSumNumberFromMyMindToJava7 = new SubSetSumNumberFromMyMindToJava7();
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

            final int BIG_ARRAY = 1000;
            Integer[] bigSet = new Integer[BIG_ARRAY];
            Random random = new Random();
            for (int i = 0; i < BIG_ARRAY; i++) {
                bigSet[i] = random.nextInt(SUM);
            }

            System.out.println(Arrays.toString(bigSet));

            subSetSumNumberFromMyMindToJava7.challengeAccepted(bigSet);
        }
    }

    public void challengeAccepted(Integer[] numbersSet) {
        System.out.println();
        System.out.println("Output: ");
        long start = System.nanoTime();

        int[][] integers = subSetSumNumbers(numbersSet);

        long duration = System.nanoTime() - start;

        for (int[] array : integers)
            System.out.println(Arrays.toString(array) + " = " + sum(array));

        System.out.println(String.format("Total time running: %d seconds", TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS)));
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
//                    finalResult.add(filter);
                } else if (actualSetSum == maxPossibleSum)
//                    finalResult.add(filter);
                    finalResult.add(removeZeros(filter));
            }
        }
        return finalResult.toArray(new int[][]{});
    }

    private int[] removeZeros(final int[] array) {
        int[] newOutputArray = new int[0];
        int newArrayIndex = 0;
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                newOutputArray = Arrays.copyOf(newOutputArray, newOutputArray.length + 1);
                newOutputArray[newArrayIndex++] = array[i];
                set.add(array[i]);
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
