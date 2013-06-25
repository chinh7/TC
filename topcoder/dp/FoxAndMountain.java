package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/25/13
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoxAndMountain {
    private final int CAP = 1000000009;
    public int count(int n, String history){
        if(n%2==1) return 0;
        int[][] dp;
        int result = 0;
        for(int start=0; start<=n-history.length(); start++){
            dp = new int[n+1][n+1];
            dp[0][0] = 1;
            for(int length=1; length<=n; length++){
                for(int height=0; height<=n-length; height++){
                    if(length%2 == height%2){
                        if(length>start && length<=start+history.length()){
                            int step = length-start-1;
                            if(history.charAt(step)=='U') dp[length][height] = (height>0 ? dp[length-1][height-1] : 0);
                            else dp[length][height]+= (height<n ? +dp[length-1][height+1] : 0);
                        } else{
                            dp[length][height] = (height>0 ? dp[length-1][height-1] : 0);
                            dp[length][height]+= (height<n ? +dp[length-1][height+1] : 0);
                        }
                    }
                }
            }
            result += dp[n][0];
        }

//        for(int i=0; i<=n; i++){
//            for(int j=0; j<=n; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        return result;
    }
}
