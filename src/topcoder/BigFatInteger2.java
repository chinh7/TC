package topcoder;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/5/13
 * Time: 1:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class BigFatInteger2 {
    void getPrimes(int n, HashMap<Integer, Integer> prime){
        int i=2;
        int orig = n;
        while(n!=1 && i*i<=orig){
            int count = 0;
            while(n%i==0){
                n/=i;
                count++;
            }
            if(count>0) prime.put(i,count);
            i++;
        }
        if(n>1) prime.put(n, 1);
    }
    public String isDivisible(int A, int B, int C, int D){

        HashMap<Integer, Integer> primeA = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> primeC = new HashMap<Integer, Integer>();
        getPrimes(A, primeA);
        getPrimes(C, primeC);

        for(Integer i : primeC.keySet()){
            if(!primeA.containsKey(i)) return "not divisible";
            if((long)B*primeA.get(i) < (long)D*primeC.get(i)) return "not divisible";
        }
        return "divisible";
    }
}
