package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/14/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Excavations2 {
    private static final int N = 50;
    public long count(int[] kind, int[] found, int K){
        int[] quantity = new int[N+1];
        for(int i=0; i<kind.length; i++) quantity[kind[i]]++;
        long[][] C = new long[N+1][N+1];
        for(int i=0; i<=N; i++){
            C[i][i] = 1;
            for(int j=0; j<i; j++) C[i][j] = C[i-1][j]*i/(i-j);
        }
        int n = found.length;
        long[][] dp = new long[n][K+1];
        int sum = quantity[found[0]];
        for(int total=1; total<=Math.min(K-(n-1),sum); total++) dp[0][total]=C[quantity[found[0]]][total];
        for(int i=1; i<n; i++){
            sum+=quantity[found[i]];
            for(int total=i+1; total<=Math.min(K-(n-i-1),sum); total++){
                for(int used=1; used<=Math.min(quantity[found[i]], total-i); used++){
                    dp[i][total] += dp[i-1][total-used]*C[quantity[found[i]]][used];
                }
            }
        }
        return dp[n-1][K];
    }
}
