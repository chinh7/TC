package topcoder;

/**
 * Created by chinh on 5/10/14.
 */
public class RandomGraph {
    public double probability(int n, int P){
        double p = P/1000.0;
        double[][] dp = new double[n+1][n+1];
        dp[1][0]=1;
        for(int count=1; count<n; count++){
            double[][] next = new double[n+1][n+1];
            for(int one=0; one<=count; one++){
                for(int two=0; two<=count; two++){
                    if(one+two*2<=count && (count-one-two*2)%3==0 && dp[one][two]!=0){
                        int three = (count-one-two*2)/3;
                        next[one+1][two] += dp[one][two]*Math.pow(1-p, count);
                        if(one>0) next[one-1][two+1] += one*dp[one][two]*p*Math.pow(1-p, count-1);
                        if(two>0) next[one][two-1] += two*2*dp[one][two]*p*Math.pow(1-p, count-1)+two*dp[one][two]*p*p*Math.pow(1-p, count-2);
                        if(one>1) next[one-2][two] += (one-1)*one/2*dp[one][two]*p*p*Math.pow(1-p, count-2);
                    }
                }
            }
            dp = next;
        }
        double result=0;
        for(int one=0; one<=n; one++){
            for(int two=0; two<=n; two++) {
                result += dp[one][two];
            }
        }
        result = 1-result;
        return result;
    }
}
