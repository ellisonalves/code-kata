package subsetssum;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;

/**
 * Created by ellison on 06/01/17.
 */
public class SubsetSumProblemTest {

    @Test
    public void shouldRetrieveZeroSubsetsAsResult() throws Exception {
        SubsetSumProblem subsetSumProblem = new SubsetSumProblem(1);

        Integer[] emptyExpected = new Integer[]{};

        Set<Integer[]> subsetReturned = subsetSumProblem.getSubsetsBySum(new Integer[]{1});

        Assert.assertThat(subsetReturned, hasItem(emptyExpected));
    }

    @Test
    public void shouldRetrieveOneSubsetAsResult() throws Exception {
        final Integer SUM_X = 28;

        Integer[] subsetExpected = new Integer[]{11, 9, 8};

        SubsetSumProblem subsetSumProblem = new SubsetSumProblem(SUM_X);

        Set<Integer[]> subsetReturned = subsetSumProblem.getSubsetsBySum((new Integer[]{2, 8, 3, 9, 11}));

        Assert.assertEquals(1, subsetReturned.size());

        Assert.assertThat(subsetReturned, hasItem(subsetExpected));
    }

}