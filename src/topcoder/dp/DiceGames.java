package topcoder.dp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 7/30/13
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class DiceGames {
    public long countFormations(int[] sides){
        Arrays.sort(sides);
        int n = sides[sides.length-1];
        long[] prev = new long[n];
        long[] cur = new long[n];
        prev[0] = 1;
        int size = 1;
        for(int side : sides){
            for(int i=0; i<size; i++){
                for(int j=i; j<side; j++){
                    cur[j] = cur[j]+prev[i];
                }
            }
            size = side;
            prev = Arrays.copyOf(cur, n);
            Arrays.fill(cur, 0);
        }
        long result = 0;
        for(int i=0; i<n; i++){
            result+=prev[i];
        }
        return result;
    }
}
