package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 17/11/2014.
 */
public class FoxAndShogi {
    final int MOD = (int)1e9+7;
    int count(char[] a){
        int n = a.length;
        int[][] dp = new int[n+1][n+1];
        int i=0;
        Arrays.fill(dp[0], 1);
        for(int e=1; e<=n; e++){
            if(a[e-1]=='.') continue;
            i++;
            if(a[e-1]=='D'){
                for(int j=1; j<=n; j++) {
                    dp[i][j] = dp[i][j-1];
                    if(j>=e) dp[i][j] = (dp[i][j]+dp[i-1][j-1])%MOD;
                }
            } else{
                for(int j=1; j<=n; j++){
                    dp[i][j] = dp[i][j-1];
                    if(j<=e) dp[i][j] = (dp[i][j]+dp[i-1][j-1])%MOD;
                }
            }
        }
        return dp[i][n];
    }
    public int differentOutcomes(String[] board){
        int n = board.length;
        int m = board[0].length();
        long ret = 1;
        for(int j=0; j<m; j++){
            char[] a = new char[n];
            for(int i=0; i<n; i++){
                a[i] = board[i].charAt(j);
            }
            ret = (ret*count(a))%MOD;
        }
        return (int)ret;
    }
}
