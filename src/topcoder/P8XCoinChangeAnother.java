package topcoder;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 11/7/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class P8XCoinChangeAnother {
    public long[] solve(int N, long coins_sum, long coins_count){
        long current = coins_sum;
        long[] result = new long[N];
        boolean completed = false;
        for(int i=0; i<N-1; i++){
            if(coins_count*2<current){
                result[i] = current%2;
                current = current/2;
                coins_count -= result[i];
            } else{
                current -= coins_count;
                result[i] = coins_count-current;
                result[i+1] = current;
                completed = true;
                break;
            }
        }
        if(!completed) result = new long[0];
        return result;
    }
}
