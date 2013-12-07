package topcoder.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/7/13
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergersDivTwo {
    static final double undefined = 1e5;
    public double findMaximum(int[] revenues, int k){
        int m = revenues.length;
        Arrays.sort(revenues);
        double[] sum = new double[m];
        sum[0] = revenues[0];
        for(int i=1; i<m; i++) sum[i]=sum[i-1]+revenues[i];
        double[] best = new double[m];
        best[0] = revenues[0];
        for(int i=1; i<m; i++){
            best[i] = undefined;
            for(int j=k-1; j<=i; j++){
                if(best[i-j]!=undefined && (best[i]==undefined || best[i] < (sum[i]-sum[i-j]+best[i-j])/(j+1))){
                    best[i] = (sum[i]-sum[i-j]+best[i-j])/(j+1);
                }
            }
        }
        return best[m-1];
    }
}
