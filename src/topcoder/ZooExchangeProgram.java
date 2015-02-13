package topcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chinh on 28/11/2014.
 */
public class ZooExchangeProgram {
    public int getNumber(int[] labels, int lower, int upper){
        int n = labels.length;
        ArrayList<Integer> groupLabels = new ArrayList<Integer>();
        ArrayList<Long> groups = new ArrayList<Long>();
        for(int i=0; i<=n; i++){
            if(i<n && lower<=labels[i] && labels[i]<=upper) groupLabels.add(labels[i]); else{
                if(groupLabels.size()==0) continue;
                long group = 0;
                for(int label : groupLabels) group |= 1<<(label-1);
                groups.add(group);
                groupLabels.clear();
            }
        }
        n = groups.size();
        lower--; upper--;
        int ret = -1;
        for(int i=1; i<(1<<n); i++){
            int cur = 0;
            int count = 0;
            for(int j=0; j<n; j++){
                if(((i>>j)&1)>0){
                    cur |= groups.get(j);
                    count++;
                }
            }
            if(cur==(((1<<(upper-lower+1))-1)<<lower)){
                if(ret<0 || ret>count) ret=count;
            }
        }
        return ret;
    }
}
