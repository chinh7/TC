package topcoder.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/23/13
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringSystems {
    public String isEquivalent(int[] c, int[] s){
        int n = c.length;
        int max = 0;
        for(int i=0; i<n; i++){
            max+=c[i];
        }
        int[] b = new int[max+1];
        Arrays.fill(b, -1);
        b[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=max-c[i]; j>=0; j--){
                if(b[j]>=0){
                    if(b[c[i]+j]<0){
                        b[c[i]+j] = b[j]+s[i];
                    } else{
                        if(b[c[i]+j] != b[j]+s[i]) return "Not Equivalent";
                    }
                }
            }
        }
        int prev = -1;
        for(int i=0; i<=max; i++){
            if(b[i]>=0){
                if(b[i]<=prev) return "Not Equivalent";
                prev = b[i];
            }
        }
        return "Equivalent";
    }
}
