package dev.stan;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class DistributeThreadsSolution {
    static final Logger logger = LoggerFactory.getLogger(DistributeThreadsSolution.class);

    public int solve(int coreCount, int threadCount, int efCorePos) {
        if (coreCount == 0) {
            return 0;
        }
        if (threadCount < 2) {
            return threadCount;
        }
        if (efCorePos > coreCount || efCorePos < 1) {
            return 0;
        }

        int maxInitialBorderVal = coreCount - 1;
        int absBorderDist = Math.min(coreCount - efCorePos, efCorePos - 1);
        int initLadderSum = (coreCount - absBorderDist) * (coreCount > 1 ? 2 : 1);

        
        if (maxInitialBorderVal > threadCount) {
            int maxCand = (int) Math.sqrt(2*threadCount);
            maxInitialBorderVal = maxCand * (maxCand + 1) == 2*threadCount ? maxCand : maxCand - 1;
            
            initLadderSum = threadCount;
        }
        
        int initVal = maxInitialBorderVal - absBorderDist;

        if (initVal < 1) {
            initVal = 1;
        }
        
        int fill = (threadCount - initLadderSum) / coreCount;

        int res = initVal + fill;

        String logMsg = String.format("\u001B[36m coreCount: %d, threadCount: %d, efCorePos: %d,\n" +
                                        "\u001B[34m maxInitialBorderVal: %d, absBorderDist: %d, initLadderSum: %d,\n" + 
                                        "\u001B[32m initVal: %d, fill: %d, res: %d",
                                      coreCount, threadCount, efCorePos,
                                      maxInitialBorderVal, absBorderDist,
                                      initLadderSum, initVal, fill, res);
        logger.info(() -> "\u001B[32m ---DistributeThreadsSolution.solve--- \n" + logMsg + "\n");

        return res;
    }

}
