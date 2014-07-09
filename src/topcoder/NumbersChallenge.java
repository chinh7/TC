package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 5/20/14.
 */
public class NumbersChallenge {
    public int MinNumber(int[] S){
        int n = S.length;
        Arrays.sort(S);
        int prevSum=-1;
        for(int i=0; i<(1<<n); i++){
            int j=i;
            int index=0;
            int sum=0;
            while(j!=0){
                if(j%2==1){
                    sum+=S[index];
                }
                index++;
                j/=2;
            }
            if(prevSum>=0){
                if(sum>prevSum+1) return prevSum+1;
            }
            prevSum=sum;
        }
        return prevSum+1;
    }
}
