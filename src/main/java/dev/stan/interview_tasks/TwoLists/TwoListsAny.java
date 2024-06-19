package dev.stan.interview_tasks.TwoLists;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TwoListsAny extends TwoLists{

    @Override
    public Set<Integer> getIndexes(int count, List<Integer> diff) {
        Set<Integer> indexes = diff.stream()
                                    .collect(Collectors.toMap(k -> k, v -> diff.indexOf(v)))
                                    .entrySet().stream()
                                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                                    .limit(count)
                                    .map(e -> e.getValue())
                                    .collect(Collectors.toSet());
        return indexes;
    }
    
}
