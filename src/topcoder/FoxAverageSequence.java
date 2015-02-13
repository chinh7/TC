package topcoder;

/**
 * Created by chinh on 21/11/2014.
 */
public class FoxAverageSequence {
    final int MAX=40;
    final int MOD=(int)1e9+7;
    public int theCount(int[] seq){
        int n = seq.length;
        int[][][] dp = new int[n*MAX+1][MAX+1][2];
        dp[0][0][0] = 1;
        int count=0;
        int lowerSum = 0;
        for(int i=0; i<n; i++){
            int[][][] tmp = new int[n*MAX+1][MAX+1][2];
            int curLow = seq[i]<0 ? 0 : seq[i];
            int curHigh = seq[i]<0 ? MAX : seq[i];
            int prevLow = i==0 || seq[i-1]<0 ? 0 : seq[i-1];
            int prevHigh = i==0 || seq[i-1]<0 ? MAX : seq[i-1];
            for(int sum=count*MAX+lowerSum; sum>=lowerSum; sum--){
                for(int cur=curLow; cur<=curHigh && cur*i<=sum; cur++){
                    for(int prev=prevLow; prev<=prevHigh; prev++){
                        if(cur>=prev){
                            tmp[sum+cur][cur][0] = (tmp[sum+cur][cur][0]+dp[sum][prev][0] + dp[sum][prev][1])%MOD;
                        } else{
                            tmp[sum+cur][cur][1] = (tmp[sum+cur][cur][1]+dp[sum][prev][0])%MOD;
                        }
                    }
                }
            }
            if(seq[i]<0) count++; else lowerSum+=seq[i];
            dp = tmp;
        }
        int ret=0;
        for(int sum=n*MAX; sum>=0; sum--){
            for(int i=0; i<=MAX; i++){
                ret = (ret+dp[sum][i][0]+dp[sum][i][1])%MOD;
            }
        }
        return ret;
    }
}
