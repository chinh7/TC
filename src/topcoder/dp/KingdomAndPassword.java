package topcoder.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/28/13
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class KingdomAndPassword {

    int assertedCount(int n){
        int count = 0;
        while(n>0){
            count+=n%2;
            n/=2;
        }
        return count;
    }
    public long newPassword(long oldPassword, int[] restrictedDigits){
        int n = restrictedDigits.length;
        long[] upper = new long[1<<n];
        long[] lower = new long[1<<n];
        Arrays.fill(upper, -1);
        Arrays.fill(lower, -1);
        upper[0] = 0;
        lower[0] = 0;
        for(int i=1; i<(1<<n); i++){
            int assertedCount = assertedCount(i);
            long cap = oldPassword/(long)Math.pow(10, n-assertedCount);
            for(int d=0; d<n; d++){
                if((i&(1<<d)) != 0){
                    int j = i^(1<<d);
                    int digit = (int)((oldPassword/(long)Math.pow(10,d))%10);
                    if(restrictedDigits[assertedCount-1]!=digit){
                        ArrayList<Long> prevs = new ArrayList<Long>();
                        prevs.add(upper[j]); prevs.add(lower[j]);
                        for(long value : prevs){
                            if(value<0) continue;
                            long candidate = value*10+digit;
                            if(candidate>=cap){
                                if(upper[i]<0 || upper[i]-cap>candidate-cap){
                                    upper[i] = candidate;
                                }
                            }
                            if(candidate<=cap){
                                if(lower[i]<0 || cap-lower[i]>cap-candidate){
                                    lower[i] = candidate;
                                }
                            }
                        }
                    }
                }
            }
        }
        long l = lower[(1<<n)-1];
        long u = upper[(1<<n)-1];
        long result = Math.max(l,u);
        if(l>0 && u>0){
            if(u-oldPassword<oldPassword-l) result = u; else result = l;
        }
        return result;
    }
}
