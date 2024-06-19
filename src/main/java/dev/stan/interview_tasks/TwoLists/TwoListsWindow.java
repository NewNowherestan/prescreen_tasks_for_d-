package dev.stan.interview_tasks.TwoLists;

import java.util.List;
import java.util.Set;

public class TwoListsWindow extends TwoLists {

    @Override
    public Set<Integer> getIndexes(int count, List<Integer> diff) {
        int maxOffset = diff.size() - count;
        int maxSum = 0;
        Set<Integer> indexes = null;
        for (int i = 0; i <= maxOffset; i++) {
            int sum = diff.stream().skip(i).limit(count).mapToInt(Integer::intValue).sum();
            if (sum > maxSum) {
                maxSum = sum;
                indexes = IntStream.range(i, i + count).boxed().collect(Collectors.toSet());
            }
        }
        return indexes;
    }
    
}
