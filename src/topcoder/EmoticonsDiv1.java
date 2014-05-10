package topcoder;

/**
 * Created by chinh on 4/30/14.
 */
public class EmoticonsDiv1 {
    public int printSmiles(int n){
        int[] dp = new int[n+1];
        dp[1]=0;
        for(int i=2; i<=n; i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1; j<i; j++){
                int pasteCount = i%j==0 ? i/j-1 : i/j;
                int deleteCount = (pasteCount+1)*j-i;
                dp[i]=Math.min(dp[i],dp[j]+1+pasteCount+deleteCount);
            }
        }
        return dp[n];
    }
}
