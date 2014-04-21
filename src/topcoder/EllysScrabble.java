package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 4/15/14.
 */
public class EllysScrabble {
    public String getMin(String S, int L){
        char[] s = S.toCharArray();
        int[] indices = new int[s.length];
        for(int i=0; i<s.length; i++) indices[i]=i;
        for(int i=0; i<s.length-1; i++){
            int minIndex=i;
            for(int j=i+1; j<=Math.min(i+L,s.length-1); j++){
                if(s[minIndex]>s[j]){
                    minIndex = j;
                }
            }
            if(i-indices[i]<L){
                for(int j=minIndex; j>i; j--){
                    char tmp=s[j];
                    s[j]=s[j-1];
                    s[j-1]=tmp;
                    int tmp2 = indices[j];
                    indices[j]=indices[j-1];
                    indices[j-1]=tmp2;
                }
            }
        }
        return new String(s);
    }
}
