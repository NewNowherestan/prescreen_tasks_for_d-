package dev.stan;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class DistributeThreadsSolution {
    static final Logger logger = LoggerFactory.getLogger(DistributeThreadsSolution.class);

    /*
     * 
     *  This linear aproach works in the following way:
     * 
     * 1. Filter the edge cases where coreCount is 0, threadCount is less than 2, or efCorePos is out of bounds.
     * 
     * 2. Calculate the maximum initial border value,
     *     the absolute distance from the efCorePos to the border
     *     and the initial ladder sum.
     *     
     *     It is called ladder because what it basicly does is calculate what range can be entered into the array
     *     and the sum of this range in a manner 
     *     ```
     *     [0, 1, 2, 3, 4] for 5 x>9 5 case 
     *     or [0, 1, 2, 3] for the 3 x>5 3
     *     ```
     *     The absBorderDist is adjusting the ladder like
     *     ```
     *     [0, 1, 2, 3, 0] for 5 x>5 4 case
     *     or [0, 1, 2, 0] for the 4 x>3 2 case
     *     ```
     * 
     * 3. If the calculated maxInitialBorderVal is greater than the threadCount, it means we are in a situation like
     *     ```
     *     [0, 0, 0, 1, 2] or [0, 1, 2, 1, 0] or [0, 1, 1, 1, 0]
     *     ```
     *     The reversed range sum formula is user to calculate the new value sum = n*(start+end)/2
     * 
     * 4. By subtracting the initial ladder threads count from the threadCount, we get values to be distributed
     *     The fill is essentially the number of times the range can be added to the array, substituting the iterational approach.
     *     
     *     In a case 5, 20, 5 -> the ladder sum is 10, the fill is (20 - 10) / 5(coreCount) = 2
     *     ```
     *     [0, 1, 2, 3, 4] - ladder
     *     [1, 2, 3, 4, 5] - ladder + fill
     *     [2, 3, 4, 5, 6] - ladder + 2*fill
     *     ```
     * 
     *     But we do not perform this operation on the whole array
     *     but just adding fill to the previously calculated value
     * 
     * This approach is O(1) and is the best solution for this problem i can think of this night.
     * 
     */
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
