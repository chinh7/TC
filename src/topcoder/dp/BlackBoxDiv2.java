package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/29/13
 * Time: 2:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class BlackBoxDiv2 {
    static final int MOD = (int)1e9+7;
    public int count(String front, String side){
        front = front.replaceAll("\\.","");
        side = side.replaceAll("\\.","");
        int n = front.length();
        int m = side.length();
        if(n==0 && m==0) return 1;
        if(n==0 || m==0) return 0;

        long[][] dp = new long[n][m+1];
        long[][] C = new long[m+1][m+1];
        for(int i=0; i<=m; i++){
            C[i][0] = 1;
            for(int j=1; j<=i; j++) C[i][j]= (C[i-1][j]+C[i-1][j-1])%MOD;
        }
        for(int covered=1; covered<=m; covered++){
            dp[0][covered] = C[m][covered];
        }
        for(int i=1; i<n; i++){
            for(int covered=1; covered<=m; covered++){
                int uncovered = m-covered;
                for(int x=0; x<=uncovered; x++){
                    for(int y=0; y<=covered; y++){
                        if(x+y==0) continue;
                        dp[i][covered+x] = (dp[i][covered+x]+C[uncovered][x]*(C[covered][y]*dp[i-1][covered]%MOD))%MOD;
                    }
                }
            }
        }
        return (int)dp[n-1][m];
    }
}
