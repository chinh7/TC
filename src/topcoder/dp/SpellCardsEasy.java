package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 8/14/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpellCardsEasy {
    public int maxDamage(int[] level, int[] damage){
        int n = level.length;
        int[] dp = new int[n];
        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(dp[i]<dp[j] && j+level[j]-1<i){
                    dp[i] = dp[j];
                }
            }
            if(i+level[i]-1<n){
                dp[i]+=damage[i];
            }
            if(result<dp[i]) result = dp[i];
        }
        return result;
    }
}
