package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 29/10/2014.
 */
public class BigFatInteger {
    public int minOperations(int A, int B){
        int bound = (int)Math.sqrt(A);
        boolean[] isPrime = new boolean[bound+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i<=bound; i++){
            for(int j=2; i*j<=bound; i++) isPrime[i*j] = false;
        }
        int maxPower = 0;
        int ret = 0;
        for(int i=2; i<=bound; i++){
            if(isPrime[i]){
                int count=0;
                while(A%i==0){
                    A/=i;
                    count++;
                }
                if(count>0){
                    maxPower = Math.max(maxPower, count);
                    ret++;
                }
            }
        }
        if(A>1){
            maxPower = Math.max(maxPower, 1);
            ret++;
        }
        maxPower *= B;
        int power = (int)(Math.log(maxPower)/Math.log(2));
        ret += power + ((1<<power)==maxPower ? 0 : 1);
        return ret;
    }
}
