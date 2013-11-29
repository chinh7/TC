package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/14/13
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringWeightDiv2 {
    static final int N = 26;
    static final int MOD = 1000000009;
    private int conMul(int m, int n){
        long result = 1;
        for(int i=m; i<=n; i++) result = (result * i)%MOD;
        return (int) result;
    }
    public long countMinimums(int L){
        long[][] dp = new long[N+1][L+1];
        dp[0][0] = 1;
        //dp[2][5] -> number of sols x1+x2=5 has xi>0
        for(int i=1; i<=N; i++){
            //goes through all the slots
            for(int total=i; total<=L-(N-i); total++){
                for(int e=1; e<=total-i+1; e++){
                    dp[i][total] = (dp[i][total] + dp[i-1][total-e])%MOD;
                }
            }
        }
        if(L<=N) return conMul(N-L+1,N); else return (int) ((conMul(1,N)*dp[N][L])%MOD);
    }
}
