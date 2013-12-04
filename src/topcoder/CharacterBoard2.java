package topcoder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/2/13
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CharacterBoard2 {
    static final int MOD = (int)1e9+9;
    int pow(int a, int x){
        if(x==0) return 1;
        if(x%2==0){
            int i = pow(a, x/2);
            return (int) (((long)i*i)%MOD);
        } else{
            return (int) (((long)a*pow(a, x-1))%MOD);
        }
    }
    public int countGenerators(String[] fragment, int W, int i0, int j0){
        int n = fragment.length;
        int m = fragment[0].length();
        int result=0;
        for(int l=1; l<=W; l++){
            char[] string = new char[l];
            boolean valid = true;
            int filledCount = 0;
            for(int i=0; i<n; i++){
                if(!valid) break;
                for(int j=0; j<m; j++){
                    int index = (W*i+j)%l;
                    if(string[index]==0){
                        string[index]=fragment[i].charAt(j);
                        filledCount++;
                    } else
                    if(string[index]!=fragment[i].charAt(j)){
                        valid = false;
                        break;
                    }
                }
            }
            if(!valid) continue;
            result = (result+pow(26, l-filledCount))%MOD;
        }
        return result;
    }
}
