package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/15/13
 * Time: 2:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class TheShuttles {
    public int getLeastCost(int[] cnt, int baseCost, int seatCost){
        int bound=0;
        for(int i=0; i<cnt.length; i++){
            bound = Math.max(bound, cnt[i]);
        }
        int result = Integer.MAX_VALUE;
        for(int i=1; i<=bound; i++){
            int cost = 0;
            for(int j=0; j<cnt.length; j++){
                cost+=cnt[j]/i+(cnt[j]%i>0?1:0);
            }
            cost*=(baseCost+i*seatCost);
            if(result>cost) result=cost;
        }
        return result;
    }
}
