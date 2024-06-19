package dev.stan.interview_tasks.TwoLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public abstract class TwoLists {

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

        return totalSum;
    }
}
