package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/29/13
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class BadSubstring {
    public long howMany(int length){
        if(length == 0) return 1;
        long[][] dp = new long[length+1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for(int i=2; i<=length; i++){
            dp[i][0] += dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
            dp[i][1] += dp[i-1][1]+dp[i-1][2];
            dp[i][2] += dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
        }
        return dp[length][0]+dp[length][1]+dp[length][2];
    }
}
