package subsetssum;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.pow;

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
        }
    }

    public void challengeAccepted(Integer[] numbersSet) {
        System.out.println();
        System.out.println("Output: ");
        long start = System.nanoTime();

        Set<Integer[]> integers = getSubsetsBySum(numbersSet);

        long duration = System.nanoTime() - start;

        for (Integer[] array : integers)
            System.out.println(Arrays.toString(array) + " = " + sum(array));

        System.out.println(String.format("Total of subsets: %d", integers.size()));
        System.out.println(String.format("Total time running: %d seconds", TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS)));
    }

    Set<Integer[]> getSubsetsBySum(final Integer[] set) {
        Set<Integer[]> result = new LinkedHashSet<>();
        Set<Integer[]> allSubsets = getAllSubsets(set);

        for (Integer[] subset : allSubsets) {
            if (SUM_X == sum(subset)) {
                result.add(subset);
            }
        }

        if (result.isEmpty()) {
            result.add(new Integer[]{});
        }

        return result;
    }

    Set<Integer[]> getAllSubsets(final Integer[] mainset) {
        Arrays.sort(mainset, Collections.reverseOrder());
        int n = mainset.length;
        Set<Integer[]> subsets = new LinkedHashSet<>();
        // Run a loop for printing all 2^n subsets one by one
        for (int i = 0; i < pow(2, n); i++) {
            Set<Integer> arrayList = new LinkedHashSet<>();
            for (int j = 0; j < n; j++) {
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which are not
                if ((i & (1 << j)) != 0) {
                    Integer e = mainset[j];
                    arrayList.add(e);
                }
            }
            subsets.add(arrayList.toArray(new Integer[]{}));
        }
        return subsets;
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
