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
        //expected model {0,0,0,1,2} = 2
        new InnerDistributeThreadsTestData(5, 3, 5, 2),

        //expected model {0,1,1,1,1} = 1
        new InnerDistributeThreadsTestData(5, 3, 3, 1),

        //expected model {5} = 5
        new InnerDistributeThreadsTestData(1, 5, 1, 5),

        //expected model {0,0} = 0
        new InnerDistributeThreadsTestData(2, 0, 1, 0),

        //task examples
        //expected model {1,1,2,3,4} = 11
        new InnerDistributeThreadsTestData(5, 11, 5, 4),

        //expected model {4,4,3,3,2} = 4
        new InnerDistributeThreadsTestData(5, 16, 2, 4)
    );
}