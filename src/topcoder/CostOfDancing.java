package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 6/12/14.
 */
public class CostOfDancing {
    public int minimum(int K, int[] danceCost){
        Arrays.sort(danceCost);
        int result=0;
        for(int i=0; i<K; i++) result+=danceCost[i];
        return result;
    }
}
