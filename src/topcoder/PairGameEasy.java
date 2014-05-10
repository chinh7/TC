package topcoder;

/**
 * Created by chinh on 5/10/14.
 */
public class PairGameEasy {
    public String able(int a, int b, int c, int d){
        boolean[][] dp = new boolean[c+1][d+1];
        if(a<=c && b<=d) dp[a][b]=true;
        for(int i=a; i<=c; i++){
            for(int j=b; j<=d; j++){
                if(dp[i][j]){
                    if(i+j<=c) dp[i+j][j] = true;
                    if(j+i<=d) dp[i][j+i]=true;
                }
            }
        }
        return dp[c][d] ? "Able to generate" : "Not able to generate";
    }
}
