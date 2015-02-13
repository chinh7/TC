package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 06/11/2014.
 */
public class RabbitNumbering {
    final int MOD = (int)1e9+7;
    public int theCount(int[] maxNumber){
        Arrays.sort(maxNumber);
        long ret = 1;
        for(int i=0; i<maxNumber.length; i++){
            if(maxNumber[i]<0) return 0;
            ret *= (maxNumber[i]-i)%MOD;
        }
        return (int) ret;
    }
}
