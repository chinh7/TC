package topcoder.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/10/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class EqualTowers {
    public int height(int[] bricks){
        int n = bricks.length;
        int max = 0;
        for(int height : bricks){
            max+=height;
        }
        max=max/2;
        int[] cur = new int[max+1];
        int[] pre = new int[max+1];
        Arrays.fill(pre, -1);
        pre[0] = 0;
        int result = -1;
        for(int i=0; i<n; i++){
            //cur[j] : the lower tower's max height when the towers' height difference is j
            Arrays.fill(cur, -1);
            int height = bricks[i];
            for(int j=0; j<=max; j++){
                if(pre[j]>=0){
                    if(j+height<=max) cur[j+height] = Math.max(cur[j+height], pre[j]);  //put the ith brick on top of the higher tower
                    int difference = Math.abs(j-height);
                    if(difference<=max){ //put the ith brick on top of the lower
                        int shorter = j>height ? height : j;
                        cur[difference] = Math.max(cur[difference], pre[j]+shorter);
                    }
                    if(j==height && result<cur[0]) result = cur[0];
                }
            }
            for(int j=0; j<=max; j++) pre[j] = cur[j];
        }
        return result;
    }
}
