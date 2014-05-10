package topcoder;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by chinh on 5/10/14.
 */
public class CandidatesSelectionEasy {
    class Data{
        String string;
        int index;
        public Data(String string, int index){
            this.string = string;
            this.index = index;
        }
    }
    public int[] sort(String[] score, int X){
        final int x = X;
        int n = score.length;
        Data[] data = new Data[n];
        for(int i=0; i<n; i++){
            data[i] = new Data(score[i], i);
        }
        Arrays.sort(data, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.string.charAt(x)!=o2.string.charAt(x)) return o1.string.charAt(x)-o2.string.charAt(x);
                return o1.index-o2.index;
            }
        });
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = data[i].index;
        }
        return result;
    }
}
