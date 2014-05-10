package topcoder;

import java.util.LinkedList;

/**
 * Created by chinh on 5/5/14.
 */
public class ChooseTheBestOne {
    public int countNumber(int N){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1; i<=N; i++) list.add(i);
        int cur=0;
        for(int i=1; i<N; i++){
            int target = (int)(cur+(long)i*i*i-1)%list.size();
            list.remove(target);
            cur=target%list.size();
        }
        return list.get(0);
    }
}
