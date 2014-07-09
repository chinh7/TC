package codility;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chinh on 5/25/14.
 */
public class Natrium {
    class Data{
        int value; int index;
        public Data(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public int solution(int[] A) {
        int n = A.length;
        Data[] data = new Data[n];
        for(int i=0; i<n; i++) data[i]=new Data(A[i],i);
        Arrays.sort(data, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.value!=o2.value) return o1.value-o2.value; else return o1.index-o2.index;
            }
        });
        int min=Integer.MAX_VALUE;
        int result=0;
        for(Data x : data){
            result = Math.max(result, x.index-min);
            min=Math.min(min, x.index);
        }
        return result;
    }
}
