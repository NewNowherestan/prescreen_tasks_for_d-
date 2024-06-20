package dev.stan.TwoListsSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

/*
 * 
 * The strategy pattern here is just because I dont remember should the K number be subsiquent or not so I did both.
 * 
 * TwoListsWindow is the strategy where the K number should be subsiquent, and done by sliding window approach.
 * 
 * TwoListsAny is the strategy where the K numbers can be any and just brutforced via sort.
 * 
 */
public abstract class TwoListsAbstractSolution {
    static final Logger logger = LoggerFactory.getLogger(TwoListsAbstractSolution.class);

    public abstract Set<Integer> getIndexes(int count, List<Integer> diff);

    public List<Integer> getDiff(List<Integer> list1, List<Integer> list2) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            diff.add(list1.get(i) - list2.get(i));
        }
        return diff;
    }

    public int solve(int k, List<Integer> list1, List<Integer> list2) {
        List<Integer> diff = getDiff(list1, list2);
        Set<Integer> indexes = getIndexes(k, diff);

        int totalAmount = Math.max(list1.size(), list2.size());

        int totalSum = 0;
        for (int i = 0; i < totalAmount; i++) {
            if (indexes.contains(i)) {
                totalSum += list1.get(i);
            } else {
                totalSum += list2.get(i);
            }
        }

        String logMsg = String.format("\u001B[36m k: %d, list1: %s, list2: %s,\n" +
                                      "\u001B[34m diff: %s, indexes: %s, totalAmount: %d,\n" + 
                                      "\u001B[32m totalSum: %d",
                                      k, list1, list2,
                                      diff, indexes, totalAmount, totalSum);
        logger.info(() -> "\u001B[32m ---TwoListsAbstractSolution.solve--- \n" + logMsg + "\n");

        return totalSum;
    }
}
