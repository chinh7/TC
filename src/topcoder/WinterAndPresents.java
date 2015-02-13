package topcoder;

/**
 * Created by chinh on 29/10/2014.
 */
public class WinterAndPresents {
    public long getNumber(int[] apple, int[] orange){
        int n = apple.length;
        int bound = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) bound = Math.min(bound, apple[i]+orange[i]);
        long ret=0;
        for(int x=1; x<=bound; x++){
            int minApple=0, maxApple=0;
            for(int i=0; i<n; i++){
                maxApple += Math.min(x, apple[i]);
                minApple += x - Math.min(x, orange[i]);
            }
            ret += maxApple - minApple + 1;
        }
        return ret;
    }
}
