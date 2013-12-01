package topcoder.dp;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/1/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class AliceBobShuffle {
    static final int MOD=(int)1e9+7;
    public int countWays(int[] AliceStart, int[] BobStart, int[] AliceEnd, int[] BobEnd){
        int asn = AliceStart.length;
        int bsn = BobStart.length;
        int aen = AliceEnd.length;
        int ben = BobEnd.length;
        if(asn+bsn!=aen+ben) return 0;
        int length = asn+bsn;
        int[][][][] dp = new int[asn+1][bsn+1][aen+1][ben+1];  //-> could be reduced to [][][] with the observation that once the first three are determined, there's only one possible value for the last one.
        dp[0][0][0][0] = 1;
        for(int l=1; l<=length; l++){
            for(int asi=Math.max(0, l-bsn); asi<=Math.min(asn,l); asi++){
                int bsi = l-asi;
                for(int aei=Math.max(0, l-ben); aei<=Math.min(aen, l); aei++){
                    int bei = l-aei;
//                    System.out.println(asi+","+bsi+" and "+aei+","+bei);

                    if(asi>0 && aei>0 && AliceStart[asn-asi]==AliceEnd[aen-aei])
                        dp[asi][bsi][aei][bei] = (dp[asi][bsi][aei][bei]+dp[asi-1][bsi][aei-1][bei])%MOD;

                    if(asi>0 && bei>0 && AliceStart[asn-asi]==BobEnd[ben-bei])
                        dp[asi][bsi][aei][bei] = (dp[asi][bsi][aei][bei]+dp[asi-1][bsi][aei][bei-1])%MOD;

                    if(bsi>0 && aei>0 && BobStart[bsn-bsi]==AliceEnd[aen-aei])
                        dp[asi][bsi][aei][bei] = (dp[asi][bsi][aei][bei]+dp[asi][bsi-1][aei-1][bei])%MOD;

                    if(bsi>0 && bei>0 && BobStart[bsn-bsi]==BobEnd[ben-bei])
                        dp[asi][bsi][aei][bei] = (dp[asi][bsi][aei][bei]+dp[asi][bsi-1][aei][bei-1])%MOD;

                }
            }
        }
        return dp[asn][bsn][aen][ben];
    }
}
