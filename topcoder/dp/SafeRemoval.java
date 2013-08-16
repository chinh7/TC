package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 8/16/13
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class SafeRemoval {
    public int removeThem(int[] seq, int k){
        int[][] dp = new int[k+1][4];
        int[][] trace = new int[k+1][4];
        int n = seq.length;
        int sum = 0;
        for(int i=0; i<n; i++) sum+=seq[i];
        dp[0][sum%4] = sum;
        for(int i=0; i<n; i++){
            for(int j=k; j>0; j--){
                for(int r=0; r<4; r++){
                    int pr = (r+seq[i])%4;
                    if(dp[j-1][pr]!=0){
                        if(pr!=0 || seq[i]%4 != trace[j-1][pr]%4){
                            if(dp[j][r]<dp[j-1][pr]-seq[i]) dp[j][r] = dp[j-1][pr]-seq[i];
                            trace[j][r] = seq[i];
                        }
                    }

                }
            }
        }
        int result = 0;
        for(int r=1; r<4; r++){
            if(result<dp[k][r]) result = dp[k][r];
        }
        if(result==0) result = -1;
        return result;
    }
}
