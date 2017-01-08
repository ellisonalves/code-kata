package subsetssum;

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
public class SubsetSumProblem {

    private static final int SUM_X = 28;

    private Integer sumX;

    public SubsetSumProblem(Integer sumX) {
        this.sumX = sumX;
    }

    public static void main(String... args) {
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem(SUM_X);
        if (args.length > 0) {
            Integer[] argsAsInteger = new Integer[args.length];
            for (int i = 0; i < args.length; i++)
                argsAsInteger[i] = Integer.parseInt(args[i]);
            subsetSumProblem.challengeAccepted(argsAsInteger);
        } else {

            subsetSumProblem.challengeAccepted(new Integer[]{2, 8, 3, 9, 11, 6});
            // [11, 9, 8] = 28

            /*
            subsetSumProblem.challengeAccepted(new Integer[]{2, 8, 3, 9, 11, 12, 13, 15, 20});
            // [20, 8] = 28
            // [15, 13] = 28
            // [13, 12, 3] = 28
            // [12, 11, 3, 2] = 28
            // [11, 9, 8] = 28

            subsetSumProblem.challengeAccepted(new Integer[]{2, 8, 3, 9, 11, 12, -1, -2, 15, 30, 38});
            // [30, -2] = 28

            subsetSumProblem.challengeAccepted(new Integer[]
                    {
                            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                            41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                            51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66,
                    }
            );*/

            /*final int BIG_ARRAY = 1000;
            Integer[] bigSet = new Integer[BIG_ARRAY];
            Random random = new Random();
            for (int i = 0; i < BIG_ARRAY; i++) {
                bigSet[i] = random.nextInt(SUM_X);
            }

            subsetSumProblem.challengeAccepted(bigSet);
            */
        }
    }

    public void challengeAccepted(Integer[] numbersSet) {
        System.out.println();
        System.out.println("Output: ");
        long start = System.nanoTime();

        Set<Integer[]> integers = subSetSumNumbers(numbersSet);

        long duration = System.nanoTime() - start;

        for (Integer[] array : integers)
            System.out.println(Arrays.toString(array) + " = " + sum(array));

        System.out.println(String.format("Total of subsets: %d", integers.size()));
        System.out.println(String.format("Total time running: %d seconds", TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS)));
    }

    Set<Integer[]> subSetSumNumbers(final Integer[] numbers) {
        Integer[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbersCopy, Collections.reverseOrder());

        Set<Integer[]> validCombinations = new LinkedHashSet<>();

        for (int i = 0; i < numbersCopy.length - 1; i++) {
            for (int j = i+1; j < numbersCopy.length; j++) {
                Integer[] elements = Arrays.copyOfRange(numbersCopy, i, j);
                int sum = sum(elements);

                if (sum == SUM_X) {
                    validCombinations.add(elements);
                }
            }
        }

        if (validCombinations.isEmpty()) {
            validCombinations.add(new Integer[]{});
        }

        return validCombinations;
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

    private int sum(Integer[] elements) {
        int sum = 0;
        if (elements != null)
            for (Integer e : elements)
                if (null != e)
                    sum += e;
        return sum;
    }

}
