package topcoder.dp;

import java.util.Arrays;

public class OrderOfTheHats {
    int INF = 1000000;
    private int prev(int i, int x){
        return (1<<i) ^ x;
    }
    private int bitCount(int x){
        int count = 0;
        while(x>0){
            count+=x%2;
            x/=2;
        }
        return count;
    }
    public int minChanged(String[] spellChart){
        int n = spellChart.length;
        int[] adj = new int[1<<n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(spellChart[i].charAt(j) == 'Y'){
                    adj[i] = adj[i] | 1 << j;
                }
            }
        }
        int[] dp = new int[1<<n];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=1; i<(1<<n); i++){
            for(int j=0; j<n; j++){
                int prev = prev(j, i);
                if(prev!=i){
                    dp[i] = Math.min(dp[i], dp[prev]+bitCount(i&adj[j]));
                }
            }
        }
        return dp[(1<<n)-1];
    }
}
