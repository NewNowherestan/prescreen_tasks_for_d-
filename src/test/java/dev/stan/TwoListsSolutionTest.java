package dev.stan;
import org.junit.jupiter.api.Test;

import dev.stan.TwoListsSolution.TwoListsAny;
import dev.stan.TwoListsSolution.TwoListsWindow;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;


public class TwoListsSolutionTest {

    @Test
    public void twoListsWithWindowStrategy() {
        TwoListsWindow twoLists = new TwoListsWindow();

        for (InnerTwoListsTestData data : testData) {
            int result = twoLists.solve(data.count(), data.list1(), data.list2());
            assertThat(result)
                .as("Failed for %s", data)
                .isEqualTo(data.winResult());
        }
    }

    @Test
    public void twoListsWithAnytrategy() {
        TwoListsAny twoLists = new TwoListsAny();

        for (InnerTwoListsTestData data : testData) {
            int result = twoLists.solve(data.count(), data.list1(), data.list2());
            assertThat(result)
                .as("Failed for %s", data)
                .isEqualTo(data.anyResult());
        }
    }

    private record InnerTwoListsTestData(int count, List<Integer> list1, List<Integer> list2, int winResult, int anyResult) {
        public InnerTwoListsTestData(int count, List<Integer> list1, List<Integer> list2, int result) {
            this(count, list1, list2, result, result);
        }
    }

    static final List<InnerTwoListsTestData> testData = Arrays.asList(
        new InnerTwoListsTestData(3, Arrays.asList(80, 2, 3, 4, 100), Arrays.asList(6, 10, 8, 9, 7), 123, 202),
        new InnerTwoListsTestData(3, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 10, 8, 9, 7), 28),
        new InnerTwoListsTestData(3, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7, 8, 9, 10), 25),
        new InnerTwoListsTestData(2, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7, 8, 9, 10), 30),
        new InnerTwoListsTestData(1, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7, 8, 9, 10), 35),
        new InnerTwoListsTestData(1, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 5, 4, 3, 15), 34),
        new InnerTwoListsTestData(1, Arrays.asList(3), Arrays.asList(3), 3)
    );
}