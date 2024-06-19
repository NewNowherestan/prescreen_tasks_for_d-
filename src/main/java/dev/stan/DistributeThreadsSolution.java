package dev.stan;

public class DistributeThreadsSolution {

    public int solve(int coreCount, int threadCount, int efCorePos) {
        int maxInitialBorderVal = coreCount - 1;
        int absBorderDist = Math.min(coreCount - efCorePos, efCorePos - 1);

        int initVal = maxInitialBorderVal - absBorderDist;
        
        int initLadderSum = (coreCount - absBorderDist) * 2;
        int fill = (threadCount - initLadderSum) / 2;

        int res = initVal + fill;

        System.out.println("absBorderDist: " + absBorderDist);
        System.out.println("initVal: " + initVal);

        System.out.println("initLadderSum: " + initLadderSum);
        System.out.println("fill: " + fill);

        return res;
    }

}
