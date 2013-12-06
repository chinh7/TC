package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/4/13
 * Time: 11:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoRepeatPlaylist {
    static final int MOD = (int)1e9+7;
    public int numPlaylists(int N, int M, int P){
        long[][] dp = new long[P+1][N+1];
        dp[0][0] = 1;
        for(int i=1; i<=P; i++){
            if(i<=M+1){
                if(i>N) return 0;
                dp[i][i] = dp[i-1][i-1]*(N-i+1)%MOD;
            } else{
                int bound = Math.min(N,i);
                for(int j=M+1; j<=bound; j++){
                    dp[i][j] = (dp[i-1][j]*(j-M)+dp[i-1][j-1]*(N-j+1))%MOD;
                }
            }
        }
        return (int)dp[P][N];
    }
}
