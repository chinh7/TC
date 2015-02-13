package topcoder;

/**
 * Created by chinh on 27/11/2014.
 */
public class MakeSquare {
    int calc(String a, String b){
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i==0) dp[i][j] = j; else
                if(j==0) dp[i][j] = i; else dp[i][j]=m+n;
                if(i==0 || j==0) continue;
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = dp[i-1][j-1]; else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        return dp[n][m];
    }
    public int minChanges(String S){
        int n = S.length();
        int ret = n;
        for(int l=1; l<n; l++){
            String a = S.substring(0, l);
            String b = S.substring(l);
            ret = Math.min(ret, calc(a,b));
        }
        return ret;
    }
}
