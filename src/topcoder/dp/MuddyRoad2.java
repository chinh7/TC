package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/29/13
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MuddyRoad2 {
    static final int MOD = 555555555;
    public int theCount(int N, int muddyCount){
        int[][][] dp = new int[N][muddyCount+1][3];
        dp[0][0][1] = 1;
        for(int i=1; i<N; i++){
            int bound = Math.min(i, muddyCount);
            for(int j=0; j<=bound; j++){
                for(int r=0; r<3; r++){
                    dp[i][j][r] = (dp[i][j][r]+dp[i-1][j][(r-1+3)%3])%MOD;
                    if(i>1 && j>0 && r!=2) dp[i][j][1] = (dp[i][j][1]+dp[i-2][j-1][(r-2+3)%3])%MOD;
                }
            }
        }
        int[][] C = new int[N-1][muddyCount+1];
        for(int i=0; i<=N-2; i++){
            int bound = Math.min(i, muddyCount);
            for(int j=0; j<=bound; j++){
                if(j==0) C[i][j] = 1; else C[i][j] = (C[i-1][j]+C[i-1][j-1])%MOD;
            }
        }
        int odd = (dp[N-1][muddyCount][1]+dp[N-1][muddyCount][2])%MOD;
        return (C[N-2][muddyCount]-odd+MOD)%MOD;
    }
}
