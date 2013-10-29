package topcoder;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/18/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamContest {
    public int worstRank(int[] strength){
        int n = strength.length;
        Arrays.sort(strength, 3, n);
        boolean[] done = new boolean[n];
        int s = Math.max(strength[0],Math.max(strength[1],strength[2]))+Math.min(strength[0],Math.min(strength[1],strength[2]));
        int result = 1;
        for(int i=n-1; i>=3; i--){
            boolean found = false;
            if(!done[i]){
                done[i] = true;
                for(int j=3; j<i-1; j++){
                    if(!done[j] && strength[i]+strength[j] > s){
                        done[j] = true;
                        done[j+1] = true;
                        found = true;
                        result++;
                        break;
                    }
                }
            }
            if(!found) break;
        }
        return result;
    }
}
