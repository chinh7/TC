package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/6/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class TheCowDivTwo {
    static final int MOD = (int)1e9+7;
    public int find(int N, int K){
        int[][] dp = new int[K+1][N];
        dp[0][0] = 1;
        for(int i=0; i<N; i++){
            for(int k=K-1; k>=0; k--){
                for(int remainder=0; remainder<N; remainder++){
                    if(dp[k][remainder]!=0){
                        dp[k+1][(remainder+i)%N] = (dp[k+1][(remainder+i)%N]+dp[k][remainder])%MOD;
                    }
                }
            }
        }
        return dp[K][0];
    }
}
