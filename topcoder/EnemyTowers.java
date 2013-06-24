package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 6/24/13
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class EnemyTowers {
    private final int INF = Integer.MAX_VALUE;
    private int hp, attack;

    private int round(int units, int numTow){
        int pow = numTow*hp;
        int round = 0;
        while(true){
            round++;
            pow = pow - units;
            if(pow<=0) return round;
            numTow = pow/hp + (pow%hp==0 ? 0 : 1);
            units = units - numTow*attack;
            if(units<=0) return INF;
        }
    }

    public int attack(int myUnits, int hpT, int attackT, int numWodT, int numStoT){
        hp = hpT; attack=attackT;
        int low = 0, hi = myUnits;
        int best = INF;
        while(low<=hi){
            int mid = low+(hi-low)/2;
            int roundWod = round(mid, numWodT);
            int roundSto = round(myUnits-mid, numStoT);
            best = Math.max(roundWod, roundSto);

            if(roundSto==roundWod) break;
            if(roundWod<roundSto){
                hi = mid-1;
            } else{
                low = mid+1;
            }
        }
        return (best==INF? -1 : best);
    }
}
