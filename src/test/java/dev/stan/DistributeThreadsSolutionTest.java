package dev.stan;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class DistributeThreadsSolutionTest {

    @Test
    public void testSolve() {
        DistributeThreadsSolution solution = new DistributeThreadsSolution();

        for (InnerDistributeThreadsTestData data : testData) {
            int result = solution.solve(data.coreCount(), data.threadCount(), data.efCorePos());
            assertThat(result)
                .as("Failed for %s", data)
                .isEqualTo(data.result());
        }

    }

    private record InnerDistributeThreadsTestData(int coreCount, int threadCount, int efCorePos, int result) {
    }

    private static final List<InnerDistributeThreadsTestData> testData = List.of(
        new InnerDistributeThreadsTestData(5, 3, 5, 2),
        new InnerDistributeThreadsTestData(5, 3, 3, 1),
        new InnerDistributeThreadsTestData(5, 11, 5, 4),
        new InnerDistributeThreadsTestData(5, 16, 2, 4)
    );
}