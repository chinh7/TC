package topcoder;

/**
 * Created by chinh on 4/21/14.
 */
public class MyVeryLongCake {
    public int cut(int n){
        long result=0;
        int[] incr = {1,2};
        int last = n, r = n;
        for(int i=2; i*i<=n; i += i<5?incr[i%2]:6){
            if(last%i==0){
                result=n/i+(i-1)*result/i;
            }
            while(last%i==0) last/=i;
        }
        int i = last;
        if(i>1){
            result=n/i+(i-1)*result/i;
        }
        return (int)result;
    }
}
