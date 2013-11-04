package topcoder.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 10/31/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class FlippingBitsDiv2 {
    static final int MAX = 2501;
    static String inverted(String segment){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<segment.length(); i++){
            if(segment.charAt(i)=='0')
                sb.append('1');
            else
                sb.append('0');
        }
        return sb.toString();
    }
    static int simpleCost(String segment){
        int cost = 0;
        for(int i=0; i<segment.length(); i++){
            if(segment.charAt(i)=='0') cost++;
        }
        return cost;
    }
    static int bundleCost(String segment){
        return 1+simpleCost(inverted(segment));
    }
    public int getmin(String[] S, int M){
        StringBuilder sb = new StringBuilder();
        for(String s : S){
            sb.append(s);
        }
        String b = sb.toString();
        int n = b.length()/M;
        int[] f = new int[n];
        int[] s = new int[n];
        int[] forward = new int[n];
        int[] backward = new int[n];
        Arrays.fill(f, MAX);
        Arrays.fill(s, MAX);
        for(int i=0; i<n; i++){
            String segment = b.substring(i*M, (i+1)*M);
            if(i==0){
                s[i] = simpleCost(segment);
                f[i] = bundleCost(segment);
            } else{
                s[i] = Math.min(s[i-1]+simpleCost(segment), f[i-1]+simpleCost(segment));
                f[i] = Math.min(f[i-1]+bundleCost(segment)-1, s[i-1]+bundleCost(segment)+1);
            }
            forward[i] = Math.min(s[i], f[i]);
        }

        Arrays.fill(f, MAX);
        Arrays.fill(s, MAX);
        for(int i=n-1; i>=0; i--){
            String segment = b.substring(i*M, (i+1)*M);
            if(i==n-1){
                s[i] = simpleCost(segment);
                f[i] = bundleCost(segment);
            } else{
                s[i] = Math.min(s[i+1]+simpleCost(segment), f[i+1]+simpleCost(segment));
                f[i] = Math.min(f[i+1]+bundleCost(segment)-1, s[i+1]+bundleCost(segment)+1);
            }
            backward[i] = Math.min(s[i], f[i]);
        }
        int result = Math.min(forward[n-1], backward[0]);
        for(int i=0; i<n-1; i++){
            result = Math.min(result, forward[i]+backward[i+1]);
        }
        return result;
    }
}
