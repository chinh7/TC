package topcoder;

/**
 * Created by chinh on 06/11/2014.
 */
public class FlatCatsBreeding {
    public int days(int D, int K, int T){
        int count = 1;
        int day = 0;
        int index=0;
        while(count<T){
            count+=count*K;
            day = (++index)*D;
        }
        return day;
    }
}
