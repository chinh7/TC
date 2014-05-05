package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 4/25/14.
 */
public class MovingRooksDiv2 {
    boolean find(int[] Y1, int[] Y2){
        int n=Y1.length;
        boolean found=true;
        for(int i=0; i<n; i++){
            if(Y1[i]!=Y2[i]) found=false;
        }
        if(found) return true;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(Y1[i]>Y1[j]){
                    int[] clone = Arrays.copyOf(Y1, n);
                    int tmp = clone[i];
                    clone[i]=clone[j];
                    clone[j]=tmp;
                    found |= find(clone, Y2);
                }
            }
        }
        return found;
    }
    public String move(int[] Y1, int[] Y2){
        if(find(Y1, Y2)) return "Possible"; else return "Impossible";
    }
}
