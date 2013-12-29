package topcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: chinh
 * Date: 12/15/13
 * Time: 2:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class ORSolitaireDiv2 {
    public int getMinimum(int[] numbers, int goal){
        int n = numbers.length;
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=1; i<(1<<n); i++){
            int x=0;
            for(int j=0; j<n; j++){
                if((i&(1<<j))>0){
                    x|=numbers[j];
                }
            }
            if(x==goal){
                set.add(i);
            }
        }
        int result=0;
        while(true){
            int max = 0;
            int i=-1;
            for(int j=0; j<n; j++){
                int count = 0;
                for(int e : set){
                    if(((1<<j)&e)>0) count++;
                }
                if(max<count){
                    max=count;
                    i=j;
                }
            }
            if(i<0) break;
            for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
                Integer e = it.next();
                if(((1<<i)&e)>0) it.remove();
            }
            result++;
        }
        return result;
    }
}
