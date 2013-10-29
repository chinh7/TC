package topcoder.dp;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/8/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectingMarbles {
    public int mostMarbles(int[] marblesWeights, int bagCapacity, int numberOfBags){
        int result = 0;
        for(int round=0; round<numberOfBags; round++){
            int[] dp = new int[bagCapacity+1];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            int length = marblesWeights.length;
            boolean[][] trace = new boolean[bagCapacity+1][];
            for(int i=0; i< marblesWeights.length; i++){
                int w = marblesWeights[i];
                for(int c=bagCapacity; c>=w; c--){
                    if(dp[c-w]>=0 && dp[c]<dp[c-w]+1){
                        dp[c]=dp[c-w]+1;
                        trace[c] = new boolean[length];
                        if(trace[c-w]!=null) for(int traceIndex=0; traceIndex<length; traceIndex++) trace[c][traceIndex] = trace[c-w][traceIndex];
                        trace[c][i] = true;
                    }
                }
            }

            int maxCapacity = 0;
            for(int c=1; c<=bagCapacity; c++){
                if(dp[maxCapacity] <= dp[c]){
                    maxCapacity = c;
                }
            }
            if(dp[maxCapacity]==0) return result;
            result+=dp[maxCapacity];

            int[] rest = new int[marblesWeights.length - dp[maxCapacity]];
            int j=0;
            for(int i=0; i< length; i++){
                if(!trace[maxCapacity][i]) rest[j++] = marblesWeights[i];
            }
            marblesWeights = rest;
        }
        return result;
    }
}
