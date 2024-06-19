package dev.stan.TwoListsSolution;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoListsWindow extends TwoListsAbstractSolution {

    @Override
    public Set<Integer> getIndexes(int count, List<Integer> diff) {
        int maxOffset = diff.size() - count;
        int maxSum = 0;
        Set<Integer> indexes = null;
        for (int i = 0; i <= maxOffset; i++) {
            int sum = diff.stream().skip(i).limit(count).mapToInt(Integer::intValue).sum();
            if (sum > maxSum || indexes == null) {
                maxSum = sum;
                indexes = IntStream.range(i, i + count).boxed().collect(Collectors.toSet());
            }
        }

        return indexes;
    }
    
}
