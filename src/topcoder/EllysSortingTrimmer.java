package topcoder;

import java.util.Arrays;

/**
 * Created by chinh on 4/14/14.
 */
public class EllysSortingTrimmer {
    public String getMin(String S, int L){
        char[] s = S.toCharArray();
        for(int i=s.length-L; i>=0; i--){
            Arrays.sort(s, i, i+L);
        }
        return new String(Arrays.copyOfRange(s, 0, L));
    }
}
