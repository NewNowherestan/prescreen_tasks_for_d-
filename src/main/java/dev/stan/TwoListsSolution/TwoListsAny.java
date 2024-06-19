package dev.stan.TwoListsSolution;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoListsAny extends TwoListsAbstractSolution {

    @Override
    public Set<Integer> getIndexes(int count, List<Integer> diff) {
        Set<Integer> indexes = IntStream.range(0, diff.size())
                                    .boxed()
                                    .collect(Collectors.toMap(i -> i, diff::get))
                                    .entrySet().stream()
                                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                                    .limit(count)
                                    .map(e -> e.getKey())
                                    .collect(Collectors.toSet());
        
        return indexes;
    }
    
}
