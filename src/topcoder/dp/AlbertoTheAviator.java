package topcoder.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chinh on 4/30/14.
 */
public class AlbertoTheAviator {
    public int MaximumFlights(int F, int[] duration, int[] refuel){
        int n = duration.length;
        int[][] sorted = new int[n][2];
        for(int i=0; i<n; i++){
            sorted[i][0]=duration[i];
            sorted[i][1]=refuel[i];
        }
        Arrays.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=F;
        for(int i=0; i<n; i++){
            for(int count=n-1; count>=0; count--){
                if(dp[count]>=0){
                    if(dp[count]>=sorted[i][0]){
                        dp[count+1]=Math.max(dp[count+1],dp[count]-sorted[i][0]+sorted[i][1]);
                    }
                }
            }
        }
        for(int i=n; i>=0; i--){
            if(dp[i]>=0){
                return i;
            }
        }
        return -1;
    }
}
