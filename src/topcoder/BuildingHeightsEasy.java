package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 6/12/14.
 */
public class BuildingHeightsEasy {
    public int minimum(int M, int[] heights){
        Arrays.sort(heights);
        int n = heights.length;
        int result=Integer.MAX_VALUE;
        for(int i=0; i<n-M+1; i++){
            int sum=0;
            for(int j=i; j<i+M; j++) sum+=heights[i+M-1]-heights[j];
            result = Math.min(result, sum);
        }
        return result;
    }
}
