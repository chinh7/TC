package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/27/13
 * Time: 10:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class PickGuitars {
    private int sum(int i, int j, int[] values){
        int ret = 0;
        while(i<=j){
            ret+=values[i];
            i++;
        }
        return ret;
    }
    public int maxValue(int[] guitarValues){
        int n = guitarValues.length-1;
        int[] values = new int[n];

        int result = 0;
        for(int first=0; first<n+1; first++){
            int oldIndex=first+1;
            while(oldIndex!=first){
                if(oldIndex==n+1) oldIndex=0;
                int newIndex = oldIndex-(first+1);
                if(newIndex<0) newIndex+=n+1;
                values[newIndex] = guitarValues[oldIndex];
                oldIndex++;
                if(oldIndex==n+1) oldIndex=0;
            }

            int[][] dp = new int[n][n];

            for(int l=1; l<=n; l++){
                for(int i=0; i<=n-l; i++){
                    int j=i+l-1;
                    int min = Integer.MAX_VALUE;
                    for(int pick=i; pick<=j; pick++){
                        int left = (pick>0) ? dp[i][pick-1] : 0;
                        int right = (pick<n-1) ? dp[pick+1][j] : 0;
                        min = Math.min(min, left+right);
                    }
                    dp[i][j]=sum(i,j,values) - min;
                }
            }
            result = Math.max(result, sum(0,n,guitarValues)-dp[0][n-1]);
        }
        return result;
    }
}
