package topcoder;

/**
 * Created by chinh on 28/11/2014.
 */
public class SRMSystemTestPhase {
    final int MOD=(int)1e9+7;
    boolean next(int[] a){
        boolean hasNext = false;
        for(int i=0; i<a.length; i++){
            if(a[i]>=0 && a[i]<2) hasNext=true;
        }
        if(!hasNext) return hasNext;
        int carry = 1;
        for(int i=0; i<a.length; i++){
            if(a[i]>=0){
                a[i] = a[i]+carry;
                carry = a[i]/3;
                a[i] %= 3;
            }
        }
        return hasNext;
    }
    int[] getArray(String s){
        int[] a = new int[s.length()];
        for(int i=0; i<s.length(); i++) a[i] = s.charAt(i)=='Y' ? 0 : -1;
        return a;
    }
    public int countWays(String[] description){
        int[][][] dp = new int[4][4][4];
        dp[0][0][0] = 1;
        for(int e=0; e<description.length; e++){
            int[] a = getArray(description[e]);
            int[][][] tmp = new int[4][4][4];
            do{
                int[] count = new int[3];
                for(int i=0; i<a.length; i++){
                    if(a[i]>=0) count[a[i]]++;
                }
                int passedLowerBound = e==0 ? 0 : count[0];
                for(int passed = 3; passed>=passedLowerBound; passed--){
                    int challengedUpperBound = (passed==count[0]) ? count[1] : 3;
                    for(int challenged=0; challenged<=challengedUpperBound; challenged++){
                        for(int failed=0; failed<=3; failed++){
                            tmp[count[0]][count[1]][count[2]] = (tmp[count[0]][count[1]][count[2]]+dp[passed][challenged][failed])%MOD;
                        }
                    }
                }
            } while(next(a));
            dp = tmp;
        }
        int ret=0;
        for(int i=0; i<=3; i++){
            for(int j=0; j<=3; j++){
                for(int e=0; e<=3; e++) ret = (ret+dp[i][j][e])%MOD;
            }
        }
        return ret;
    }
}
