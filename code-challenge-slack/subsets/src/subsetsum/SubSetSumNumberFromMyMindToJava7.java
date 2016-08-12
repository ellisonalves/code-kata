package subsetsum;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * You're given two inputs: a positive integer x and an array A of
 * positive integers. Your task is to find the subset(s) of A whose highestSum
 * is closest but not bigger than x. The order of the output does not
 * matter, but you should return all possible solutions.
 * <p>
 * For example:
 * x = 29
 * A = [2, 8, 3, 9, 11]
 * <p>
 * output = [8, 9, 11]
 * <p>
 * The highestSum is 28, which is the closest you can get to x.
 * <p>
 * Bonus: accept all integers, not just positive ones.
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by ellison on 28/07/16.
 */
public class SubSetSumNumberFromMyMindToJava7 {

    private static final int SUM = 20;

    public static void main(String... args) {
        SubSetSumNumberFromMyMindToJava7 subSetSumNumberFromMyMindToJava7 = new SubSetSumNumberFromMyMindToJava7();
        if (args.length > 0) {
            int[] argsAsInteger = new int[args.length];
            for (int i = 0; i < args.length; i++)
                argsAsInteger[i] = Integer.parseInt(args[i]);
            subSetSumNumberFromMyMindToJava7.challengeAccepted(argsAsInteger);
        } else {
            subSetSumNumberFromMyMindToJava7.challengeAccepted(new int[]{2, 8, 3, 9, 11});
            // [11, 9, 8] = 28

//            subSetSumNumberFromMyMindToJava7.challengeAccepted(new int[]{2, 8, 3, 9, 11, 12, 13, 15, 20});
            // [20, 8] = 28
            // [15, 13] = 28
            // [13, 12, 3] = 28
            // [12, 11, 3, 2] = 28
            // [11, 9, 8] = 28

//            subSetSumNumberFromMyMindToJava7.challengeAccepted(new int[]{2, 8, 3, 9, 11, 12, -1, -2, 15, 30, 38});
            // [30, -2] = 28

//            subSetSumNumberFromMyMindToJava7.challengeAccepted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});

//            subSetSumNumberFromMyMindToJava7.challengeAccepted(new int[]{1, 2, 3, 4});

            final int BIG_ARRAY = 1000;
            int[] bigSet = new int[BIG_ARRAY];
            Random random = new Random();
            for (int i = 0; i < BIG_ARRAY; i++) {
                bigSet[i] = random.nextInt(SUM);
            }

//            subSetSumNumberFromMyMindToJava7.challengeAccepted(bigSet);
        }
    }

    public void challengeAccepted(int[] numbersSet) {
        System.out.println();
        System.out.println("Input: " + Arrays.toString(numbersSet));
        System.out.println("Output: ");
        long start = System.nanoTime();

        int[][] integers = subSetSumNumbers(numbersSet);

        long duration = System.nanoTime() - start;

        for (int[] array : integers)
            System.out.println(Arrays.toString(array) + " = " + highestSum(array));

        System.out.println(String.format("Total of subsets: %d", integers.length));
        System.out.println(String.format("Total time running: %d seconds", TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS)));
    }

    private int[][] subSetSumNumbers(final int[] numbersSet) {
        int[] numbersSetCopy = Arrays.copyOf(numbersSet, numbersSet.length);
        Arrays.sort(numbersSetCopy);

        Set<int[]> finalResult = new LinkedHashSet<>();

        int highestSum = highestSum(numbersSetCopy);
        System.out.println("Highest sum: " + highestSum);

        int numbersSetBound = numbersSetCopy.length - 1;

        for (int i = numbersSetBound; i >= 0; i--) {
            int[] newset = new int[numbersSetCopy.length];
            int newsetIndex = 0;
            int controlIndex = numbersSetBound - i;
            int floatingIndex = numbersSetBound;
            while (controlIndex < numbersSetBound) {
                if (floatingIndex < 0)
                    break;

                System.out.println("newsetIndex: " + newsetIndex + ", controlIndex: " + controlIndex + ", floatingIndex: " + floatingIndex + " = numbersSetCopy[floatingIndex] = " + numbersSetCopy[floatingIndex]);
                newset[newsetIndex] = numbersSetCopy[floatingIndex];
                int sum = sum(newset);
                if (sum > highestSum) {
                    newset[newsetIndex] = 0;
                } else {
                    boolean newsubsetFound = (sum >= highestSum && sum <= SUM);
                    if (newsubsetFound) {
                        finalResult.add(removeZeros(newset));
                        if (newsetIndex != 0)
                            newset[newsetIndex] = 0;
                        System.out.println("Subset found");
                    }
                }
                if (newsetIndex < numbersSetBound)
                    newsetIndex++;

                if (newsetIndex == numbersSetBound)
                    controlIndex++;

                if (floatingIndex == controlIndex) {
                    floatingIndex = numbersSetBound;
                    controlIndex = numbersSetBound;
                } else {
                    floatingIndex--;
                }

            }
            numbersSetCopy[i] = 0;
        }
        System.out.println();

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
        for (int i = 0; i < elements.length; i++) {
            sum += elements[i];
        }
        return sum;
    }

    private int highestSum(int[] elements) {
        int sum = 0;
        int[] aux = new int[elements.length];
        for (int i = elements.length - 1; i >= 0; i--) {
            int indexAsc = (elements.length - 1) - i;
            sum += elements[i];
            if (sum <= SUM) {
                aux[indexAsc] = elements[i];
            } else {
                sum -= elements[i];
                aux[indexAsc] = 0;
            }
        }
//        System.out.print("Array: " + Arrays.toString(aux));
        return sum;
    }

}